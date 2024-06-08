public class DescriptiveStatics {

    public DescriptiveStatics() {
    }

    public double[] getMinimoMaximo(double[] x){

        double[] valMinMax = {x[0],x[0]};

        for (int i = 0; i < x.length; i++) {
            if (valMinMax[0] < x[i]) valMinMax[0] = x[i];
            if (valMinMax[1] > x[i]) valMinMax[1] = x[i];
        }
        return valMinMax;
    }



    public double getRango(double[] x) {
        double rango = 0;
        double[] MinMax=getMinimoMaximo(x);
        rango = MinMax[0] - MinMax[1];

        return rango;
    }

    public int getIntervalo(double[] x) {
        double k = 1 + Math.log(x.length) / Math.log(2);
        int nClases = (int) Math.round(k);
        return nClases;
    }

    public int getAmplitud(int k, double rango){
        return (int) Math.round(rango/k);
    }

    public double[][] getClases(double[] x, int k, int amplitud) {
        double[] valMin = getMinimoMaximo(x);
        double[][] clases = new double[k][2];

        double intervalo = valMin[1];
        for (int i = 0; i < k; i++) {

            clases[i][0] = intervalo;
            intervalo += amplitud;
            clases[i][1] = intervalo;

        }


        return clases;

    }

}