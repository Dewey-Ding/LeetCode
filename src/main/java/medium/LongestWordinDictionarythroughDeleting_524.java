package medium;

import java.util.ArrayList;
import java.util.List;

public class LongestWordinDictionarythroughDeleting_524 {
    public static void main(String[] args) {
        String s = "abpcplea";
        List<String> d = new ArrayList<>();
        d.add("ale");
        d.add("eppla");
        d.add("monkey");
        d.add("plea");
        d.add("apple");
        System.out.println(findLongestWord(s,d));
    }
    public static String findLongestWord(String s, List<String> d) {
        String result = "";
        for (int i = 0; i < d.size(); i++) {
            int j = 0,k = 0;
            while (j<d.get(i).length() && k<s.length()){
                if(d.get(i).charAt(j)==s.charAt(k)){
                    j++;
                    k++;
                }else {
                    k++;
                }
            }
            if(j == d.get(i).length()){
                if(d.get(i).length()>result.length()||(d.get(i).length()==result.length()&&d.get(i).charAt(0)<result.charAt(0))){
                    result = d.get(i);
                }
            }
        }
        return result;

    }
}
