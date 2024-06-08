import java.math.BigDecimal;

public class DiscreteMaths {


    public DiscreteMaths() {
    }

    BigDecimal[] x;
    int grado = 3;

    public DiscreteMaths(BigDecimal[] x, int grado) {
        this.x = x;
        this.grado = grado;


    }


    public BigDecimal[][] getMatrizAdjunta(BigDecimal[][] x) {
        int n = x.length;
        BigDecimal[][] matrizAdjunta = new BigDecimal[n][n];
        int p = (1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrizAdjunta[i][j] = BigDecimal.valueOf(p);
                p *= -1;
            }

            if(x.length%2==0)p *= -1;

        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                BigDecimal[][] matrizDeterminante = getMatrizDeterminante(x, i, j);

                matrizAdjunta[i][j] = (matrizAdjunta[i][j].multiply(getDeterminante(matrizDeterminante)));
                if(x.length==2)if (matrizAdjunta[i][j].compareTo(BigDecimal.ZERO)>0) {
                    matrizAdjunta[i][j]=matrizAdjunta[i][j].add(BigDecimal.valueOf(1));
                }else  matrizAdjunta[i][j]=matrizAdjunta[i][j].add(BigDecimal.valueOf(-1));

            }
        }


        return matrizAdjunta;
    }

    //Obtencion Matriz
    public BigDecimal[][] getMatrizDeterminante(BigDecimal[][] x, int n, int m) {
        int p = x.length;
        BigDecimal[][] matrizDeterminante = new BigDecimal[p - 1][p - 1];

        int pow = (int) Math.pow(p - 1, 2);

        BigDecimal[] matriz = new BigDecimal[pow];

        int acumulador = 0;

        for (int i = 0; i < p; i++) {
            for (int j = 0; j < p; j++) {
                if (!(i == n || j == m)) {
                    matriz[acumulador] = x[i][j];
                    acumulador++;
                }
            }
        }
        acumulador = 0;
        for (int i = 0; i < (p - 1); i++) {
            for (int j = 0; j < p - 1; j++) {

                matrizDeterminante[i][j] = matriz[acumulador];
                acumulador++;

            }
        }


        return matrizDeterminante;


    }

    public BigDecimal[][] getMatrizX(BigDecimal[] n, int grado) {
        BigDecimal[][] matriz = new BigDecimal[n.length][grado + 1];

        for (int i = 0; i < n.length; i++) {
            for (int j = 0; j <= grado; j++) {


                BigDecimal p = (n[i].pow(j));
                matriz[i][j] = p;
            }
        }


        return matriz;
    }

    //Obtencion Matriz Transpuesta
    public BigDecimal[][] getMatrizTransp(BigDecimal[][] n, int grado, boolean root) {

        int p = 0, b = 1;

        int length = n.length;
        if (root) {
            p++;
            b--;
        } else {
            grado = length;
        }
        BigDecimal[][] matrizT = new BigDecimal[grado + p][length];

        for (int i = 0; i <= grado - b; i++) {
            for (int j = 0; j < length; j++)
                matrizT[i][j] = n[j][i];
        }
        return matrizT;
    }

    public BigDecimal getDeterminante(BigDecimal[][] x) {

        BigDecimal determinante = BigDecimal.valueOf(0);


        if (x.length == 4) {


            // Regla extendida para matrices 4x4
            BigDecimal a = x[0][0];//(0,0)
            BigDecimal b = x[0][1];
            BigDecimal c = x[0][2];
            BigDecimal d = x[0][3];
            BigDecimal e = x[1][0];
            BigDecimal f = x[1][1];//(1,1)
            BigDecimal g = x[1][2];
            BigDecimal h = x[1][3];
            BigDecimal i = x[2][0];
            BigDecimal j = x[2][1];
            BigDecimal k = x[2][2];//(2,2)
            BigDecimal l = x[2][3];
            BigDecimal m = x[3][0];
            BigDecimal n = x[3][1];
            BigDecimal o = x[3][2];
            BigDecimal p = x[3][3];//(3,3)
            determinante = a.multiply(f).multiply(k).multiply(p)
                    .subtract(a.multiply(f).multiply(l).multiply(o))
                    .subtract(a.multiply(g).multiply(j).multiply(p))
                    .add(a.multiply(g).multiply(l).multiply(n))
                    .add(a.multiply(h).multiply(j).multiply(o))
                    .subtract(a.multiply(h).multiply(k).multiply(n))
                    .subtract(b.multiply(e).multiply(k).multiply(p))
                    .add(b.multiply(e).multiply(l).multiply(o))
                    .add(b.multiply(g).multiply(i).multiply(p))
                    .subtract(b.multiply(g).multiply(l).multiply(m))
                    .subtract(b.multiply(h).multiply(i).multiply(o))
                    .add(b.multiply(h).multiply(k).multiply(m))
                    .add(c.multiply(e).multiply(j).multiply(p))
                    .subtract(c.multiply(e).multiply(l).multiply(n))
                    .subtract(c.multiply(f).multiply(i).multiply(p))
                    .add(c.multiply(f).multiply(l).multiply(m))
                    .add(c.multiply(h).multiply(i).multiply(n))
                    .subtract(c.multiply(h).multiply(j).multiply(m))
                    .subtract(d.multiply(e).multiply(j).multiply(o))
                    .add(d.multiply(e).multiply(k).multiply(n))
                    .add(d.multiply(f).multiply(i).multiply(o))
                    .subtract(d.multiply(f).multiply(k).multiply(m))
                    .subtract(d.multiply(g).multiply(i).multiply(n))
                    .add(d.multiply(g).multiply(j).multiply(m));
        } else {

            int n = x.length;
            int m = x.length;
            if (m == 2) m--;


            BigDecimal[] vectorA = new BigDecimal[m];
            BigDecimal[] vectorB = new BigDecimal[m];

            //llenar vectorA con 1 positivos


            for (int i = 0; i < m; i++)
                vectorA[i] = BigDecimal.valueOf(1);
            for (int i = 0; i < m; i++)
                vectorB[i] = BigDecimal.valueOf(-1);
            //rellenar los datos con sus diagonales respectivos


            int contadorA = 0;
            int contadorB = 0;


            //Genera la multiplicacion de las diagonales


            for (int i = 0; i < n; i++) {

                for (int j = 0; j < n; j++) {
                    contadorB++;
                    if (contadorA >= m) contadorA = 0;
                    if (contadorB >= m) contadorB = 0;

                    if (m == 1) {
                        if (j == i) vectorA[contadorA] = vectorA[contadorA].multiply(x[i][j]);
                        else vectorB[contadorB] = vectorB[contadorB].multiply(x[i][j]);
                    } else {
                        vectorA[contadorA] = vectorA[contadorA].multiply(x[i][j]);
                        vectorB[contadorB] = vectorB[contadorB].multiply(x[i][j]);
                    }
                    contadorA++;
                }
                contadorA--;
                contadorB++;


            }


            for (BigDecimal s : vectorA) {
                determinante = determinante.add(s);
            }
            for (BigDecimal s : vectorB) {
                determinante = determinante.add(s);
            }

        }

        return determinante;
    }


    //getDeterminante


}