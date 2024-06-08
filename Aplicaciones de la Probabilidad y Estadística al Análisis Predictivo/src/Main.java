import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Construir el DataSet (hardcoded)
        ArrayList<Observation> observations = new ArrayList<>();
        observations.add(new Observation(651, 23));
        observations.add(new Observation(762, 26));
        observations.add(new Observation(856, 30));
        observations.add(new Observation(1063, 34));
        observations.add(new Observation(1190, 43));
        observations.add(new Observation(1298, 48));
        observations.add(new Observation(1421, 52));
        observations.add(new Observation(1440, 57));
        observations.add(new Observation(1518, 58));

        DataSet dataSet = new DataSet(observations);

        // Calcular los coeficientes de regresión (beta0 y beta1)
        double sumX = 0;
        double sumY = 0;
        double sumXY = 0;
        double sumXSquare = 0;
        int n = dataSet.getObservations().size();

        for (Observation observation : dataSet.getObservations()) {
            double x = observation.getAdvertising();
            double y = observation.getSales();
            sumX += x;
            sumY += y;
            sumXY += x * y;
            sumXSquare += x * x;
        }

        double beta1 = (n * sumXY - sumX * sumY) / (n * sumXSquare - sumX * sumX);
        double beta0 = (sumY - beta1 * sumX) / n;

        // Crear el modelo de regresión lineal
        LinearRegressionModel model = new LinearRegressionModel(beta0, beta1);

        // Imprimir la ecuación de regresión
        model.printEquation();

        // Realizar predicciones
        double[] advertisingValues = {35, 40, 45, 50, 55};
        for (double advertising : advertisingValues) {
            double predictedSales = model.predict(advertising);
            System.out.println("Predicted sales for advertising " + advertising + ": " + predictedSales);
        }

        // Usar la función DiscretMaths para calcular el factorial de 5
        int factorialResult = DiscretMaths.factorial(5);
        System.out.println("Factorial of 5: " + factorialResult);
    }
}
