import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class t17 {
    public static void main(String[] args){
        Solution17 solution=new Solution17();
        String s="23";
        List<String> strings=solution.letterCombinations(s);
        for (String string:strings
             ) {
            System.out.println(string);

        }


    }
}

class Solution17{
    public List<String> letterCombinations(String digits) {
        HashMap<Character,List<String>> map=new HashMap<>();
        map.put('2', Arrays.asList("a","b","c"));
        map.put('3', Arrays.asList("d","e","f"));
        map.put('4', Arrays.asList("g","h","i"));
        map.put('5', Arrays.asList("j","k","l"));
        map.put('6', Arrays.asList("m","n","o"));
        map.put('7', Arrays.asList("p","q","r","s"));
        map.put('8', Arrays.asList("t","u","v"));
        map.put('9', Arrays.asList("w","x","y","z"));
        List<String> ans=new ArrayList<>();
        for(char c :digits.toCharArray()){
            List<String> s2=map.get(c);
            ans=multi_string(ans,s2);
        }
        return ans;
    }
    public List<String> multi_string(List<String> s1,List<String> s2) {
        List<String> ans=new ArrayList<>();
        if(s1.size()==0)return s2;
        for(String string1:s1){
            for(String string2:s2){
                ans.add(string1+string2);
            }
        }
        return ans;
    }
}