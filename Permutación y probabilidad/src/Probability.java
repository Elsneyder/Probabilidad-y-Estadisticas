public class Probability {
    private DataSetPermutation datasetPermutation;

    public Probability(DataSetPermutation datasetPermutation) {
        this.datasetPermutation = datasetPermutation;
    }

    public double getMarginalProbability(String event) {
        String[] x2 = datasetPermutation.getX2();
        int count = 0;
        for (String s : x2) {
            if (s.equals(event)) {
                count++;
            }
        }
        return (double) count / x2.length;
    }

    public double getJointProbability(String event1, String event2) {
        String[] x2 = datasetPermutation.getX2();
        int count = 0;
        for (int i = 0; i < x2.length - 1; i++) {
            if (x2[i].equals(event1) && x2[i + 1].equals(event2)) {
                count++;
            }
        }
        return (double) count / (x2.length - 1);
    }

    public double getConditionalProbability(String event1, String event2) {
        double jointProb = getJointProbability(event1, event2);
        double marginalProb = getMarginalProbability(event2);
        if (marginalProb == 0) return 0;
        return jointProb / marginalProb;
    }
}