package medium;

public class ContainerWithMostWate_11 {
    public static void main(String[] args) {
        int[] height = new int[]{1,1};
        System.out.println(maxArea(height));
    }
    public static int maxArea(int[] height) {
        int maxAre = 0;
        int area = 0;
        int i=0,j=height.length-1;
        while(i<j){
            if(height[i]<height[j]){
                area = (j-i)*height[i];
                if(maxAre<=area){
                    maxAre = area;
                }
                i++;
            }else{
                area = (j-i)*height[j];
                if(maxAre<area){
                    maxAre = area;
                }
                j--;
            }
        }
        return maxAre;
    }
}
