import java.util.HashMap;

public class T76 {
    public static void main(String[] args){
        Solution76 solution=new Solution76();

        System.out.println(solution.minWindow("A","A"));

    }
}

class Solution76 {

    public String minWindow(String s, String t) {
        HashMap<Character,Integer> tMap=getHash(t);
        HashMap<Character,Integer> sMap=new HashMap<>();
        String ans="";
        int l,r;
        l=0;
        r=0;
        char[] chars=s.toCharArray();
        while (r<s.length()){
            //not contains
            if(r-l < t.length() || !isBiggerHashMap(sMap,tMap)){
                if(r==s.length()){
                    break;
                }
                Character c=chars[r];
                sMap.put(c,1+sMap.getOrDefault(c,0));
                r++;
            }
            else {
                if(ans.equals("") || r-l<ans.length()){
                    ans=s.substring(l,r);
                }
                Character c=chars[l];
                sMap.put(c,sMap.get(c)-1);
                l++;
            }

        }
        return ans;
    }



    HashMap<Character,Integer> getHash(String s){
        HashMap<Character,Integer> map=new HashMap<>(52);
        char[] chars=s.toCharArray();
        for(Character c:chars){
            map.put(c,1+map.getOrDefault(c,0));
        }
        return map;
    }

    boolean isBiggerHashMap(HashMap<Character,Integer> big,HashMap<Character,Integer> small){
        for(Character c : small.keySet()){
            if(big.getOrDefault(c,0)<small.get(c)){
                return false;
            }
        }
        return true;
    }







//    public String minWindow(String s, String t) {
//        HashMap<Character,Integer> mapT=getHash(t);
//        String ans="";
//        for(int i=0;i<=s.length()-t.length();i++){
//            for(int j=i+t.length();j<=s.length();j++){
//                if(j-i<t.length()){
//                    break;
//                }
//                String tmp=s.substring(i,j);
//                HashMap<Character,Integer> tmpB=getHash(tmp);
//                if(isBiggerHashMap(tmpB,mapT)){
//                    if(ans.equals("")){
//                        ans=tmp;
//                        break;
//                    }
//                    if(ans.length()>tmp.length()){
//                        ans=tmp;
//                    }
//                }
//            }
//        }
//        return ans;
//
//    }
//

}