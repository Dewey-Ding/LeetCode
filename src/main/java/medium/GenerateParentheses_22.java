package medium;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses_22 {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        String s = "";
        solve(result,s,0,0,n);
        return result;
    }
    public static void solve(List<String> result,String s,int left,int right,int max){
        if(s.length()==2*max){
            result.add(s);
            return;
        }
        if(left<max) {
            solve(result, s + "(", left + 1, right, max);
        }
        if(right<left) {
            solve(result, s + ")", left, right + 1, max);
        }
        return;
    }
/*
    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList();
        if (n == 0) {
            ans.add("");
        } else {
            for (int c = 0; c < n; ++c)
                for (String left: generateParenthesis(c))
                    for (String right: generateParenthesis(n-1-c))
                        ans.add("(" + left + ")" + right);
        }
        return ans;
    }
    */
}
