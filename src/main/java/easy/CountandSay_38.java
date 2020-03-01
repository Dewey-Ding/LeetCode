package easy;

public class CountandSay_38 {
    public static void main(String[] args) {
        System.out.println(countAndSay(10));
    }
    public static String countAndSay(int n) {
        StringBuilder sb = new StringBuilder("1");
        if(n==1){
            return sb.toString();
        }
        while (--n>0){
            String temp = sb.toString();
            sb.setLength(0);
            for (int i = 0; i < temp.length(); i++) {
                int count = 1;
                char c = temp.charAt(i);
                while (i<temp.length()-1&&temp.charAt(i+1)==temp.charAt(i)){
                    count++;
                    i++;
                }

                sb.append(count);
                sb.append(c);
            }

        }
        return sb.toString();
    }
}
