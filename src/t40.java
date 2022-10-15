import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class t40 {
    public static void main(String[] args){
        Solution40 solution=new Solution40();
        int[] a=new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        List<List<Integer>> lists=solution.combinationSum2(a,30);
        System.out.println(lists.toString());
    }
}

class Solution40 {
    List<List<Integer>> ans=new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        choose_element(candidates,target,new ArrayList<>(),0,false);
        return ans;
    }

    void choose_element(int[] nums, int target,List<Integer> list,int pos,boolean chosen){
        if(target==0){
            ans.add(list);return;
        }
        if(pos==nums.length)return;
        //target is already invalid or smaller than nums coming next.
        if(target<0 || target<nums[pos]){
            return;
        }

        if(pos==0 || nums[pos-1]!=nums[pos] ||chosen){//can choose
            List<Integer> list1=new ArrayList<>(list);//choose
            list1.add(nums[pos]);
            choose_element(nums,target-nums[pos],list1,pos+1,true);

            List<Integer> list2=new ArrayList<>(list);//not choose
            choose_element(nums,target,list2,pos+1,false);
        }
        else {//not able to choose
            List<Integer> list3=new ArrayList<>(list);
            choose_element(nums,target,list3,pos+1,false);
        }
    }

}