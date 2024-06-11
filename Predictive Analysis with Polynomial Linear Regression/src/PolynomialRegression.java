import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Arrays;

public class PolynomialRegression {
    private BigDecimal[] coefficients;
    private int degree;

    public PolynomialRegression(BigDecimal[] x, BigDecimal[][] y, int degree) {
        this.degree = degree;
        this.coefficients = calculateCoefficients(x, y, degree);
    }

    private BigDecimal[] calculateCoefficients(BigDecimal[] x, BigDecimal[][] y, int degree) {
        int n = x.length;
        BigDecimal[][] X = new BigDecimal[n][degree + 1];
        BigDecimal[][] Y = y;


        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= degree; j++) {
                X[i][j] = x[i].pow(j);
            }
        }


        BigDecimal[][] XT = transpose(X);
        BigDecimal[][] XTX = multiply(XT, X);


        BigDecimal[][] XTY = multiply(XT, Y);


        BigDecimal[][] XTX_inv = invert(XTX);
        BigDecimal[][] coefficients = multiply(XTX_inv, XTY);


        BigDecimal[] coeff = new BigDecimal[coefficients.length];
        for (int i = 0; i < coefficients.length; i++) {
            coeff[i] = coefficients[i][0];
        }

        return coeff;
    }

    private BigDecimal[][] transpose(BigDecimal[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        BigDecimal[][] transposed = new BigDecimal[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposed[j][i] = matrix[i][j];
            }
        }
        return transposed;
    }

    BigDecimal[][] multiply(BigDecimal[][] A, BigDecimal[][] B) {
        int aRows = A.length;
        int aCols = A[0].length;
        int bCols = B[0].length;
        BigDecimal[][] result = new BigDecimal[aRows][bCols];
        for (int i = 0; i < aRows; i++) {
            for (int j = 0; j < bCols; j++) {
                result[i][j] = BigDecimal.ZERO;
                for (int k = 0; k < aCols; k++) {
                    result[i][j] = result[i][j].add(A[i][k].multiply(B[k][j]));
                }
            }
        }
        return result;
    }

    BigDecimal[][] invert(BigDecimal[][] matrix) {
        int n = matrix.length;
        BigDecimal[][] identity = new BigDecimal[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(identity[i], BigDecimal.ZERO);
            identity[i][i] = BigDecimal.ONE;
        }

        BigDecimal[][] augmented = new BigDecimal[n][2 * n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                augmented[i][j] = matrix[i][j];
                augmented[i][j + n] = identity[i][j];
            }
        }


        for (int i = 0; i < n; i++) {
            BigDecimal pivot = augmented[i][i];
            for (int j = 0; j < 2 * n; j++) {
                augmented[i][j] = augmented[i][j].divide(pivot, MathContext.DECIMAL128);
            }
            for (int k = 0; k < n; k++) {
                if (k != i) {
                    BigDecimal factor = augmented[k][i];
                    for (int j = 0; j < 2 * n; j++) {
                        augmented[k][j] = augmented[k][j].subtract(factor.multiply(augmented[i][j]));
                    }
                }
            }
        }

        BigDecimal[][] inverse = new BigDecimal[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                inverse[i][j] = augmented[i][j + n];
            }
        }

        return inverse;
    }

    public BigDecimal predict(BigDecimal x) {
        BigDecimal result = BigDecimal.ZERO;
        for (int i = 0; i <= degree; i++) {
            result = result.add(coefficients[i].multiply(x.pow(i)));
        }
        return result;
    }

    public void printEquation() {
        StringBuilder equation = new StringBuilder("y = ");
        for (int i = degree; i >= 0; i--) {
            equation.append(coefficients[i].setScale(4, RoundingMode.HALF_UP).toString());
            if (i > 0) {
                equation.append(" * x");
                if (i > 1) {
                    equation.append("^").append(i);
                }
                equation.append(" + ");
            }
        }
        System.out.println(equation.toString());
    }
}
