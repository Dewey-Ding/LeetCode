package medium;

/**
 * @author dewey
 * @date 2019-10-23 21:33
 */
public class MaximumLengthofPairChain_646 {
    public static void main(String[] args) {
        int[][] pairs = {{1,2},{2,3},{3,4}};
        System.out.println(findLongestChain(pairs));
    }
    public static int findLongestChain(int[][] pairs) {
        if(pairs==null||pairs.length==0){
            return 0;
        }
        int row = pairs.length;

        int[] dep = new int[row];
        for (int i = 0; i < row; i++) {
            int max = 1;
            for (int j = 0; j <= i; j++) {
                if(pairs[j][1]<pairs[i][0]){
                    max = Math.max(max,dep[j]+1);
                }
            }
            dep[i] = max;
        }

        return dep[row-1];
    }
}
