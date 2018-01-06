package hard;
public class MedianofTwoSortedArrays_4 {
    public static void main(String[] args) {
        int[] a = new int[]{1,3};
        int[] b = new int[]{2,4};
        System.out.println(findMedianSortedArrays(a,b));
    }
    //because we can't throw away symmetry element in two sorted arrays,so we should recursive the findKth func and remove k/2 element every once.
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int count1 = nums1.length;
        int count2 = nums2.length;
        int midL = (count1+count2+1)/2;
        int midR = (count1+count2+2)/2;
        if(midL==midR) {
            return findKth(nums1, 0, nums2, 0, midL);
        }else {
            return (findKth(nums1, 0, nums2, 0, midL)+findKth(nums1, 0, nums2, 0, midR))/2.0;
        }
    }
    //always throw away the left of lower mid so this func only need the start index of arrays.
    public static int findKth(int[] nums1,int start1,int[] nums2,int start2,int k){
        if(start1>=nums1.length){
            return nums2[start2+k-1];
        }
        if(start2>=nums2.length){
            return nums1[start1+k-1];
        }
        if(k==1){
            return Math.min(nums1[start1],nums2[start2]);
        }
        int mid1 = Integer.MAX_VALUE;
        int mid2 = Integer.MAX_VALUE;
        //because the start is one of the removed so we compare the biggest one in removed list not the lowest in the left arrays.
        if(start1+k/2-1<nums1.length){mid1=nums1[start1+k/2-1];}
        if(start2+k/2-1<nums2.length){mid2=nums2[start2+k/2-1];}
        if(mid1<mid2){
            return findKth(nums1,start1+k/2,nums2,start2,k-k/2);
        }else{
            return findKth(nums1,start1,nums2,start2+k/2,k-k/2);
        }
    }
}
//    remove half of one sorted arrays not half of total.
//    In order to solve this question, we need to first understand what a median is. A median is the middle value of a dataset.
//        Since we have 2 seperately sorted array in this question, to find the middle value is somewhat complicated.
// However, keep in mind that we do not care about the actual value of the numbers, what we want is the middle point from the combination of 2 arrays.
// In other words, we are looking for the middle index of the 2 arrays. Thus approach like binary search could be employed.
//        Based on the fact that the 2 arrays are sorted seperatedly, we could try to get the submedian of the 2 arrays in each round.
// Than compare them. And the basic idea is that the left half of the array with a smaller submedian can never contains the common median.
//
//        if (mid1 < mid2) keep nums1.right + nums2
//        else keep nums1 + nums2.right
