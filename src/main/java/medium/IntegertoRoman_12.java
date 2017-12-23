package medium;

public class IntegertoRoman_12 {
    public static void main(String[] args) {
        System.out.println(intToRoman(123));
    }
   /* public static String intToRoman(int num) {
        String M[] = {"", "M", "MM", "MMM"};
        String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return M[num/1000] + C[(num%1000)/100]+ X[(num%100)/10] + I[num%10];
    }*/

    private static int[] nums = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static String[] strings = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public static String intToRoman(int num) {
        StringBuilder res = new StringBuilder();
        for (int i  = 0 ; i<nums.length; i++) {
            while (num >= nums[i]) {
                res.append(strings[i]);
                num -= nums[i];
            }
        }

        return res.toString();
    }
}
