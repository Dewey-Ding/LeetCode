package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dewey
 * @date 2019-10-16 23:51
 */
public class PerfectSquares_279 {
    public static void main(String[] args) {
        int n = 16;
        System.out.println(numSquares(n));
        System.out.println(numSquares2(n));
    }

    /**
     * 常规动态规划
     * @param n
     * @return
     */
    public static int numSquares(int n) {
        List<Integer> list = generate(n);
        System.out.println(list.toString());
        int[] result = new int[n+1];
        result[1] = 1;
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int one:list){
                if(one>i){
                    break;
                }
                min = Math.min(min,result[i-one]+1);
            }
            result[i] = min;
        }
        return result[n];
    }
    public static List<Integer> generate(int n){
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if(i*i>n){
                break;
            }
            result.add(i*i);
        }
        return result;
    }


    /**
     * 鬼才方法
     * @param n
     * @return
     */
    public static int numSquares2(int n) {
        while(n%4==0) n/=4;
        if(n%8 ==7) return 4;

        for(int i=0; i*i<=n; i++) {
            int j = (int) Math.sqrt(n-i*i);
            if(i*i + j*j == n)
                return i * j == 0? 1: 2;
        }

        return 3;
    }
}
