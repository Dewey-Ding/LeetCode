package medium;

public class SearchinRotatedSortedArray_33 {
    public static void main(String[] args) {
        int[] nums = new int[]{4,5,6,7,8,1,2,3};
        System.out.println(search(nums,8));
    }
    public static int search(int[] nums, int target) {
        if(nums==null||nums.length==0){
            return -1;
        }
        int start = 0,end = nums.length-1;
        while(start+1<end){
            int mid = (start+end)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid]<target){
                if(target == nums[end]){
                    return end;
                }else if(target<nums[end]){
                    start = mid+1;
                }else if(nums[start]>nums[mid]){
                    end = mid-1;
                }else{
                    start = mid+1;
                }
            }else if(nums[mid]>target){
                if(nums[start]==target){
                    return start;
                }else if(nums[start]<target) {
                    end = mid - 1;
                } else if(nums[start]<nums[mid]) {
                    start = mid + 1;
                } else {
                    end = mid-1;
                }
            }
        }
        if(target==nums[start])
            return start;
        if(target==nums[end])
            return end;
        return -1;
    }

  /*  public static int search(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == target){
                return i;
            }
        }
        return -1;
    }*/
}
