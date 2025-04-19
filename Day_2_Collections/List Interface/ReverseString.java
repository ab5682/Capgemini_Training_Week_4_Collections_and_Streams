import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ReverseString {
    public static List<Integer> reverseArrayList(List<Integer> list) {
        List<Integer> reversed = new ArrayList<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            reversed.add(list.get(i));
        }
        return reversed;
    }

    public static List<Integer> reverseLinkedList(LinkedList<Integer> list) {
        LinkedList<Integer> reversed = new LinkedList<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            reversed.add(list.get(i));
        }
        return reversed;
    }

    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);

        LinkedList<Integer> linkedList = new LinkedList<>(arrayList);

        System.out.println("Reversed ArrayList: " + reverseArrayList(arrayList));
        System.out.println("Reversed LinkedList: " + reverseLinkedList(linkedList));
    }
}
