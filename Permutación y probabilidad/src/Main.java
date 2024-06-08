import java.util.*;

public class Main {
    public static void main(String[] args) {
        char[] chars = {'a', 'b', 'c'};

        // Generar permutaciones
        Permutation permutation = new Permutation(chars);
        List<String> permutations = permutation.getPermutations();
        System.out.println("Permutations:");
        for (String perm : permutations) {
            System.out.println(perm);
        }

        // Inicializar Dataset
        DataSetPermutation datasetPermutation = new DataSetPermutation();

        // Calcular probabilidades
        Probability probability = new Probability(datasetPermutation);
        System.out.println("\nProbabilities:");

        // Ejemplos de cálculo de probabilidades
        System.out.println("P(A): " + probability.getMarginalProbability("a"));
        System.out.println("P(B): " + probability.getMarginalProbability("b"));
        System.out.println("P(C): " + probability.getMarginalProbability("c"));

        System.out.println("P(A, B): " + probability.getJointProbability("a", "b"));
        System.out.println("P(B, C): " + probability.getJointProbability("b", "c"));

        System.out.println("P(A|B): " + probability.getConditionalProbability("a", "b"));
        System.out.println("P(B|C): " + probability.getConditionalProbability("b", "c"));
    }
}

