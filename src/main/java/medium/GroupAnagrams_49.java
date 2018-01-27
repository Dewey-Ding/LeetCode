package medium;

import java.util.*;

public class GroupAnagrams_49 {
    public static void main(String[] args) {
        String[] strs = new String[]{"ate", "eat","tea", "nat","tan", "bat"};
        List<List<String>> result = groupAnagrams(strs);
        for (int i = 0; i < result.size(); i++) {
            List<String> list = result.get(i);
            for (int j = 0; j < list.size(); j++) {
                System.out.print(list.get(j)+" ");
            }
            System.out.println();
        }
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> result = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            if(result.containsKey(new String(chars))){
                result.get(new String(chars)).add(strs[i]);
            }else{
                List<String> list = new ArrayList<String>();
                list.add(strs[i]);
                result.put(new String(chars),list);
            }
        }
        return new ArrayList<>(result.values());
    }
}
