package medium;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence_60 {
    public static void main(String[] args) {
        System.out.println(getPermutation(2, 2));
    }

    public static String getPermutation(int n, int k) {
        k--;
        List<Integer> list = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        int num = 1;
        for (int i = 2; i < n; i++) {
            num *= i;
        }
        int count = n - 1;
        while (count >= 0) {
            int c = list.get(k / num);
            list.remove(k / num);
            stringBuilder.append(c);
            k = k % num;
            if (count != 0) {
                num = num / (count);
            }
            count--;
        }
        return stringBuilder.toString();
    }
}
/*
* 相关的lehmer介绍请先看这里：http://www.keithschwarz.com/interesting/code/?dir=next-permutation

因为我也是大概看别人的，所以这里只罗列一下大致的思路：

这道题自己思考得到了一个模糊的思路，而实际上这个问题已经有了很好的理论研究与证明，具体可以参考链接1
这里通过一个例子来说明本实现中的思路：
假设集合为[1,2,3,4]，求出第6个组合。
第6个组合对应的下标为5（下标从0开始），我们首先求出5所对应的lehmer码（lehmer code的解释参考链接1）：
5/3! = 0 余5
5/2! = 2 余1
1/1! = 1 余0
0 (lehmer code最后一位总为0)
所以所求lehmer码为0210

当前集合对应的序列为1234
接下来将lehmer码中的每个数字当做当前序列的下标，下标0对应的集合元素为1，当前序列变成234；下标2对应的集合元素为4，当前序列变成23；下标1对应的集合元素为3，当前序列变成2；下标0对应的元素为2
所以所求的组合即为1432
* */
