public class t32 {
    public static void main(String[] args){
        Solution32 solution=new Solution32();
        System.out.println(solution.longestValidParentheses("))))())()()(()"));

    }
}

class Solution32 {
    public int longestValidParentheses(String s) {
        boolean[] matched=new boolean[s.length()];

        int left_count=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='('){
                left_count++;
            }
            if(c==')'){
                if(left_count!=0){
                    left_count--;
                    matched[i]=true;
                    for(int j=i;j>=0;j--){
                        if(!matched[j]){
                            matched[j]=true;break;
                        }
                    }
                }
            }
        }
        return get_longest_match_list(matched);
    }

    int get_longest_match_list(boolean[] match){

        int count=0;
        int max=0;
        for(boolean b:match){
            if(b){
                count++;max=Math.max(count,max);
            }
            else {
                count=0;
            }
        }
        return max;
    }
}