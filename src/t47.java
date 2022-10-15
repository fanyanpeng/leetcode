import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class t47 {
    public static void main(String[] args){
        Solution47 solution=new Solution47();
        int[] a=new int[]{1,1,2,2};
        System.out.println(solution.permuteUnique(a));

    }
}

class Solution47 {


    //使用数组代替列表，减少函数调用。
    List<List<Integer>> ans=new ArrayList<>();
    boolean[] used;
    int[] list;

    public List<List<Integer>> permuteUnique(int[] nums){
        used=new boolean[nums.length];
        list=new int[nums.length];
        fill_pos(nums,0);
        return ans;
    }

    void fill_pos(int[] nums,int pos){
        //when finished, add to ans list
        if(pos==nums.length){
            List<Integer> a=new ArrayList<>(nums.length);
            for(int i:list)a.add(i);
            ans.add(a);
            return;
        }
        //record all available nums used this time;
        List<Integer> repeat_nums=new ArrayList<>();
        for(int i=0;i< nums.length ;i++){
            //only for not used ones
            if(!used[i] && !repeat_nums.contains(nums[i])){
                //fill this pos; and make this index used.
                list[pos]=nums[i];
                used[i]=true;
                repeat_nums.add(nums[i]);

                fill_pos(nums,pos+1);
                used[i]=false;
            }
        }
    }


}