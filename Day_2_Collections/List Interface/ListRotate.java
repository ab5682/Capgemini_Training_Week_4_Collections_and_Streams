import java.util.*;

public class ListRotate {
    public static List<Integer> rotateList(List<Integer> list, int positions) {
        int size = list.size();
        List<Integer> rotated = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            rotated.add(list.get((i + positions) % size));
        }
        return rotated;
    }

    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(10, 20, 30, 40, 50);
        int rotateBy = 2;
        System.out.println(rotateList(input, rotateBy));
    }
}
