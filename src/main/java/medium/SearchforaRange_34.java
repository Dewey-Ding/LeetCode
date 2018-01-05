package medium;

public class SearchforaRange_34 {
    public static void main(String[] args) {
        int[] nums = new int[]{5,7,7,8,8,10};
        int[] result = searchRange(nums,8);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1,-1};
        int start = 0,end = nums.length-1;
        while(start<=end){
            int mid = (start+end)/2;
            if(nums[mid]<target){
                start = mid+1;
                continue;
            }else if(nums[mid]>target){
                end = mid-1;
                continue;
            }else{
                result[0] = mid;
                result[1] = mid;
                while (result[0]>=0&&nums[result[0]]==target){
                    result[0]--;
                }
                while (result[1]<nums.length&&nums[result[1]]==target){
                    result[1]++;
                }
                result[0]++;
                result[1]--;
                break;
            }
        }
        return result;
    }
/*

    public static int[] searchRange(int[] nums, int target) {
        if(nums.length==0||nums==null){
            return new int[]{-1,-1};
        }
        return search(nums,0,nums.length-1,target);
    }
    public static int[] search(int[] nums, int start,int end,int target){
        if(start>end){
            return new int[]{-1,-1};
        }
        int mid = (start+end)/2;
        if(nums[mid]<target){
            return search(nums,mid+1,end,target);
        }else if(nums[mid]>target){
            return search(nums,start,mid-1,target);
        }else{
            int[] result = new int[]{mid,mid};
            while (result[0]>=0&&nums[result[0]]==target){
                result[0]--;
            }
            while (result[1]<nums.length&&nums[result[1]]==target){
                result[1]++;
            }
            result[0]++;
            result[1]--;
            return result;
        }
    }

*/
}
