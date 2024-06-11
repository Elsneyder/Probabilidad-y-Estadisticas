import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        DataSet dataSet = new DataSet();

        // Linear regression
        PolynomialRegression linearRegression = new PolynomialRegression(dataSet.getX(1), dataSet.getY(1), 1);
        System.out.println("Linear Regression Equation:");
        linearRegression.printEquation();
        for (BigDecimal value : new BigDecimal[]{BigDecimal.valueOf(50), BigDecimal.valueOf(75), BigDecimal.valueOf(100), BigDecimal.valueOf(125), BigDecimal.valueOf(150)}) {
            System.out.println("Predicted value for x = " + value + " is y = " + linearRegression.predict(value));
        }

        // Quadratic regression
        PolynomialRegression quadraticRegression = new PolynomialRegression(dataSet.getX(1), dataSet.getY(1), 2);
        System.out.println("Quadratic Regression Equation:");
        quadraticRegression.printEquation();
        for (BigDecimal value : new BigDecimal[]{BigDecimal.valueOf(50), BigDecimal.valueOf(75), BigDecimal.valueOf(100), BigDecimal.valueOf(125), BigDecimal.valueOf(150)}) {
            System.out.println("Predicted value for x = " + value + " is y = " + quadraticRegression.predict(value));
        }

        // Cubic regression
        PolynomialRegression cubicRegression = new PolynomialRegression(dataSet.getX(1), dataSet.getY(1), 3);
        System.out.println("Cubic Regression Equation:");
        cubicRegression.printEquation();
        for (BigDecimal value : new BigDecimal[]{BigDecimal.valueOf(50), BigDecimal.valueOf(75), BigDecimal.valueOf(100), BigDecimal.valueOf(125), BigDecimal.valueOf(150)}) {
            System.out.println("Predicted value for x = " + value + " is y = " + cubicRegression.predict(value));
        }
    }
}
