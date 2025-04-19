import java.util.*;

public class SymmetricDifference {
    public static Set<Integer> getSymmetricDifference(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> result = new HashSet<>(set1);
        result.addAll(set2);
        Set<Integer> tmp = new HashSet<>(set1);
        tmp.retainAll(set2);
        result.removeAll(tmp);
        return result;
    }

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 4, 5));
        System.out.println(getSymmetricDifference(set1, set2));
    }
}
