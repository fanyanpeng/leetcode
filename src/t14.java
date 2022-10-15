

import java.util.Arrays;

public class t14 {
    public static void main(String[] args){
        Solution14 solution=new Solution14();
        String[] strings=new String[]{"plower","flow","flight"};
        System.out.println(solution.longestCommonPrefix(strings));
    }
}

class Solution14{

//
//    public String longestCommonPrefix(String[] strs) {
//        if(strs.length==0){
//            return "";
//        }
//
//        Arrays.sort(strs);
//        String ans="";
//        String s1=strs[0];
//        String s2=strs[strs.length-1];
//        for(int i=0;i<Math.min(s1.length(),s2.length());i++){
//            if(s1.charAt(i)==s2.charAt(i)){
//                ans+=s1.charAt(i);
//            }
//            else {
//                break;
//            }
//        }
//        return ans;
//
//
//
//
//    }

//        编写一个函数来查找字符串数组中的最长公共前缀。
//
//    如果不存在公共前缀，返回空字符串 ""。
    public String longestCommonPrefix(String[] strs) {
        String profix=strs[0];//initailize profix
        int pos=profix.length();
        for(int i=1;i<strs.length;i++){
            pos=find_first_diff(profix,strs[i],pos);


        }
        return profix.substring(0,pos);

    }
    int find_first_diff(String s1,String s2,int limit){
        limit=Math.min(s2.length(),limit);
        for(int i=0;i<limit;i++){
            if(s1.charAt(i)!=s2.charAt(i))return i;
        }
        return limit;
    }


//    public String longestCommonPrefix(String[] strs) {
//        String profix=strs[0];//initailize profix
//        int pos=profix.length();
//        for(int i=1;i<strs.length;i++){
//            pos=Math.min(strs[i].length(),pos);
//            for(int j=0;j<pos;j++){
//                if(profix.charAt(j)!=strs[i].charAt(j)){
//                 pos=j;break;
//                }
//            }
//        }
//        return profix.substring(0,pos);
//    }


}

