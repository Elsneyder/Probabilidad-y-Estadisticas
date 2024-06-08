import java.util.List;

class DescriptiveStatistics {

    private List<Interval> intervals;
    private int totalFrequency;

    public DescriptiveStatistics(List<Interval> intervals) {
        this.intervals = intervals;
        this.totalFrequency = intervals.stream().mapToInt(Interval::getFrequency).sum();
    }

    public void calculateStatistics() {
        int cumulativeFrequency = 0;

        for (Interval interval : intervals) {
            cumulativeFrequency += interval.getFrequency();
            interval.setCumulativeFrequency(cumulativeFrequency);
            interval.calculateRelativeFrequency(totalFrequency);
            interval.calculateCumulativeRelativeFrequency(totalFrequency);
        }
    }

    public void printDescriptiveTable() {
        System.out.printf("%10s %15s %10s %10s %10s %10s %10s %10s%n",
                "Clase", "Limite de clase", "Frecuencia", "Punto Medio", "Fa", "fr", "fra", "Porcentaje");

        for (int i = 0; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);
            System.out.printf("%10d %15s %10d %10.2f %10d %10.2f %10.2f %10.2f%%%n",
                    (i + 1),
                    interval.getLabel(),
                    interval.getFrequency(),
                    interval.getMidpoint(),
                    interval.getCumulativeFrequency(),
                    interval.getRelativeFrequency(),
                    interval.getCumulativeRelativeFrequency(),
                    interval.getPercentage());
        }

        System.out.printf("%10s %15s %10d %10s %10s %10.2f %10s %10s%n",
                "TOTAL", "", totalFrequency, "", "", 1.0, "", "100%");
    }
}