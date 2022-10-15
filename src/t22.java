import java.util.ArrayList;
import java.util.List;

public class t22 {
    public static void main(String[] args){
        Solution22 solution=new Solution22();
        List<String> strings=solution.generateParenthesis(5);
        for (String string : strings) {
            System.out.println(string);
        }
    }
}

class Solution22{


    public List<String> generateParenthesis(int n) {
        List<String> ans=new ArrayList<>();
        char[] chars=new char[2*n];
        get_parentheses(chars,0,0,ans);
        return ans;
    }
    private void get_parentheses(char[] s,int pos,int value,List<String> ans) {
        if(pos==s.length ){
            StringBuilder stringBuilder=new StringBuilder();
            if(value==0){
                for (char c : s) {
                    stringBuilder.append(c);
                }
                ans.add(stringBuilder.toString());
            }
        }
        else if(value==0){
            s[pos]='(';
            get_parentheses(s,pos+1,value-1,ans);
        }
        else {
            s[pos]='(';
            get_parentheses(s,pos+1,value-1,ans);
            s[pos]=')';
            get_parentheses(s,pos+1,value+1,ans);
        }
    }

//    int n=0;
//    List<String> ans=new ArrayList<>();
//    public List<String> generateParenthesis(int n) {
//        this.n=n*2;
//        get_parentheses("",0);
//        return ans;
//    }
//
//    private void get_parentheses(String s,int value) {
//        if(s.length()==n ){
//            if(value==0) ans.add(s);
//        }
//        else if(value==0){
//            get_parentheses(s+"(",value-1);
//
//        }
//        else {
//            get_parentheses(s+"(",value-1);
//            get_parentheses(s+")",value+1);
//        }
//
//    }
}