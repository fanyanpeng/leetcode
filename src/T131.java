import java.util.*;

public class T131 {
    public static void main(String[] args){
        Solution131 solution=new Solution131();

        System.out.println(solution);

    }
}

class Solution131 {

    //C16 1+C16 2+C16 3+C16 4 + ... + C16 16=2^N=

    // 复杂度高，但是上限已经确定；
    // 尝试使用深度优先遍历，可回溯
    // 若是回文串，就将回文串加入栈，若刚好到最后一个，就加入到最终的结果。

    boolean[][] isPal;
    private boolean isPal(String s,int i,int j){
        if(isPal[i][j]){
            return isPal[i][j];
        }
        if(s.charAt(i)!=s.charAt(j)){
            isPal[i][j]=false;
            return false;
        }
        if(i>=j || isPal(s,i+1,j-1)){
            isPal[i][j]=true;
            return true;
        }
        return false;
    }
    private void consume(String s,int curIndex,Deque<String> stack,List<List<String>> ans, boolean[][] isPal){
        if(curIndex == s.length()){
            List<String> stringList=new ArrayList<>(stack);
            ans.add(stringList);
        }
        for(int nextIndex=curIndex;nextIndex<s.length();nextIndex++){
            if(isPal(s,curIndex,nextIndex)){
                String subString = s.substring(curIndex,nextIndex+1);
                stack.addLast(subString);
                consume(s,nextIndex+1,stack,ans,isPal);
                stack.pollLast();
            }
        }
    }

    public List<List<String>> partition(String s) {
        int n =s.length();
        List<List<String>> ans=new ArrayList<>();
        Deque<String> stack=new LinkedList();
        isPal=new boolean[n][n];
        consume(s,0,stack,ans,isPal);
        return ans;
    }
}