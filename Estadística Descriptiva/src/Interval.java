class Interval {

    private double lowerBound;
    private double upperBound;
    private int frequency;
    private int cumulativeFrequency;
    private double relativeFrequency;
    private double cumulativeRelativeFrequency;

    public Interval(double lowerBound, double upperBound, int frequency) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        this.frequency = frequency;
    }

    public String getLabel() {
        return String.format("%.0f - %.0f", lowerBound, upperBound);
    }

    public int getFrequency() {
        return frequency;
    }

    public void setCumulativeFrequency(int cumulativeFrequency) {
        this.cumulativeFrequency = cumulativeFrequency;
    }

    public void calculateRelativeFrequency(int totalDataPoints) {
        this.relativeFrequency = (double) this.frequency / totalDataPoints;
    }

    public void calculateCumulativeRelativeFrequency(int totalDataPoints) {
        this.cumulativeRelativeFrequency = (double) this.cumulativeFrequency / totalDataPoints;
    }

    public int getCumulativeFrequency() {
        return cumulativeFrequency;
    }

    public double getRelativeFrequency() {
        return relativeFrequency;
    }

    public double getCumulativeRelativeFrequency() {
        return cumulativeRelativeFrequency;
    }

    public double getMidpoint() {
        return (lowerBound + upperBound) / 2;
    }

    public double getPercentage() {
        return relativeFrequency * 100;
    }
}