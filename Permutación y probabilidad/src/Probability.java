public class Probability {
    private DataSetPermutation datasetPermutation;
    private DataSetProbability datasetProbability;

    public Probability(DataSetPermutation datasetPermutation, DataSetProbability datasetProbability) {
        this.datasetPermutation = datasetPermutation;
        this.datasetProbability = datasetProbability;
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
        int[][] x1 = datasetProbability.getX1();
        int count = 0;
        int total = 0;

        for (int[] row : x1) {
            for (int value : row) {
                total += value;
            }
        }

        for (int i = 0; i < x1.length; i++) {
            for (int j = 0; j < x1[i].length; j++) {
                if (i == j) {
                    count += x1[i][j];
                }
            }
        }

        return (double) count / total;
    }

    public double getConditionalProbability(String event1, String event2) {
        double jointProb = getJointProbability(event1, event2);
        double marginalProb = getMarginalProbability(event2);
        if (marginalProb == 0) return 0;
        return jointProb / marginalProb;
    }
}
