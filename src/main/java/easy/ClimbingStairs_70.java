package easy;
/*
The problem seems to be a dynamic programming one. Hint: the tag also suggests that!
        Here are the steps to get the solution incrementally.

        Base cases:
        if n <= 0, then the number of ways should be zero.
        if n == 1, then there is only way to climb the stair.
        if n == 2, then there are two ways to climb the stairs. One solution is one step by another; the other one is two steps at one time.

        The key intuition to solve the problem is that given a number of stairs n, if we know the number ways to get to the points [n-1] and [n-2] respectively,
         denoted as n1 and n2 , then the total ways to get to the point [n] is n1 + n2. Because from the [n-1] point, we can take one single step to reach [n].
         And from the [n-2] point, we could take two steps to get there. There is NO overlapping between these two solution sets, because we differ in the final step.

        Now given the above intuition, one can construct an array where each node stores the solution for each number n. Or if we look at it closer,
        it is clear that this is basically a fibonacci number, with the starting numbers as 1 and 2, instead of 1 and 1.
*/

public class ClimbingStairs_70 {
    public static void main(String[] args) {
        //System.out.println(Permutations(10,15));
        System.out.println(climbStairs(6));
    }

    //sample 0 ms submission
    public static int climbStairs(int n) {
        //dynamic programming
        //each step one / two
        if(n<=0)
            return 0;
        if(n == 1)
            return 1;
        int pre = 1;
        int cur = 2;
        for(int i = 2;i < n; i++){
            int tmp = cur;
            cur = cur + pre;
            pre = tmp;
        }
        return cur;
    }
/*    public static int climbStairs(int n) {
        int result=1,m=n;
        int x=0,y=0;
        while(m-2>=0){
            x=m-2;
            y++;
            if (x<y){
                result+=Permutations(x,y);
            }else{
                result+=Permutations(y,x);
            }
            m-=2;
        }
        return result;
    }
    public static int Permutations(int x,int y){
        if (x==0){
            return 1;
        }
        int molecular=1,denominator=1;
        int z=x+y;
        while(x>0){
            molecular = molecular*z;
            denominator = denominator*x;
            int approximate = Approximate(molecular,denominator);
            if(approximate!=1){
                molecular = molecular / approximate;
                denominator = denominator / approximate;
            }
            z--;
            x--;
        }
        return molecular/denominator;
    }

    private static int Approximate(int molecular, int denominator) {
        for(int i=denominator/2;i>=1;i--){
            if(molecular%i==0&&denominator%i==0){
                return i;
            }
        }
        return 1;
    }*/

}
