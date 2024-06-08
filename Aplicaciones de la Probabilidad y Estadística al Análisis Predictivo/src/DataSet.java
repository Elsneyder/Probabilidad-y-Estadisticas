import java.util.ArrayList;

class Observation {
    private double sales;
    private double advertising;

    public Observation(double sales, double advertising) {
        this.sales = sales;
        this.advertising = advertising;
    }

    public double getSales() {
        return sales;
    }

    public double getAdvertising() {
        return advertising;
    }
}

class DataSet {
    private ArrayList<Observation> observations;

    public DataSet(ArrayList<Observation> observations) {
        this.observations = observations;
    }

    public ArrayList<Observation> getObservations() {
        return observations;
    }
}