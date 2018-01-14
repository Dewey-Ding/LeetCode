package hard;

public class LongestValidParentheses_32 {
    public static void main(String[] args) {
        String s = ")(((((()())()()))()(()))(";
        System.out.println(longestValidParentheses(s));
    }

    //从左到右的过程中'('数量大于')'情况下，符合题意的sumstring很难判断，需要记录pre，start等。
    //再从右到左循环一遍则补充了上述情况。
    public static int longestValidParentheses(String s) {
        int left = 0, right = 0, maxlength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * right);
            } else if (right >= left) {
                left = right = 0;
            }
        }
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * left);
            } else if (left >= right) {
                left = right = 0;
            }
        }
        return maxlength;
    }
/*

    public static int longestValidParentheses(String s) {
        int left = 0, right = 0, length = 0;
        int start = -1, pre = 0,end = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
                if (left == right) {
                    pre = 2 * right;
                    if (pre > length) {
                        length = pre;
                    }
                    end = i;
                } else if (left < right) {
                    start = i;
                    left = 0;
                    right = 0;
                    pre = 0;
                } else if (left > right) {
                    if (i - 2 * right != end) {
                        length = Math.max(2 * right - pre, length);
                        pre += 2 * right - pre;
                    } else {
                        length = Math.max(2 * right, length);
                        pre += 2 * right;
                    }
                }
            }
        }
        return length;
    }
*/

/*    public static int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int max=0;
        int left = -1;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    left=i;
                } else{
                    stack.pop();
                    if(stack.isEmpty()) {
                        max=Math.max(max,i-left);
                    } else{
                        max=Math.max(max,i-stack.peek());
                    }
                }
            }
        }
        return max;
    }*/
}

