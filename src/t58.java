public class t58 {
    public static void main(String[] args){
        Solution58 solution=new Solution58();
        int[] a=new int[]{3,4,-1,1};
        System.out.println(solution.lengthOfLastWord("u"));

    }
}

class Solution58 {
    public int lengthOfLastWord(String s) {
        char[] str=s.toCharArray();
        boolean in_word=false;
        int count=0;
        for(int i=str.length-1;i>=0;i--){
            if(in_word&&str[i]==' '){
                break;
            }
            if(in_word&&str[i]!=' '){
                count++;
            }
            if(!in_word&&str[i]!=' '){
                count++;
                in_word=true;
            }

        }
        return count;
    }
}