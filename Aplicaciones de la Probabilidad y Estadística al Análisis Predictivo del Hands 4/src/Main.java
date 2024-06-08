public class Main {
    public static void main(String[] args) {
        double[] xValues = {1, 2, 3, 4, 5};
        double[] yValues = {2.3, 3.5, 4.7, 5.9, 7.1}; // Ejemplo de valores

        Dataset dataset = new Dataset(xValues, yValues);
        QuadraticRegression regression = new QuadraticRegression(dataset);

        double[] coefficients = regression.getCoefficients();
        System.out.println("Ecuación de Regresión Cuadrática:");
        System.out.printf("y = %.2fx^2 + %.2fx + %.2f\n", coefficients[2], coefficients[1], coefficients[0]);

        System.out.println("Predicciones:");
        double[] unknownXValues = {6, 7, 8}; // Valores desconocidos
        for (double x : unknownXValues) {
            double predictedY = regression.predict(x);
            System.out.printf("Para x = %.2f, y = %.2f\n", x, predictedY);
        }
    }
}