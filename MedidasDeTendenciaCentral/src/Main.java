
public class Main {
    public static void main(String[] args) {

        DataSet dataSet = new DataSet();
        DescriptiveStatics descriptiveStatics = new DescriptiveStatics();
        DescriptiveTable descriptiveTable = new DescriptiveTable();

        double[][] conjuntoDataSet = new double[1][];


        for (int i = 0; i < conjuntoDataSet.length; i++) {
            conjuntoDataSet[i] = dataSet.getDataset(i + 1);
        }

        for (int i=0;i<conjuntoDataSet.length;i++){
            DatosNoagrupaods Umct= new DatosNoagrupaods();
            double mediaNoAgrupado=Umct.getMedia(conjuntoDataSet[i]);
            double medianaNoAgrupado=Umct.getMediana(conjuntoDataSet[i]);
            double modaNoAgrupado=Umct.getModa(conjuntoDataSet[i]);
            System.out.println("Datos No Agrupados:");
            // for (int k = 0; k < conjuntoDataSet[i].length; k++)
            //  System.out.print();
            double[] arreglo=conjuntoDataSet[i];
            for (int k = 0; k < conjuntoDataSet[i].length; k++)
                System.out.print(arreglo[k]+", ");
            System.out.println();
            System.out.println("Media: "+mediaNoAgrupado);
            System.out.println("Mediana: "+medianaNoAgrupado);
            System.out.println("Moda: "+modaNoAgrupado);


            double rango = descriptiveStatics.getRango(conjuntoDataSet[i]);
            int intervalo = descriptiveStatics.getIntervalo(conjuntoDataSet[i]);
            int amplitud = descriptiveStatics.getAmplitud(intervalo, rango);
            double[][] clases = descriptiveStatics.getClases(conjuntoDataSet[i], intervalo, amplitud);

            System.out.println();
            System.out.println();
            System.out.println("Rango: "+rango+"     Intervalo: "+intervalo+"      Numero de Clases: "+clases.length+"      Amplitud: "+amplitud+"            CantidadDatos: "+conjuntoDataSet[i].length);


            double[][] DescriptiveTable = descriptiveTable.getTablaDescriptiva(clases, conjuntoDataSet[i]);

            //obtener frecuencia que esta en la posicion 7

            double[]frecuencias= new double[DescriptiveTable.length];
            double[]puntosMedios=new double[DescriptiveTable.length];
            double[] limitesInferiores= new double[DescriptiveTable.length];

            for (int f=0;f<DescriptiveTable.length;f++)
                frecuencias[f]=DescriptiveTable[f][3];
            for (int f=0;f<DescriptiveTable.length;f++)
                puntosMedios[f]=DescriptiveTable[f][4];
            for (int f=0;f<DescriptiveTable.length;f++)
                limitesInferiores[f]=DescriptiveTable[f][1];

            DatosAgrupados Mct= new DatosAgrupados();

            double mediaAgrupado=Mct.getMedia(frecuencias,puntosMedios);
            double medianaAgrupado=Mct.getMediana(frecuencias,limitesInferiores,amplitud);
            double modaAgrupado=Mct.getModa(frecuencias,limitesInferiores,amplitud);















            String[] s = {"Clases", "Limiteinferior", "LimiteSuperior", "Frecuencia", " PuntoMedio", "FrecuenciaAcumulada", "FrecuenciaRelativa", "FrecuenciaRelativaAcum", "Porcentaje"};
            System.out.println("Clases          Limiteinferior          LimiteSuperior          Frecuencia             PuntoMedio          FrecuenciaAcumulada          FrecuenciaRelativa          FrecuenciaRelativaAcum          Porcentaje");
            for (int k = 0; k < DescriptiveTable.length; k++) {
                for (int l = 0; l < 9; l++) {
                    double value = DescriptiveTable[k][l];
                    System.out.print(value);

                    int numEspacios = s[l].length() - (String.valueOf(value).length());

                    for (int m = 0; m <= numEspacios+9; m++) {
                        System.out.print(" ");
                    }

                }

                System.out.println();
            }
            System.out.println("Datos Agrupados:");
            System.out.println("Media: "+mediaAgrupado);
            System.out.println("Mediana: "+medianaAgrupado);
            System.out.println("Moda: "+modaAgrupado);
            System.out.println();


        }




        return;
    }
}