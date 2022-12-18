import java.util.*;

public class t30 {
    public static void main(String[] args){
        Solution30 solution=new Solution30();


        List<Integer> ans=
                solution.findSubstring3(
                        "wordgoodgoodgoodbestword",
                        new String[]
                                {"word","good","best","good"});

        System.out.println(ans);


    }
}
class Solution30 {



    /** 
     * 滑动窗口法解决：
     * 思路，单词是等距离的，每个句子的起点只能是单词长度*n+一个偏移。所以考虑单词长度个偏移即可，对于每一个偏移下，每次移动单词长度距离。
     * 完成分组之后，对每一个偏移，每次移动单词距离，分为两种情况；
     * 往后走的时候，若新单词使得数量超过了，就使得起点前移，直到当前单词数量不超过。
     * 若新单词不在单词列表，清空已有数据。开始位置移动到当前单词的下一个。
     *
     * 完成以上过程后进行统一对比，若与预期列表符合，添加到列表。
     * @author   fanyanpeng 
     * @date 2022/10/15 16:18
     * @return
     */

    public List<Integer> findSubstring3(String s, String[] words){
        List<Integer> ans=new ArrayList<>(100);
        int wordLen=words[0].length();
        int sentenceLen=s.length();
        HashMap<String,Integer> allWords=new HashMap<>();
        for(String word :words){
            allWords.put(word,1+allWords.getOrDefault(word,0));
        }
        for(int offset = 0; offset < wordLen; offset ++){
            HashMap<String,Integer> wordMap = new HashMap<>();
            int left = offset;

            for (int i=left; i<=sentenceLen-wordLen;i+=wordLen){    // 包含当前位置
                String word = s.substring(i,i+wordLen);

                if(!allWords.containsKey(word)){
                    wordMap.clear();
                    left=i+wordLen;
                    continue;
                }

                wordMap.put(word,1+wordMap.getOrDefault(word,0));//总是添加
                while (allWords.get(word) < wordMap.get(word)){
                    String leftWord = s.substring(left,left+wordLen);
                    wordMap.put(leftWord,wordMap.get(leftWord)-1);
                    left+=wordLen;
                }

                int wordCount = (i - left)/wordLen +1;
                if(wordCount == words.length){
                    ans.add(left);
                    String leftWord = s.substring(left,left+wordLen);
                    wordMap.put(leftWord,wordMap.get(leftWord)-1);
                    left+=wordLen;
                }
            }
        }
        return ans;

    }


    /**
     * 使用map作为计数，使用map判断是否相等。
     * @author   fanyanpeng
     * @date 2022/10/15 15:57
     * @param s
     * @param words
     * @return java.util.List<java.lang.Integer>
     */
    public List<Integer> findSubstring2(String s, String[] words) {
        List<Integer> ansList=new ArrayList<>(10);
        HashMap<String,Integer> wordMap=new HashMap<>(words.length);
        for(String word : words){
            wordMap.put(word,wordMap.getOrDefault(word,0)+1);
        }
        int wordLength=words[0].length();
        HashMap<String,Integer> tmpMap=new HashMap<>(words.length);
        int left=0;
        while (left<=s.length()-wordLength*words.length){
            tmpMap.clear();
            for(int i=0;i<words.length;i++){
                String word=s.substring(left+wordLength*i,left+wordLength*(i+1));
                if(!wordMap.containsKey(word)){
                    break;
                }
                tmpMap.put(word,tmpMap.getOrDefault(word,0)+1);
            }
            if(tmpMap.equals(wordMap)){
                ansList.add(left);
            }
            left++;
        }
        return ansList;
    }














    HashMap<String, Integer> map_sum=new HashMap<>();

    public List<Integer> findSubstring(String s, String[] words) {
        int word_length=words[0].length();
        for(int i=0;i<words.length;i++){

            map_sum.put(words[i],map_sum.getOrDefault(words[i],0)+1);

        }
        List<Integer> positions=getWordsPosition(s,words);
        List<Integer> ans=new ArrayList<>(1000);
        Integer[] pos= positions.toArray(new Integer[0]);

        for(int i=0;i<=pos.length- words.length;i++){
            if(consistent(pos,i,word_length,words.length,s.length())){
                if(contain_all(s.substring(pos[i],pos[i]+word_length*words.length),words)){
                    ans.add(pos[i]);
                }
            }
        }

        return ans;


    }

    public boolean consistent(Integer[] pos,int index,int word_length,int word_count,int limit){
        //1  2  3;word_count=3,compare_times=2
//        for(int j=i;j< i+ word_count-1;j++){
//            if(pos[j+1]!=pos[j]+word_length){
//                return false;
//            }
//        }
        if(pos[index] + word_length * word_count > limit)return false;
//
//        List<Integer> pos_to_find=new ArrayList<>();
//        for(int i=0;i<word_count;i++){
//            pos_to_find.add(pos[index]+word_length*i);
//        }
//        for(Integer integer:pos_to_find){
//            boolean found=false;
//            for(int i=index;i<pos.length&&pos[i]<=pos_to_find.get(pos_to_find.size()-1);i++){
//                if (Objects.equals(integer, pos[i])) {
//                    found = true;
//                    break;
//                }
//            }
//            if(!found)return false;
//        }
        return true;

    }

    //subStr.length = words.length * words[0].length
    public boolean contain_all(String subStr,String[] words){
        HashMap<String ,Integer> map=new HashMap<>();

        int word_length=words[0].length();

        //for every in subStr
        for(int i=0;i<words.length;i++) {
            String s = subStr.substring(i * word_length, (i + 1) * word_length);
            //for every in words
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        return map.equals(map_sum);

//        int word_length=words[0].length();
//        boolean[] mark=new boolean[words.length];
//        Arrays.fill(mark,false);
//        //for every in subStr
//        for(int i=0;i<words.length;i++){
//            String s=subStr.substring(i*word_length,(i+1)*word_length);
//            //for every in words
//            for(int j=0;j<words.length;j++){
//                if(!mark[j] && s.equals(words[j])){
//                    mark[j]=true;break;
//                }
//                //failed to match any string
//                //bug1:
////                else if(j==word_length-1)return false;
//                else if(j==words.length-1)return false;
    }

    public List<Integer> getWordsPosition(String s, String[] words) {
        List<Integer> positions=new ArrayList<>(1000);
        int word_length=words[0].length();
        for(int i=0;i<=s.length()-word_length;i++){
            String s1=s.substring(i,i+word_length);
            for(String s2:words){
                if(s1.equals(s2)){
                    positions.add(i);
                    break;
                }
            }
        }
        return positions;
    }













}