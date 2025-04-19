import java.util.*;

public class FindKeyWithHighestValue {
    public static String findKeyWithMaxValue(Map<String, Integer> map) {
        return Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 10);
        map.put("B", 20);
        map.put("C", 15);

        String keyWithMaxValue = findKeyWithMaxValue(map);
        
        System.out.println(keyWithMaxValue);
    }
}
