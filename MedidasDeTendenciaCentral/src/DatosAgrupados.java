public class DatosAgrupados {

    public DatosAgrupados(){}

    public double getMedia(double[] frecuencias, double[] puntosMedios) {
        double sumaTotal = 0;
        double totalFrecuencias = 0;

        // Calcular la suma total (fi * xi)
        for (int i = 0; i < frecuencias.length; i++) {
            sumaTotal += frecuencias[i] * puntosMedios[i];
            totalFrecuencias += frecuencias[i];
        }

        // Calcular la media
        double media = sumaTotal / totalFrecuencias;

        return media;
    }

    public double getMediana(double[] frecuencias, double[] limitesInferiores, double amplitud) {
        double totalFrecuencias = 0;
        int n = frecuencias.length;

        // Calcular el total de frecuencias
        for (double frecuencia : frecuencias) {
            totalFrecuencias += frecuencia;
        }

        // Calcular la posición de la mediana
        double posicionMediana = totalFrecuencias / 2;

        // Encontrar la clase que contiene la mediana
        int claseMediana = -1;
        double frecuenciaAcumuladaAnterior = 0;
        for (int i = 0; i < n; i++) {
            frecuenciaAcumuladaAnterior += frecuencias[i];
            if (frecuenciaAcumuladaAnterior >= posicionMediana) {
                claseMediana = i;
                break;
            }
        }

        // Calcular la mediana
        double limiteInferior = limitesInferiores[claseMediana];
        double frecuenciaClaseMediana = frecuencias[claseMediana];
        double frecuenciaAcumuladaAnteriorClaseMediana = frecuenciaAcumuladaAnterior - frecuenciaClaseMediana;
        double mediana = limiteInferior + ((posicionMediana - frecuenciaAcumuladaAnteriorClaseMediana) * amplitud / frecuenciaClaseMediana);

        return mediana;
    }

    public double getModa(double[] frecuencias, double[] limitesInferiores, double amplitud) {
        int n = frecuencias.length;

        // Encontrar la clase modal
        double limiteInferior = 0;
        double frecuenciaModal = frecuencias[0];
        double frecuenciaModalAfter=0,frecuenciaModalBefore=0;

        for (int i = 0; i < n; i++) {
            if (frecuenciaModal<=frecuencias[i]){
                frecuenciaModal=frecuencias[i];
                limiteInferior = limitesInferiores[i];
                if (i!=0)frecuenciaModalBefore=frecuencias[i-1];
                if(i!=n-1)frecuenciaModalAfter=frecuencias[i+1];
            }
        }

        // Calcular la moda
        double p1=(frecuenciaModal - frecuenciaModalBefore);
        double p2=(frecuenciaModal - frecuenciaModalAfter);
        double moda = limiteInferior+(p1/(p1+p2))*amplitud;


        return moda;
    }
}