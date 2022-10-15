import java.util.Arrays;

public class t44 {
    public static void main(String[] args){
        Solution44 solution=new Solution44();
        int[] a=new int[]{3,4,-1,1};
        //System.out.println(solution.isMatch("abcabczzzde","*abc???de*"));
        System.out.println(solution.isMatch("ab","a*******b"));
    }
}

class Solution44 {
    char[] s;
    char[] p;
    boolean[][] used;

    public boolean isMatch(String s, String p) {
        this.s=new char[s.length()+1];
        this.p=new char[p.length()+1];
        for(int i=0;i<s.length();i++){
            this.s[i]=s.charAt(i);
        }
        for(int i=0;i<p.length();i++){
            this.p[i]=p.charAt(i);
        }
        used=new boolean[s.length()+1][p.length()+1];
        match(0,0);
        return used[s.length()][p.length()];
    }

    void match(int s_ptr,int p_ptr){
        if(s_ptr==s.length || p_ptr==p.length){
            return;
        }
        if(used[s_ptr][p_ptr])return;
        used[s_ptr][p_ptr]=true;

        char p_c=p[p_ptr];
        char s_c=s[s_ptr];

        if(p_c!='*' && p_c!='?'){
            if(p_c!=s_c){
                return;
            }
            match(s_ptr+1,p_ptr+1);
        }
        else if(p_c=='?'){
            match(s_ptr+1,p_ptr+1);
        }
        else {
            match(s_ptr,p_ptr+1);
            match(s_ptr+1,p_ptr);
        }
    }


//    String s="";
//    String p="";
//    int count=0;
//    boolean[][] used;
//    public boolean isMatch(String s, String p) {
//        this.s=s;
//        this.p=p;
//        used=new boolean[s.length()+1][p.length()+1];
//        boolean b=match(0,0);
//        System.out.println(count);
//        return b;
//    }
//    boolean only_star(int ptr){
//        for(int i=ptr;i<p.length();i++){
//            if(p.charAt(i)!='*')return false;
//        }
//        return true;
//    }
//    boolean match(int s_ptr,int p_ptr){
//        count++;
//        if(used[s_ptr][p_ptr])return false;
//        used[s_ptr][p_ptr]=true;
//        if(s_ptr==s.length() && p_ptr==p.length()){
//            return true;
//        }
//        if(s_ptr==s.length() && only_star(p_ptr)){
//            return true;
//        }
//        if(s_ptr==s.length() || p_ptr==p.length()){
//            return false;
//        }
//        char p_c=p.charAt(p_ptr);
//        char s_c=s.charAt(s_ptr);
//
//        if(p_c!='*' && p_c!='?'){
//            if(p_c!=s_c){
//                return false;
//            }
//            if(match(s_ptr+1,p_ptr+1)){
//                return true;
//            }
//        }
//        else if(p_c=='?'){
//            if(match(s_ptr+1,p_ptr+1)){
//                return true;
//            }
//        }
//        else {
//            if(match(s_ptr,p_ptr+1)){
//                return true;
//            }
//            if(match(s_ptr+1,p_ptr)){
//                return true;
//            }
////            if(match(s_ptr+1,p_ptr+1)){
////                return true;
////            }
//        }
//     return false;
//    }
}