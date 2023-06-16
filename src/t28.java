public class t28 {
    public static void main(String[] args){
        Solution28 solution=new Solution28();
        System.out.println(solution.strStr_20230319("aaa","aaa"));

        String s="";

    }
}

class Solution28 {

    public int strStr_kpm(String haystack, String needle) {

        char[] word = needle.toCharArray();
        char[] text = haystack.toCharArray();

        int[] prefixCountArray = new int[word.length];
        int fittedCharCount = 0;
        for(int i=1;i< word.length;i++){
            while (fittedCharCount> 0 && word[fittedCharCount]!=word[i] ){
                fittedCharCount=prefixCountArray[fittedCharCount-1];
            }
            if (word[fittedCharCount]==word[i]){
                prefixCountArray[i]=++fittedCharCount;
            }
        }
        fittedCharCount=0;
        for(int i=0;i<text.length;i++){
            while (fittedCharCount> 0 && word[fittedCharCount]!=text[i] ){
                fittedCharCount=prefixCountArray[fittedCharCount-1];
            }
            if (word[fittedCharCount]==text[i]){
                ++fittedCharCount;
                if(fittedCharCount== word.length){
                    return i- word.length+1;
                }
            }
        }

        return -1;
    }






















    public int strStr_20230319(String haystack, String needle) {

        // 欲提高运算速度
        char[] text = haystack.toCharArray();
        char[] word = needle.toCharArray();

        // 前缀计数：当前位置下（包含当前位置），末尾和开头有多少个元素是相同
        int[] prefixCount = getPrefixCountArray(word);

        // 已经匹配个数
        int fittedCharCount = 0;
        for(int i=0;i < text.length;i++){
            // 若第一个已经匹配，fittedCharCount = 1，那么比较第二个就是偏移为1的位置。
            while (fittedCharCount > 0 && word[fittedCharCount]!=text[i]){
                fittedCharCount = prefixCount[fittedCharCount-1];   //若不匹配，计数-1为字符串末尾和开头的计数。
            }
            // 若相等了，匹配个数++；
            if(word[fittedCharCount] == text[i]){
                fittedCharCount++;
                // 判断已完全匹配
                if(fittedCharCount== word.length){
                    return i - word.length + 1; //特例：i=1，word长度=1，返回偏移也为1，需要补充一个1.
                }
            }
        }
        return -1;
    }


    int[] getPrefixCountArray(char[] word){
        int n = word.length;
        int[] prefixCount = new int[n];
        prefixCount[0] = 0;

        int i = 1;
        int fittedCharCount=0;
        for(;i<n;i++ ){
            while (fittedCharCount>0 && word[fittedCharCount] != word[i]){
                fittedCharCount = prefixCount[fittedCharCount-1]; //计数-1为数组中存储的位置
            }
            if(word[fittedCharCount] == word[i]){
                fittedCharCount++;
                prefixCount[i]=fittedCharCount;
            }
        }

        return prefixCount;
    }




























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