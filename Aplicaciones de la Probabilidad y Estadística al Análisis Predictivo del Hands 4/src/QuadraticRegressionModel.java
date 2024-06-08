
class QuadraticRegression {
    private double[] coefficients;

    public QuadraticRegression(Dataset dataset) {
        DiscreteMaths dm = new DiscreteMaths(dataset.getX(), dataset.getY());
        double sumX = dm.SumX();
        double sumY = dm.SumY();
        double sumX2 = dm.SumX2();
        double sumX3 = dm.SumX3();
        double sumX4 = dm.SumX4();
        double sumXY = dm.SumXY();
        double sumX2Y = dm.SumX2Y();
        double n = dataset.getX().length;

        double[][] matrix = {
                {n, sumX, sumX2},
                {sumX, sumX2, sumX3},
                {sumX2, sumX3, sumX4}
        };

        double[] constants = {sumY, sumXY, sumX2Y};

        coefficients = solveSystem(matrix, constants);
    }

    private double[] solveSystem(double[][] matrix, double[] constants) {
        int n = constants.length;
        double[] solution = new double[n];
        for (int i = 0; i < n; i++) {
            double max = matrix[i][i];
            int maxRow = i;
            for (int k = i + 1; k < n; k++) {
                if (matrix[k][i] > max) {
                    max = matrix[k][i];
                    maxRow = k;
                }
            }
            double[] temp = matrix[i];
            matrix[i] = matrix[maxRow];
            matrix[maxRow] = temp;

            double t = constants[i];
            constants[i] = constants[maxRow];
            constants[maxRow] = t;

            for (int k = i + 1; k < n; k++) {
                double factor = matrix[k][i] / matrix[i][i];
                constants[k] -= factor * constants[i];
                for (int j = i; j < n; j++) {
                    matrix[k][j] -= factor * matrix[i][j];
                }
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            solution[i] = constants[i] / matrix[i][i];
            for (int k = i - 1; k >= 0; k--) {
                constants[k] -= matrix[k][i] * solution[i];
            }
        }
        return solution;
    }

    public double[] getCoefficients() {
        return coefficients;
    }

    public double predict(double x) {
        return coefficients[2] * x * x + coefficients[1] * x + coefficients[0];
    }
}
