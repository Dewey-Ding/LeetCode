package medium;

import java.util.*;

public class SimplifyPath_71 {
    public static void main(String[] args) {
        String path = "/a/./b/../../c/";
        System.out.println(simplifyPath(path));
    }

    public static String simplifyPath(String path) {
        Deque<String> stack = new LinkedList<>();
        for (String string : path.split("/")) {
            System.out.println(string);
            if (string.equals("..")) {
                stack.pollFirst();
            } else if (!string.equals("") && !string.equals(".")) {
                stack.push(string);
            }
        }
        if (stack.isEmpty()) {
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append("/" + stack.pollLast());
        }
        return sb.toString();
    }
}
