

public class T125 {
    public static void main(String[] args){
        Solution125 solution=new Solution125();

        System.out.println(solution.isPalindrome("a   manama"));

    }
}

class Solution125 {
    public boolean isPalindrome(String s) {
        s = getPureChars(s);
        int len = s.length();
        char[] chars = s.toCharArray();
        for(int i=0;i<len/2;i++){
            if(chars[i]!=chars[len-1-i]){
                return false;
            }
        }
        return true;

    }

    private String getPureChars(String s){
        StringBuilder ans = new StringBuilder();
        char[] chars = s.toLowerCase().toCharArray();
        for(char c:chars){
            if(c<='z'&&c>='a' || c<='9'&&c>='0'){
                ans.append(c);
            }
        }
        return ans.toString();
    }

}