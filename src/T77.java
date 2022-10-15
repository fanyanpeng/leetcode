import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T77 {
    public static void main(String[] args){
        Solution77 solution=new Solution77();
        List<List<Integer>> ans=solution.combine(20,10);
        for(List<Integer> a:ans){
            System.out.println(Arrays.toString(a.toArray()));
        }
        System.out.println();

    }
}

class Solution77 {




    List<List<Integer>> ans;
    int k;
    int n;
    public List<List<Integer>> combine(int n, int k) {
        ans=new ArrayList<>();
        this.n=n;
        this.k=k;
        choose(1,new ArrayList<>(k));
        return ans;
    }

    void choose(int pos,List<Integer> chosen){

        if(chosen.size()==k){
            ans.add(chosen);
            return;
        }
        //完美剪枝，从44ms降低到1ms
        if(n-pos+1+ chosen.size()<k){
            return;
        }

        choose(pos+1,chosen);

        ArrayList<Integer> copy=new ArrayList<>(chosen);
        copy.add(pos);
        choose(pos+1,copy);
    }

}