import java.util.ArrayList;

public class DescriptiveTable {
    public DescriptiveTable() {
    }


    public static int getFrecuenciaAbsoluta(double[] datos, double[] conjuntoValores) {
        int frecuencia=0;

        for (int i=0;i<datos.length;i++){
            for (int j=0;j<conjuntoValores.length;j++){
                if (datos[i]==conjuntoValores[j]) frecuencia++;
            }
        }

        return frecuencia;
    }

    public double getPuntoMedio(double limiteInferior, double limiteSuperior) {
        return (limiteInferior + limiteSuperior) / 2.0;
    }

    public double getFrecuenciaAcumulada(double frecuenciaA, double frecuentenciaActual) {
        return frecuenciaA + frecuentenciaActual;
    }

    public double getFrecuenciaRelativa(double[] datos, double frecuencia) {



        return  (frecuencia / datos.length);
    }


    public static double getFrecuenciaRelativaAcumulada(double frecuenciaRelativaAntes, double frecuenciaRelativaActual) {


        return frecuenciaRelativaAntes + frecuenciaRelativaActual;
    }


    public static double getPorcentaje(double frecuenciaRelativa) {
        return frecuenciaRelativa * 100.0;
    }

    public boolean getRepeatValor(double dato, ArrayList<Double> datos){

        for (double data:datos){
            if (dato==data) return false;

        }
        return true;
    }

    public double[] getConjuntoValores(double[] datos, double valorInferior, double valorSuperior, boolean posicionFinal) {
        ArrayList<Double> conjuntovalores = new ArrayList<>();

        for (double dato : datos) {

            if (posicionFinal) {
                if (dato >= valorInferior && dato <= valorSuperior) if (getRepeatValor(dato,conjuntovalores))conjuntovalores.add(dato);
            }
            else if (dato >= valorInferior && dato < valorSuperior) if (getRepeatValor(dato,conjuntovalores))conjuntovalores.add(dato);


        }
        int i=0;
        double[] conjuntodatos=new double[conjuntovalores.size()];
        for (double dato: conjuntovalores){
            conjuntodatos[i]=dato;
            i++;
        }
        return conjuntodatos;
    }


    public double[][] getTablaDescriptiva(double[][] clases, double[] datos) {
        double[][] tablaDescriptiva = new double[clases.length][9];
        int frecuenciaAcumulada = 0;
        double frecuenciaRelativaAcumulada = 0;
        for (int i = 0; i < clases.length; i++) {

            for (int j = 0; j < 9; j++) {

                switch (j) {

                    case 0:
                        tablaDescriptiva[i][j] = i+1;//numero de clases
                        break;
                    case 1:
                        tablaDescriptiva[i][j] = clases[i][0];//limite inferior
                        break;
                    case 2:
                        tablaDescriptiva[i][j] = clases[i][1];//limite superior
                        break;
                    case 3:
                        boolean datofinal = false;
                        if (i + 1 == clases.length) datofinal = true;
                        double[] valorDatos=getConjuntoValores(datos,clases[i][0],clases[i][1],datofinal);
                        tablaDescriptiva[i][j] = getFrecuenciaAbsoluta(datos, valorDatos);//frecuencia
                        break;
                    case 4:
                        tablaDescriptiva[i][j] = getPuntoMedio(clases[i][0], clases[i][1]);
                        break;
                    case 5:

                        frecuenciaAcumulada = (int) getFrecuenciaAcumulada(frecuenciaAcumulada, tablaDescriptiva[i][3]);
                        tablaDescriptiva[i][j] = frecuenciaAcumulada;
                        break;
                    case 6:
                        tablaDescriptiva[i][j] = getFrecuenciaRelativa(datos, tablaDescriptiva[i][3]);
                        break;
                    case 7:

                        frecuenciaRelativaAcumulada =  getFrecuenciaRelativaAcumulada(frecuenciaRelativaAcumulada, tablaDescriptiva[i][6]);
                        tablaDescriptiva[i][j] = frecuenciaRelativaAcumulada;
                        break;
                    case 8:
                        tablaDescriptiva[i][j] = getPorcentaje(tablaDescriptiva[i][7]);
                        break;
                }


            }

        }
        return tablaDescriptiva;


    }


}