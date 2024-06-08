public class LinearRegressionModel {
    private double beta0;
    private double beta1;

    public LinearRegressionModel(double beta0, double beta1) {
        this.beta0 = beta0;
        this.beta1 = beta1;
    }

    public double predict(double advertising) {
        return beta0 + beta1 * advertising;
    }

    public void printEquation() {
        System.out.println("Regression Equation: Sales = " + beta0 + " + " + beta1 + " * Advertising");
    }

    public static void main(String[] args) {
        // Ejemplo de uso de la clase LinearRegressionModel
        LinearRegressionModel model = new LinearRegressionModel(100, 2);
        System.out.println("Prediction for advertising 30: " + model.predict(30));
    }
}
