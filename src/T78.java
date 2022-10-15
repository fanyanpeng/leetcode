import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T78 {
    public static void main(String[] args){
        Solution78 solution=new Solution78();
        List<List<Integer>> ans=solution.subsets(new int[]{1,2,3});
        for(List<Integer> a:ans){
            System.out.println(Arrays.toString(a.toArray()));
        }
        System.out.println(solution);

    }
}

class Solution78 {

    List<List<Integer>> ans;
    int[] nums;

    List<List<Integer>> getCnm(int m){
        ans=new ArrayList<>();
        boolean[] chosen=new boolean[nums.length];
        binaryChoose(new boolean[nums.length],m,0);
        return ans;
    }

    void binaryChoose(boolean[] chosen,int left,int pos){
        if(left==0){
            List<Integer> t=new ArrayList<>();
            for(int i=0;i<chosen.length;i++){
                if(chosen[i]){
                    t.add(nums[i]);
                }
            }
            ans.add(t);
            return;
        }
        if(nums.length-pos<left){
            return;
        }

        chosen[pos]=true;
        binaryChoose(chosen,left-1,pos+1);
        chosen[pos]=false;
        binaryChoose(chosen, left, pos+1);
    }

    public List<List<Integer>> subsets(int[] nums) {
        this.nums=nums;
        List<List<Integer>> sons=new ArrayList<>();
        for(int i=0;i<=nums.length;i++){
            sons.addAll(getCnm(i));
        }
        return sons;
    }
}