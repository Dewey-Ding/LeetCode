package medium;


import java.util.ArrayList;
import java.util.List;

public class LongestSubstringwithAtLeastKRepeatingCharacters_395 {
    public static void main(String[] args) {
        String s = "bbaaacba";
        int k = 3;
        System.out.println(longestSubstring(s,k));
    }
    public static int longestSubstring(String s, int k) {

        int maxLength = 0;
        List<String> subStr = new ArrayList<>();
        subStr.add(s);
        while(!subStr.isEmpty()){
            String curStr = subStr.get(0);
            subStr.remove(0);
            if(qualifyStr(curStr,k)){
                maxLength = Math.max(maxLength,curStr.length());
            }else{
                subStr.addAll(splitStr(curStr,k));
            }
        }
        return maxLength;
    }
    public static boolean qualifyStr(String s,int k){
        int[] letterTimes = new int[26];
        for (int i = 0; i < s.length(); i++) {
            letterTimes[s.charAt(i)-'a']++;
        }
        for (int i = 0; i < letterTimes.length; i++) {
            if(letterTimes[i]>0&&letterTimes[i]<k){
                return false;
            }
        }
        return true;
    }
    public static List<String> splitStr(String s,int k){

        List<String> result = new ArrayList<>();
        if(s.length()<k){
            return result;
        }

        int start = -1;
        int[] letterTimes = new int[26];
        for (int i = 0; i < s.length(); i++) {
            letterTimes[s.charAt(i)-'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if(letterTimes[s.charAt(i)-'a']<k){
                if(i-start+1>k) {
                    result.add(s.substring(start+1, i));
                }
                start = i;
            }
        }
        if(s.length()-start>k){
            result.add(s.substring(start+1));
        }
        return result;
    }
}
