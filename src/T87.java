import java.util.HashMap;

public class T87 {
    public static void main(String[] args){
        Solution87 solution=new Solution87();

        System.out.println(solution.isScramble("eebaacbcbcadaaedceaaacadccd", "eadcaacabaddaceacbceaabeccd"));

    }
}

class Solution87 {

    /**
     * 思路：递归判断，过程前先判断字符是否相等。若相等，切割后继续判断，直到不等或者判断元素小于=1个。
     *
     * @author   fanyanpeng
     * @date 2022/10/15 17:20
     * @param s1
     * @param s2
     * @return boolean
     */
    public boolean isScramble(String s1, String s2) {
        if(s1.length()!=s2.length()){
            return false;
        }
        if(s1.length()<=1 && s1.equals(s2)){
            return true;
        }
        String s3 = reverse(s2);
        HashMap<Character,Integer> m1=new HashMap<>();
        HashMap<Character,Integer> m2=new HashMap<>();
        HashMap<Character,Integer> m3=new HashMap<>();

        for(int i=0;i<s1.length()-1;i++){
            m1.put(s1.charAt(i),m1.getOrDefault(s1.charAt(i),0)+1);
            m2.put(s2.charAt(i),m2.getOrDefault(s2.charAt(i),0)+1);
            m3.put(s3.charAt(i),m3.getOrDefault(s3.charAt(i),0)+1);
            if(m1.equals(m2)){
                if(isScramble(s1.substring(0,i+1),s2.substring(0,i+1)) && isScramble(s1.substring(i+1),s2.substring(i+1))){
                    return true;
                }
            }
            if(m1.equals(m3)){
                if(isScramble(s1.substring(0,i+1),s3.substring(0,i+1)) && isScramble(s1.substring(i+1),s3.substring(i+1))){
                    return true;
                }
            }

        }

        return  false;
    }

    private String reverse(String s){
        StringBuilder sb=new StringBuilder(s);
        return sb.reverse().toString();
    }





}