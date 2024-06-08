class DiscreteMaths {
    double sum = 0;
    private double[] x, y;

    public DiscreteMaths(double[] x, double[] y) {
        this.x = x;
        this.y = y;
    }

    public double[] getX() {
        return x;
    }

    public double[] getY() {
        return y;
    }

    public double SumX() {
        sum = 0;
        for (double i : x)
            sum += i;
        return sum;
    }

    public double SumY() {
        sum = 0;
        for (double i : y)
            sum += i;
        return sum;
    }

    public double SumX2() {
        sum = 0;
        for (double i : x)
            sum += Math.pow(i, 2);
        return sum;
    }

    public double SumX3() {
        sum = 0;
        for (double i : x)
            sum += Math.pow(i, 3);
        return sum;
    }

    public double SumX4() {
        sum = 0;
        for (double i : x)
            sum += Math.pow(i, 4);
        return sum;
    }

    public double SumXY() {
        sum = 0;
        int s = 0;
        for (double i : x) {
            sum += i * y[s];
            s++;
        }
        return sum;
    }

    public double SumX2Y() {
        sum = 0;
        int s = 0;
        for (double i : x) {
            sum += Math.pow(i, 2) * y[s];
            s++;
        }
        return sum;
    }
}