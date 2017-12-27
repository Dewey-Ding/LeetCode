package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LetterCombinationsofaPhoneNumber_17 {
    public static void main(String[] args) {
        System.out.println(letterCombinations("234"));
    }
    public static List<String> letterCombinations(String digits) {
        String[] represent = new String[]{"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> result = new ArrayList<>();
        if(digits==null||digits.length()==0){
            return result;
        }
        //减少初始状态处理的代码
        result.add("");
        //循环处理字符串，解决嵌套digits.length层循环处理每个数字的问题
        for(int i = 0;i<digits.length();i++){
            int num = Character.getNumericValue(digits.charAt(i));
            int count = result.size()-1;
            while(count>=0){
                String s = result.remove(count);
                for(int j = 0;j<represent[num].length();j++){
                    result.add(s+represent[num].charAt(j));
                }
                count--;
            }
        }
        return result;

    }
   /* public static List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<String>();
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        for(int i =0; i<digits.length();i++){
            int x = Character.getNumericValue(digits.charAt(i));
            while(ans.peek().length()==i){
                String t = ans.remove();
                for(char s : mapping[x].toCharArray())
                    ans.add(t+s);
            }
        }
        return ans;
    }*/
}
