import java.util.*;

public class T126 {
    public static void main(String[] args){
        Solution126 solution=new Solution126();

        List<String> words= Arrays.asList("hot","dog");
        System.out.println(solution.findLadders("hot","dog",words));

    }
}

class Solution126 {
    List<List<String>> ans=new ArrayList<>();
    Deque<String> stack = new ArrayDeque<>();
    String beginWord;
    HashMap<String,List<String>> neighbourMap=new HashMap<>();
    HashMap<String,Integer> levelMap=new HashMap<>();
    HashMap<String,List<String>> foreMap=new HashMap<>();

    HashSet<String> dic=new HashSet<>();
    void init(String beginWord, List<String> words){
        List<String> wordList= new ArrayList<>(words);

        this.beginWord = beginWord;
        if(!wordList.contains(beginWord)){
            wordList.add(beginWord);
        }
        dic.addAll(wordList);
        for(String key: wordList){
            neighbourMap.put(key,getNeighbour(key,wordList));
            foreMap.put(key,new ArrayList<>());
        }
    }

//    private List<String> getNeighbour(String key, List<String> wordList) {
//        List<String> values = new ArrayList<>();
//        for(String value:wordList){
//            if(isNeighbour(key,value)){
//                values.add(value);
//            }
//        }
//        return values;
//    }
    private List<String> getNeighbour(String word, List<String> wordList) {
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

    private boolean isNeighbour(String key, String value) {
        int diffCount=0;
        for(int i =0;i<key.length();i++){
            if(key.charAt(i) != value.charAt(i)){
                diffCount+=1;
                if(diffCount>1){
                    return false;
                }
            }
        }
        return diffCount==1;
    }

    void startBSF(String beginWord,String endWord){
        boolean metEndWord=false;
        int level  = 0;
        HashSet<String> curLevel = new HashSet<>();
        this.levelMap.put(beginWord,level);
        curLevel.add(beginWord);

        while (curLevel.size()!=0 && !metEndWord){
            level++;
            HashSet<String> nextLevel = new HashSet<>();
            for(String key:curLevel){
                List<String> neighbours = this.neighbourMap.get(key);
                for(String neighbour : neighbours){
                    if(this.levelMap.containsKey(neighbour)){
                        if(this.levelMap.get(neighbour) == level){  //若当前的level相等
                            this.foreMap.get(neighbour).add(key);
                        }
                    }
                    // 对于未遍历到当前数字的情况
                    else {
                        this.levelMap.put(neighbour,level);
                        this.foreMap.get(neighbour).add(key);
                        nextLevel.add(neighbour);
                    }

                    if(neighbour.equals(endWord)){
                        metEndWord = true;
                    }
                }
                curLevel = nextLevel;
            }
        }
    }

    void dfs(String word){
        stack.addFirst(word);
        if(word.equals(this.beginWord)){
            List<String> t = new ArrayList<>(stack);
            ans.add(t);
        }
        List<String> foreWords = this.foreMap.get(word);
        for(String foreWord:foreWords){
            dfs(foreWord);
        }
        stack.pollFirst();
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)){
            return ans;
        }
        init(beginWord, wordList);
        startBSF(beginWord, endWord);
        dfs(endWord);
        return ans;
    }
}