import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class t68 {
    public static void main(String[] args){
        Solution68 solution=new Solution68();
        String[] strings=new String[]{"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"};

        System.out.println(Arrays.toString(solution.fullJustify(strings, 20).toArray()));

    }
}

class Solution68 {

    public static List<String> ans;
    public static String[] wordList;
    public static int[] lenList;
    public static int width;

    public List<String> fullJustify(String[] words, int maxWidth) {
        //注意点：每次必须清空
        ans=new ArrayList<>();
        lenList=new int[words.length];
        int pos=0;
        for(String s:words){
            lenList[pos++]=s.length();
        }

        wordList=words;
        width=maxWidth;
        consume(0);
        return ans;
    }

    public static String  lastLine(List<Integer> line){
        StringBuilder sb=new StringBuilder(width);
        //注意4：此处需要偏移
        int offset=line.get(0);
        for(int i=0;i<line.size()-1;i++){
            sb.append(wordList[i+offset]).append(" ");
        }
        sb.append(wordList[line.get(line.size()-1)]);

        //注意点3：补齐空格
        sb.append(blanks(width-sb.length()));
        return sb.toString();
    }

    public static String  middleLine(List<Integer> line){
        StringBuilder sb=new StringBuilder(width);

        int size=0;
        for(Integer i:line){
            size+=lenList[i];
        }

        int[] blanks=blankArrange(width-size,line.size()-1);
        int wordPos=0;
        int blankPos=0;
        while (wordPos<line.size() || blankPos<blanks.length){
            if(wordPos<line.size()){
                sb.append(wordList[line.get(wordPos++)]);
            }
            if(blankPos<blanks.length){
                sb.append(blanks(blanks[blankPos++]));
            }
        }
        return sb.toString();
    }

    public static String blanks(int n){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++){
            sb.append(" ");
        }
        return sb.toString();
    }

    private static int[] blankArrange(int leftSize,int count) {
        //注意点2：没有计数["as   "]
        if(count==0){
            count=1;
        }
        int avg=leftSize/count;
        int addOneCount=leftSize%count;
        int[] ans=new int[count];
        Arrays.fill(ans,0,addOneCount,avg+1);
        Arrays.fill(ans,addOneCount,count,avg);

        return ans;
    }

    public static void consume(int pos){
        List<Integer> line=new ArrayList<>(3);
        int limit=wordList.length;
        int currSize=0;

        line.add(pos);
        currSize+=wordList[pos++].length();

        while (true){
            if(pos>=limit){
                ans.add(lastLine(line));
                return;
            }
            if(currSize+1+wordList[pos].length()>width){
                ans.add(middleLine(line));
                consume(pos);
                //注意点1：此处需要退出循环
                break;
            }
            else {
                line.add(pos);
                currSize+=1;
                currSize+=wordList[pos++].length();
            }
        }

    }


}