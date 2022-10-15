import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class t49 {
    public static void main(String[] args){
        Solution49 solution=new Solution49();
        String[] strings=new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> ans=solution.groupAnagrams(strings);
        for(List<String> a: ans){
            System.out.println(Arrays.toString(a.toArray()));
        }

    }
}

class Solution49 {

    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String,List<String>> map=new HashMap<>();
        for(String str : strs){
            char[] chars=str.toCharArray();
            Arrays.sort(chars);
            String key_string=String.valueOf(chars);
            List<String> list=map.getOrDefault(key_string,new ArrayList<>());
            map.put(key_string,list);
            list.add(str);
        }
        return new ArrayList<>(map.values());


//计数+hash
//        HashMap<String,List<String>> map=new HashMap<>();
//        for(String str : strs){
//            int[] word_table=new int[30];
//            char[] chars=str.toCharArray();
//            for(char c:chars){
//                word_table[c-'a']+=1;
//            }
//            String count_string=array2String(word_table);
//            //String count_string=String.valueOf(word_table);
//            if(!map.containsKey(count_string)){
//                map.put(count_string,new ArrayList<>());
//            }
//            map.get(count_string).add(str);
//        }
//        return new ArrayList<>(map.values());

    }

    String array2String(int[] ints){
        StringBuilder builder=new StringBuilder();
        for (int anInt : ints) {
            builder.append(anInt).append('_');
        }
        return builder.toString();
    }
}