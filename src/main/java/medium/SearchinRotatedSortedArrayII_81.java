package medium;

public class SearchinRotatedSortedArrayII_81 {
    public static void main(String[] args) {
        int[] nums = {1};
        int target = 1;
        System.out.println(search(nums,target));
    }
    public static boolean search(int[] nums, int target) {
        if(nums==null||nums.length==0){
            return false;
        }
        int i = 0,j = nums.length-1;
        while(i<=j){
            int mid=(i+j)/2;
            if(target==nums[mid]){
                return true;
            }
            if(nums[mid]>nums[i]){
                if(target<nums[mid]&&target>=nums[i]){
                    j=mid;
                }else {
                    i=mid+1;
                }
            }else if(nums[mid]<nums[i]){
                if(target>nums[mid]&&target<nums[i]){
                    i=mid+1;
                }else{
                    j=mid-1;
                }
            }else{
                i++;
            }
        }
        return false;
    }
}
