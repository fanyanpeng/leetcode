import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T139 {
    public static void main(String[] args){
        Solution139 solution=new Solution139();
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        List<String> strings = Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa");
        System.out.println(solution.wordBreak(s,strings));

    }
}

class Solution139 {

    Map<String,Boolean> cached = new HashMap<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        if(!cached.containsKey(s)){
            if(s.length()==0){
                return true;
            }
            for(String word:wordDict){
                if(s.startsWith(word)){
                    if(wordBreak(s.substring(word.length()),wordDict)){
                        return true;
                    }
                }
            }
            cached.put(s,false);
        }
        return cached.get(s);
    }

}