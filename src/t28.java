public class t28 {
    public static void main(String[] args){
        Solution28 solution=new Solution28();
        System.out.println(solution.strStr("aaa","aaaa"));

        String s="";

    }
}

class Solution28 {
    public int strStr(String haystack, String needle) {


        if(needle.length()==0)return 0;
        char[] s1=haystack.toCharArray();
        char[] s2=needle.toCharArray();
        int l1,l2;
        l1=haystack.length();
        l2=needle.length();
        int[] next=new int[l2];
        next[0]=0;
        //get next
        int k=0;//ptr of s2

        for(int i=1;i<l2;i++) {
            while (k>0&&s2[i]!=s2[k]) {
                k=next[k-1];
            }
            if(s2[i]==s2[k]) {
                k++;
            }
            next[i]=k;
        }

        k=0;
        //apply to s1
        for(int i=0;i<l1;i++) {
            while (k>0&&s1[i]!=s2[k]) {
                k=next[k-1];
            }
            if(s1[i]==s2[k]) {
                k++;
            }
            if(k==l2)return i-k+1;
        }

        return -1;




//        if(needle.length()==0)return 0;
//        //此处必须使用<=，考虑"0","0"
//        char[] s1=haystack.toCharArray();
//        char[] s2=needle.toCharArray();
//        int l1,l2;
//        l1=haystack.length();
//        l2=needle.length();
//        for(int i=0;i<=l1-l2;i++){
//            for(int j=0;j<l2;j++){
//                if(s1[i+j]!=s2[j]){
//                    break;
//                }
//                if(j==l2-1){
//                    return i;
//                }
//            }
//        }
//        return -1;
    }
}