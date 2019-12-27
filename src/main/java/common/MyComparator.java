package common;

import java.util.Comparator;
import java.util.Map;

public class MyComparator implements Comparator<Map.Entry<Character, Integer>> {
    @Override
    public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
        return o1.getValue()-o2.getValue();
    }
}
