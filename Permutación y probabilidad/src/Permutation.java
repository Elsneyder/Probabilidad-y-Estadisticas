import java.util.ArrayList;
import java.util.List;

public class Permutation {
    private char[] elements;

    public Permutation(char[] elements) {
        this.elements = elements;
    }

    public List<String> getPermutations() {
        List<String> result = new ArrayList<>();
        permute(result, new StringBuilder(), new boolean[elements.length]);
        return result;
    }

    private void permute(List<String> result, StringBuilder current, boolean[] used) {
        if (current.length() == elements.length) {
            result.add(current.toString());
            return;
        }

        for (int i = 0; i < elements.length; i++) {
            if (used[i]) continue;
            used[i] = true;
            current.append(elements[i]);
            permute(result, current, used);
            current.deleteCharAt(current.length() - 1);
            used[i] = false;
        }
    }
}
