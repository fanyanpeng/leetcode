public class t69 {
    public static void main(String[] args){
        Solution69 solution=new Solution69();

        System.out.println(solution.mySqrt(100));

    }
}

class Solution69 {
    public int mySqrt(int x) {
        int l=0;
        int r=x;
        while (l<=r){
            int mid=(l+r)/2;
//                int mid=(l+r); 也能过！？
            long mul = ((long) mid) * mid;
            if(mul>x){
                r=mid-1;
            }
            if(mul<=x){
                l=mid+1;
            }
        }
        return r;

    }

}