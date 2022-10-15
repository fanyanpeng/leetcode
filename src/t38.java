public class t38 {
    public static void main(String[] args){
        Solution38 solution=new Solution38();
        System.out.println(solution.countAndSay(5));

    }
}

class Solution38 {
    public String countAndSay(int n) {
        if(n==1)return "1";
        String s=countAndSay(n-1);
        StringBuilder builder=new StringBuilder();
        char cur_num=' ';
        int count=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(cur_num!=c){
                count=0;
                cur_num=c;
            }
            count+=1;
            if(i==s.length()-1 || s.charAt(i+1)!=cur_num){
                builder.append(count).append(cur_num);
            }
        }
        return builder.toString();
    }
}