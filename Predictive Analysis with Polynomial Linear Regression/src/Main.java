import java.math.BigDecimal;

public class Main {


    public static void main(String[] args) {
        DataSet dataSet = new DataSet();
        DiscreteMaths dm = new DiscreteMaths();
        PolynomialRegression pr = new PolynomialRegression();
        BigDecimal[][] conjuntoDataSetX= new BigDecimal[5][];

        BigDecimal [][][] conjuntoDataSetY=new BigDecimal[5][][];




        for (int i=0;i<conjuntoDataSetX.length;i++){
            conjuntoDataSetX[i]=dataSet.getX(i+1);
            conjuntoDataSetY[i]=dataSet.getY(i+1);
        }


        for (int i=0;i<conjuntoDataSetX.length;i++){

            System.out.println("------------------------------------------------------Fitted Line Plot------------------------------------------------------");
            for (int j=1;j<=3;j++){
                System.out.println();
                System.out.println("Grado: "+j);

                BigDecimal[][] matriz = dm.getMatrizX(conjuntoDataSetX[i], j);
                BigDecimal[][] matrizTranspuesta=dm.getMatrizTransp(matriz,j,true);
                BigDecimal[][] matrizXTranspX=pr.getXtranpX(matriz,matrizTranspuesta,j);
                BigDecimal[][] matrizInversa =pr.getMatrizInversa(matrizXTranspX);
                BigDecimal[][] matrizXtranspY=pr.getMultiplicacionMatrices(matrizTranspuesta,conjuntoDataSetY[i]);

                BigDecimal[][] bMayor=pr.getMultiplicacionMatrices(matrizInversa, matrizXtranspY);
                BigDecimal rSquared= pr.rSquared(conjuntoDataSetY[i],conjuntoDataSetX[i],bMayor,j);
                BigDecimal r=pr.r(rSquared);
                System.out.println();
                System.out.println("R_Squared: "+ rSquared+"                      r: "+r);

                switch (j){
                    case 1:
                        System.out.println("Machine Efficiency %= "+bMayor[0][0]+" + "+bMayor[1][0]+" Batch Size");

                        for (int p=0;p<5;p++){
                            BigDecimal xIncognit= BigDecimal.valueOf(65).add(BigDecimal.valueOf(p));
                            System.out.println("Si X= "+xIncognit);
                            BigDecimal yB0= bMayor[0][0];
                            BigDecimal yB1=bMayor[1][0].multiply(xIncognit);
                            System.out.println("YHat= "+yB0.add(yB1));
                        }
                        System.out.println();
                        break;



                    case 2:
                        System.out.println("Machine Efficiency %= "+bMayor[0][0]+" + "+bMayor[1][0]+" Batch Size "+bMayor[2][0]+" Batch Size^2");

                        for (int p=0;p<5;p++){
                            BigDecimal xIncognit= BigDecimal.valueOf(65).add(BigDecimal.valueOf(p));
                            System.out.println("Si X= "+xIncognit);
                            BigDecimal yB0= bMayor[0][0];
                            BigDecimal yB1=bMayor[1][0].multiply(xIncognit);
                            BigDecimal yB2=bMayor[2][0].multiply(xIncognit.pow(2));

                            System.out.println("YHat= "+yB0.add(yB1).add(yB2));
                        }
                        System.out.println();
                        break;
                    case 3:
                        System.out.println("Machine Efficiency %= "+bMayor[0][0]+" + "+bMayor[1][0]+" Batch Size "+bMayor[2][0]+" Batch Size^2 "+bMayor[3][0]+" Batch Size^3");
                        for (int p=0;p<5;p++){
                            BigDecimal xIncognit= BigDecimal.valueOf(65).add(BigDecimal.valueOf(p));
                            System.out.println("Si X= "+xIncognit);
                            BigDecimal yB0= bMayor[0][0];
                            BigDecimal yB1=bMayor[1][0].multiply(xIncognit);
                            BigDecimal yB2=bMayor[2][0].multiply(xIncognit.pow(2));
                            BigDecimal yB3=bMayor[3][0].multiply(xIncognit.pow(3));
                            System.out.println("YHat= "+yB0.add(yB1).add(yB2).add(yB3));
                        }
                        System.out.println();
                        break;
                }
            }

        }

    }
}