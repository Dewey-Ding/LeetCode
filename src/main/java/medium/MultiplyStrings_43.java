package medium;

public class MultiplyStrings_43 {
    public static void main(String[] args) {
        String num1 = "12";
        String num2 = "200";
        //System.out.println(multpHleper(num1,2));
        //System.out.println(addHelper(num1,num2));
        System.out.println(multiply(num1,num2));
    }

    //模拟乘法立式计算过程
    public static String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] pos = new int[m + n];

        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + pos[p2];

                pos[p1] += sum / 10;
                pos[p2] = (sum) % 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int p : pos) if(!(sb.length() == 0 && p == 0)) sb.append(p);
        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static String multiply1(String num1, String num2) {
        if(num1.equals("0")||num2.equals("0")){
            return "0";
        }
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        if(num1.length()<num2.length()){
            s1.append(num2);
            s2.append(num1);
        }else{
            s2.append(num2);
            s1.append(num1);
        }
        String result = "";
        for(int i=s2.length()-1;i>=0;i--){
            int multi = s2.charAt(i)-'0';
            result = addHelper(result,multpHleper(s1.toString(),multi));
            s1.append(0);
        }
        return result;
    }
    public static String multpHleper(String num1,int num2){
        StringBuilder result = new StringBuilder();
        int pre = 0;
        for (int i = num1.length()-1; i >= 0; i--) {
            int multi = num1.charAt(i)-'0';
            result.append((pre+multi*num2)%10);
            pre = (pre+multi*num2)/10;
        }
        if(pre!=0){
            result.append(pre);
        }
        return result.reverse().toString();

    }
    public static String addHelper(String num1,String num2){
        StringBuilder result = new StringBuilder();
        int i = num1.length()-1;
        int j = num2.length()-1;
        int pre = 0;
        while(i>=0||j>=0){
            int sum = 0;
            if(i>=0){
                sum = sum + num1.charAt(i)-'0';
                i--;
            }
            if(j>=0){
                sum = sum + num2.charAt(j)-'0';
                j--;
            }
            result.append((pre+sum)%10);
            pre=(pre+sum)/10;
        }
        if(pre!=0){
            result.append(pre);
        }
        return result.reverse().toString();
    }
}
