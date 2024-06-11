import java.util.*;

public class Main {

    public static void main(String[] args) {
        DataSetPermutation a = new DataSetPermutation();
        String [] chars = a.getX2();


        // Generar permutaciones
        Permutation permutation = new Permutation(chars);
        List<String> permutations = permutation.getPermutations();
        System.out.println("Permutations:");
        for (String perm : permutations) {
            System.out.println(perm);
        }

        // Inicializar Datasets
        DataSetPermutation datasetPermutation = new DataSetPermutation();
        DataSetProbability datasetProbability = new DataSetProbability();

        // Calcular probabilidades
        Probability probability = new Probability(datasetPermutation, datasetProbability);
        System.out.println("\nProbabilities:");

        // Ejemplos de cálculo de probabilidades
        System.out.println("P(A): " + probability.getMarginalProbability("a"));
        System.out.println("P(B): " + probability.getMarginalProbability("b"));
        System.out.println("P(C): " + probability.getMarginalProbability("c"));

        System.out.println("P(A, B): " + probability.getJointProbability("a", "b"));
        System.out.println("P(B, C): " + probability.getJointProbability("b", "c"));

        System.out.println("P(A|B): " + probability.getConditionalProbability("a", "b"));
        System.out.println("P(B|C): " + probability.getConditionalProbability("b", "c"));

        // Obtener y mostrar el dataset de DataSetProbability
        int[][] datasetProb = datasetProbability.getDataset();
        System.out.println("\nDataSetProbability:");
        for (int[] row : datasetProb) {
            System.out.println(Arrays.toString(row));
        }

        // Obtener y mostrar el dataset de DataSetPermutation
        String[] datasetPerm = datasetPermutation.getDataset();
        System.out.println("\nDataSetPermutation:");
        System.out.println(Arrays.toString(datasetPerm));
    }
}
