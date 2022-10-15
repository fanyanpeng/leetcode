public class t9 {
    public static void main(String[] args){
        int i=-0;
        System.out.print(Solution9.isPalindrome(i));
    }
}
class  Solution9{
    public static boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        int ans=0;
        int temp=x;

        while (temp!=0){
            int n=temp%10;
            temp=temp/10;
            if( ((Integer.MAX_VALUE)-n)/10 < ans){
                return false;
            }
            ans=ans*10+n;
        }
        return ans == x;
    }
}