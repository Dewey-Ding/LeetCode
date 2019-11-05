package hard;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author dewey
 * @date 2019-11-01 21:33
 */
public class SlidingWindowMaximum_239 {
    public static void main(String[] args) {
        int[] nums = new int[]{1};
        int[] result = maxSlidingWindow2(nums,1);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
    //使用队列
    public static int[] maxSlidingWindow2(int[] nums, int k) {
        if(nums.length<=0){
            return new int[0];
        }
        int result[] = new int[nums.length-k+1];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(list.size()>0&&i-list.get(0)>=k){
                list.remove(0);
            }
            while (list.size()>0&&nums[i]>nums[list.get(list.size()-1)]){
                list.remove(list.size()-1);
            }
            list.add(i);
            if(i>=k-1) {
                result[i - k + 1] = nums[list.get(0)];
            }
        }
        return result;
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length==0){
            return new int[1];
        }
        int result[] = new int[nums.length-k+1];
        PriorityQueue<Integer> stack = new PriorityQueue<>(new myComparable());
        for (int i = 0; i < k; i++) {
            stack.add(nums[i]);
        }

        result[0] = stack.peek();
        for (int i = k; i < nums.length; i++) {
            stack.remove(nums[i-k]);
            stack.add(nums[i]);
            result[i-k+1] = stack.peek();
        }
        return result;
    }

    public static class myComparable implements Comparator<Integer>{
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    }



    /**
     * 建堆
     * @param nums
     */
    public static void createStack(int[] nums){
        for (int i =(nums.length-1)/2; i >=0; i--) {
            adjust(nums,nums.length,i);
        }
    }

    /**
     * 删除堆元素
     * @param nums
     * @param num
     */
    public static void delete(int[] nums,int num){
        nums[0] = nums[nums.length-1];
        adjust(nums,nums.length,0);
    }

    /**
     * 插入元素
     * @param nums
     * @param index
     * @param num
     */
    public static void insert(int[] nums,int index,int num){
        int parent = (index-1)/2;
        while(parent>=0){

            int child = parent*2+1;
            if(child+1<index&&nums[child+1]>nums[child]){
                child++;
            }
            if(nums[child]>nums[parent]){
                nums[index] = nums[parent];
                index = parent;
                parent = (index-1)/2;
            }else {
                break;
            }
        }

    }

    /**
     * 自上像下调整堆
     * @param nums
     * @param len
     * @param index
     */
    public static void adjust(int[] nums,int len,int index){
        int temp = nums[index];
        int currIndex = index ;
        for (int child = 2*index+1; child < len; child = 2*child+1) {
            if(child+1<len&&nums[child+1]>nums[child]){
                child++;
            }
            if(nums[child]>temp){
                nums[currIndex] = nums[child];
                currIndex = child;
            }else {
                break;
            }
        }
        nums[currIndex] = temp;
    }

}
