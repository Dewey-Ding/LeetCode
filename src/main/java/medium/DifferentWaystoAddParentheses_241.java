package medium;

import java.util.ArrayList;
import java.util.List;

public class DifferentWaystoAddParentheses_241 {
    public static void main(String[] args) {
        String input = "2-1-1";
        System.out.println(diffWaysToCompute2(input));
    }

    public static List<Integer> diffWaysToCompute2(String input) {
        List<Integer> ways = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));
                for (int l : left) {
                    for (int r : right) {
                        switch (c) {
                            case '+':
                                ways.add(l + r);
                                break;
                            case '-':
                                ways.add(l - r);
                                break;
                            case '*':
                                ways.add(l * r);
                                break;
                        }
                    }
                }
            }
        }
        if (ways.size() == 0) {
            ways.add(Integer.valueOf(input));
        }
        return ways;
    }

    public static List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList<>();
        helper(result,input);
        return result;
    }

    public static void helper(List<Integer> result,String input){
        boolean flag = true;
        for (int i = 1; i < input.length(); i++) {
            if(input.charAt(i)=='-'||input.charAt(i)=='+'||input.charAt(i)=='*'){
                flag = false;
                break;
            }
        }
        if(flag) {
            result.add(Integer.valueOf(input));
            return;
        }

        for (int i = 0; i < input.length(); i++) {
            switch (input.charAt(i)){
                case '-':
                    helper(result,processDel(input,i));
                    break;
                case '+':
                    helper(result,processAdd(input,i));
                    break;
                case '*':
                    helper(result,processMulti(input,i));
                    break;
            }
        }
    }

    public static String processDel(String input,int i){
        int left = i-1,right = i+1;
        while (left>=0&&input.charAt(left)!='-'&&input.charAt(left)!='+'&&input.charAt(left)!='*'){
            left--;
        }
        while (right<input.length()&&input.charAt(right)!='-'&&input.charAt(right)!='+'&&input.charAt(right)!='*'){
            right++;
        }
        String a = input.substring(left+1,i);
        String b = input.substring(i+1,right);
        int c = Integer.parseInt(a)-Integer.valueOf(b);
        StringBuilder sb1 = new StringBuilder(input.substring(0,left+1));
        sb1.append(c);
        if(right-1<input.length()-1){
            sb1.append(input.substring(right));
        }
        return sb1.toString();
    }
    public static String processAdd(String input,int i){
        return "";
    }
    public static String processMulti(String input,int i){
        return "";
    }
}
