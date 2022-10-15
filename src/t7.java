public class t7 {

    public static void main(String[] args){
        int num=2;
        System.out.print(Solution7.reverse(-2147483648));
    }
}


class Solution7 {
    public static int reverse(int x) {
        int min=(1<<31);
        int max=min-1;
        int ans=0;
        while (x!=0){
            int tail=x%10;
            if(x<0 && (min-tail)/10>ans){
                return 0;
            }
            if(x>0 && (max-tail)/10<ans){
                return 0;
            }
            x=x/10;
            ans=ans*10+tail;
        }
        return ans;
    }
}