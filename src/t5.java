public class t5 {
    public static void main(String[] args){

        String s="\"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabcaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\"";

        System.out.print(Solution5.longestPalindrome(s));

    }

}

class Solution5 {
    public static String longestPalindrome(String s) {
        String max_str="";
        int length=s.length();
        int max_sum=2*(length-1);
        int l=0,r=0;
        for(int sum=0;sum<=max_sum;sum++){
            l=sum/2;
            r=sum-l;
            if(s.charAt(l)!=s.charAt(r)){
                continue;
            }
            while (true){
                if(s.charAt(l)==s.charAt(r)){
                    l--;r++;
                }
                else {
                    break;
                }
                if(l<0 || r>=length){
                    break;
                }
            }
            l++;r--;
            if(r+1-l>max_str.length()){
                max_str=s.substring(l,r+1);
            }
        }
        return max_str;

//        String maxStr="";
//        int l=s.length();
//        for(int i=0;i<l;i++){
//            if(l-i<=maxStr.length()){
//                break;
//            }
//            for(int j=i;j<l;j++){
//                if(j+1-i<=maxStr.length()){
//                    continue;
//                }
//                String temp=s.substring(i,j+1);
//                if(is_palindrome(temp)){
//                    maxStr=temp;
//                }
//            }
//        }
//        return maxStr;
    }

    static boolean is_palindrome(String s){

        int l=s.length();
        if(l<2){
            return true;
        }
        for(int i=0;i<=l/2;i++){
            if(s.charAt(i)!=s.charAt(l-i-1)){
                return false;
            }
        }
        return true;
    }
}