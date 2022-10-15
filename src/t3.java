import java.util.*;

public class t3 {
    public static void main(String[] args){

        int pos=Solution3.lengthOfLongestSubstring("1243424");
        System.out.println(pos);




    }
}
class Solution3 {
    public static int lengthOfLongestSubstring(String s) {
        int l=0;
        int r=0;
        char[] str=s.toCharArray();
        int max=0;
        HashSet<Character> set=new HashSet<>();
        while (r<s.length()){
            char head=str[r++];
            if(set.contains(head)){
                while (str[l]!=head){
                    set.remove(str[l]);
                    l++;
                }
                set.remove(str[l]);
                l++;
            }
            set.add(head);
            int len=set.size();
            max=Math.max(len,max);
        }
        return max;
    }

}
