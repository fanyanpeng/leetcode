public class t50 {
    public static void main(String[] args){
        Solution50 solution=new Solution50();
        int[] a=new int[]{3,4,-1,1};
        System.out.println(solution.myPow(2,111));

    }
}

class Solution50 {

    public double myPow(double x, int n) {
        boolean isPositive=n>0;
        double ans=1;
        long nn=n;
        nn=Math.abs(nn);
        while (nn!=0){
            if(nn%2==1){
                ans*=x;
            }
            x*=x;
            nn/=2;
        }
        return isPositive?ans:1/ans;

    }
}