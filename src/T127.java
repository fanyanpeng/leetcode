import java.util.*;

public class T127 {
    public static void main(String[] args){
        Solution127 solution=new Solution127();

        List<String> words= new ArrayList<>();

        words.addAll(Arrays.asList("hot","dot","dog","lot","log","cog"));
        System.out.println(solution.ladderLength("hit","cog",words));


    }
}

class Solution127 {

    HashMap<String, List<String>> neighbour=new HashMap<>();
    HashSet<String> visited=new HashSet<>();
    HashSet<String> _visited=new HashSet<>();

    HashSet<String> dic=new HashSet<>();
    void initMap(String beginWord, String endWord, List<String> wordList){
        if(!wordList.contains(beginWord)){
            wordList.add(beginWord);
        }
        dic.addAll(wordList);
        for(String word : wordList){
            neighbour.put(word,neighbour(word));
        }
    }

    private List<String> neighbour(String word) {
        List<String> ans=new ArrayList<>();

        char[] chars = word.toCharArray();
        for(int i=0;i<word.length();i++){
            char ori=chars[i];
            for(char c='a';c<='z';c++){
                if(ori==c){
                    continue;
                }
                chars[i]=c;
                String temp = new String(chars);
                if(dic.contains(temp)){
                    ans.add(temp);
                }
            }
            chars[i]=ori;
        }

        return ans;
    }



    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)){
            return 0;
        }
        initMap(beginWord,endWord,wordList);
        return bst(beginWord,endWord,wordList);
    }

    private int bst(String beginWord, String endWord, List<String> wordList) {
        int level = 1;
        HashSet<String> cur = new HashSet<>();
        cur.add(beginWord);
        HashSet<String> _cur = new HashSet<>();
        _cur.add(endWord);
        this.visited.add(beginWord);
        this._visited.add(endWord);
        while (cur.size()!=0||_cur.size()!=0){
            level++;
            cur = nextLevel(cur,visited);
            if(repeat()){
                return level;
            }
            level++;
            _cur = nextLevel(_cur,_visited);
            if(repeat()){
                return level;
            }

        }
        return 0;
    }

    private boolean repeat() {
        for(String s:visited){
            if(_visited.contains(s)){
                return true;
            }
        }
        return false;
    }

    HashSet<String> nextLevel(HashSet<String> cur,HashSet<String> visited){
        HashSet<String> next  =new HashSet<>();
        for(String key:cur){
            List<String> neighbours=this.neighbour.get(key);
            for(String neighbour:neighbours){
                if (!visited.contains(neighbour)) {
                    visited.add(neighbour);
                    next.add(neighbour);
                }
            }
        }
        return next;
    }

}