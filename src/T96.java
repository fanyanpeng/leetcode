import java.util.HashMap;

public class T96 {
    public static void main(String[] args){
        Solution96 solution=new Solution96();

        System.out.println(solution.numTrees(19));

    }
}

class Solution96 {

    HashMap<Integer,Integer> stored=new HashMap<>();
    public int numTrees(int n) {

        stored.put(0,1);
        stored.put(1,1);
        return dfs(1,n+1);
    }

    int dfs(int left,int right){
        int n = right-left;
        if(stored.containsKey(n)){
            return stored.get(n);
        }

        int sum =0;
        for(int i=left;i<right;i++){
            sum+=dfs(left,i) * dfs(i+1,right);
        }

        stored.put(n,sum);
        return sum;
    }

}