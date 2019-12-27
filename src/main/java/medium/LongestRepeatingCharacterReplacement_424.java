package medium;

import common.MyComparator;

import java.util.*;

public class LongestRepeatingCharacterReplacement_424 {
    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;
        System.out.println(characterReplacement(s,k));
    }

    public static int characterReplacement(String s, int k) {
        int result = 0;
        int maxCount = 0,left = 0;
        int[] letterTimes = new int[26];

        for (int i = 0; i < s.length(); i++) {
            maxCount = Math.max(maxCount,++letterTimes[s.charAt(i)-'A']);
            while(maxCount+k<i-left+1){
                letterTimes[s.charAt(left)-'A']--;
                left++;
            }
            result = Math.max(result,i-left+1);
        }


        return result;
    }

}
