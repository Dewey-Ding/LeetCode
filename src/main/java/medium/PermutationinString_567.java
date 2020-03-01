package medium;

import java.util.Arrays;

public class PermutationinString_567 {
    public static void main(String[] args) {
        String s1 = "ab", s2 = "eidboaoo";
        System.out.println(checkInclusion(s1,s2));
    }
    public static boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()){
            return false;
        }
        int[] letters = new int[26];
        int[] temps = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            letters[s1.charAt(i)-'a']++;
            temps[s2.charAt(i)-'a']++;
        }
        if(Arrays.equals(letters,temps)){
            return true;
        }
        int left = 0;
        for (int i = s1.length(); i < s2.length(); i++) {
            temps[s2.charAt(i)-'a']++;
            temps[s2.charAt(left++)-'a']--;
            if(Arrays.equals(letters,temps)){
                return true;
            }
        }
        return false;
    }

}
