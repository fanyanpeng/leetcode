public class t29 {
    public static void main(String[] args){
        Solution29 solution=new Solution29();
        System.out.println(solution.divide(88,12));
    }
}

class Solution29 {
    public int divide(int dividend, int divisor) {
        //to minimize the condition dealt
        if(dividend==0)return 0;
        //the only exception
        if(dividend==Integer.MIN_VALUE && divisor==-1)return Integer.MAX_VALUE;

        int ans=0;
        //designed for ans's +=
        int base=get_base(dividend,divisor);
        //get how many bit can be shifted (max)
        int lim=0;
        for(;lim<32;lim++){
            //only when signs are exactly the same, it returns true
            if(!sign_not_changed(divisor,divisor<<lim))break;
            //lim is not reachable;
        }
        for(int i=lim-1;i>=0;i--){

            //when a=-2147483648,1+2+4+8 could never reach that number,
            // there is a 1 missing!
            while (true){
                int n=close_to_0(dividend , (divisor<<i));
                if(n==0){
                    ans+=(base<<i);return ans;
                }
                if(sign_not_changed(dividend,n)){
                    dividend=n;
                    ans+=(base<<i);
                }
                else break;
            }

        }
        return ans;

    }

    int get_base(int a,int b){
        //different sign -> -1
        if(a>0 && b<0 || a<0 && b>0)return -1;
        else return 1;
    }

    int close_to_0(int a,int b){
        //make the abs close to zero
        if(a>0 && b<0 || a<0 && b>0)return a+b;
        else return a-b;
    }

    boolean sign_not_changed(int a, int b){
        //a is not 0,
        //b is not 0, or it gets into a loop
        return a>0 &&b>0 ||a<0 && b<0;
    }
}