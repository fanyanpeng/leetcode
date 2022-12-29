public class t28 {
    public static void main(String[] args){
        Solution28 solution=new Solution28();
        System.out.println(solution.strStr("aaa","aaaa"));

        String s="";

    }
}

class Solution28 {

    public static int strStr_自研版本(String haystack, String needle) {
        char[] c1 = haystack.toCharArray();
        char[] c2 = needle.toCharArray();
        int[] post = new int[c2.length];
        post[0]=0;
        int k =0;
        for(int i=1;i<c2.length;i++){
            char c = c2[i];
            while(c != c2[k]){
                if(k>0){
                    k = post[k-1];
                }
                if(k==0){
                    break;
                }
            }
            if(c==c2[k]){
                k++;
            }
            post[i]=k;
        }
//        System.out.println(Arrays.toString(c2));
//        System.out.println(Arrays.toString(post));

        k=0;
        for(int i=0;i<c1.length;i++){
            char c = c1[i];
            while (c!=c2[k]){
                if(k>0){
                    k = post[k-1];
                }
                if(k==0){
                    break;
                }
            }
            if(c == c2[k]){
                k++;
                if(k==c2.length){
                    return i-k+1;
                }
            }
        }
        return -1;
    }


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