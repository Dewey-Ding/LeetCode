package medium;

import java.util.ArrayList;
import java.util.List;

public class GrayCode_89 {
    public static void main(String[] args) {
        List<Integer> result = grayCode(3);
        System.out.println(result.toString());
    }

    /**
     * 类似动态规划
     * 例：n为三时可以由n为2的结果推导出来
     * n==2  [00,01,11,10]   temp = 100
     * n==3  [000,001,011,010,110,111,101,100]
     * 原序列符合题意，在二进制数前加0即可，后面加1则用反序列来满足题目要求
     * @param n
     * @return
     */
    public static List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        result.add(0);
        if(n==0){
            return result;
        }
        result.add(1);
        for (int i = 1; i < n; i++) {
            int temp = 1<<i;
            int count = result.size()-1;
            while (count>=0){
                result.add(result.get(count)|temp);
                count--;
            }
        }
        return result;
    }
}
