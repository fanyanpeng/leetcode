import com.sun.xml.internal.fastinfoset.util.StringArray;

import java.util.*;

public class T140 {
    public static void main(String[] args){
        Solution140 solution=new Solution140();

        System.out.println(solution);

    }
}

class Solution140 {


    Map<String,List<List<String>>> possibleWordsMap = new HashMap<>();

    public List<String> wordBreak(String s, List<String> wordDict) {

        dfs(s,wordDict);
        List<String> ans =new ArrayList<>();
        List<List<String>> sentences = possibleWordsMap.get(s);
        if(sentences!=null){
            for(List words:sentences){
                ans.add(join(words));
            }
        }
        return ans;

    }

    public String join(List<String> words){
        StringBuilder sb=new StringBuilder();
        for(int i = words.size()-1; i>=0; i--){
            sb.append(" ").append(words.get(i));
        }
        return sb.substring(1);
    }

    public  List<List<String>> dfs(String s, List<String> wordDict) {
        if(!possibleWordsMap.containsKey(s)){
            if(s.length()==0){
                List<List<String>> lists = new ArrayList<>();
                lists.add(new ArrayList<>());
                return lists;
            }
            List<List<String>> possibleList = new ArrayList<>();
            for(String word:wordDict){
                if(s.startsWith(word)){
                    List<List<String>> lists = dfs(s.substring(word.length()),wordDict);
                    if(lists!=null){
                        for(List<String> list:lists){
                            List<String> copied = new ArrayList<>(list);
                            copied.add(word);
                            possibleList.add(copied);
                        }
                    }
                }
            }
            if(possibleList.size()==0){
                possibleList = null;
            }
            possibleWordsMap.put(s,possibleList);
        }
        return possibleWordsMap.get(s);
    }
}