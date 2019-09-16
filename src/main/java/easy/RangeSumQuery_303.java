package easy;

/**
 * @author dewey
 * @date 2019-09-05 23:24
 */
public class RangeSumQuery_303 {
    public int[] data;
    public RangeSumQuery_303(int[] nums) {
        data = nums;
    }

    public int sumRange(int i, int j) {
        int result = 0;
        for(int k =i;k <= j;k++){
            result+=data[k];
        }
        return result;
    }
}
