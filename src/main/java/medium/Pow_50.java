package medium;

public class Pow_50 {
    public static void main(String[] args) {
        //System.out.println(myPow1(0.0000001,2147483647));
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Math.pow(0.0000001,2147483647));
        System.out.println(myPow(2.00,Integer.MIN_VALUE));
    }
    public static double myPow1(double x, int n) {
        if(n==0){
            return 1;
        }
        int flag = 0;
        if(n<0){
            flag = 1;
            n=-n;
        }
        double result = x;
        for (int i = 1; i < n; i++) {
            result = result*x;
        }
        if(flag==1){
            return 1/result;
        }
        return result;
    }
    public static double myPow(double x,int n){
        if(n<0){
            if(x>1&&n==Integer.MIN_VALUE){
                return 0;
            }
            x = 1 / x;
            n = -n;
        }
        if(n==0){
            return 1;
        }else if(n==1){
            return x;
        }else{
            double tmp = myPow(x,n/2);
            if(n%2==0){
                return tmp*tmp;
            }else{
                return x*tmp*tmp;
            }
        }
    }
}
