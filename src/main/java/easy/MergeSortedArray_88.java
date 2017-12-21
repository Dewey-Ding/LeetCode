package easy;

public class MergeSortedArray_88 {
    public static void main(String[] args) {
        int[] num1={1,3,5,0,0};
        int[] num2={2,4};
        merge(num1,3,num2,2);
        for(int i=0;i<num1.length;i++) {
            System.out.println(num1[i]);
        }
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int end = m+n-1;
        int end1 = m - 1;
        int end2 = n - 1;

        while (end1 >= 0 && end2 >= 0) {
            if (nums1[end1] > nums2[end2]) {
                nums1[end] = nums1[end1];
                end1--;
            } else {
                nums1[end] = nums2[end2];
                end2--;
            }
            end--;
        }

        if (end1 < 0) {
            for (int i = 0; i <= end2; i++) {
                nums1[i] = nums2[i];
            }
        }

    }
   /* public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if(m==0){
            for(int i=0;i<n;i++) {
                nums1[i] = nums2[i];
            }
        }
        for(int j=0;j<n;j++){
            for(int i=m-1+j;i>=0;i--){
                if(nums1[i]>nums2[j]){
                    nums1[i + 1] = nums1[i];
                    if(i==0){
                        nums1[i] = nums2[j];
                        break;
                    }
                }else{
                    nums1[i+1] = nums2[j];
                    break;
                }
            }
        }
    }*/
}
