import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class t39 {
    public static void main(String[] args){
        Solution39 solution=new Solution39();
        int[] a=new int[]{1,3,5,6};
        List<List<Integer>> lists=solution.combinationSum(a,8);
        for(List<Integer> list :lists)
            System.out.println(list.toString());
    }
}

class Solution39 {

    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        choose_element(candidates,target,new ArrayList<>(),0);
        return ans;
    }

    /*
    * @author:fanyanpeng
    * @param candidate:     sorted array
    * @param target:    the sum to achieve
    * @param list:      the list for this path
    * @param left:      the left bound of the following element, i must be > = left.
     */
    void choose_element(int[] candidates, int target,List<Integer> list,int left){

        if(target==0){ans.add(list);return;}
        if(target<0){return;}
        int right=available_pos(candidates,target);
        for(int i=left;i<=right;i++){
            List<Integer> l=new ArrayList<>(list);
            l.add(candidates[i]);
            choose_element(candidates, target-candidates[i], l,i);
        }
    }

    int start_pos(int[] a,List<Integer> l){
        if(l.size()==0)return 0;
        int start_value=l.get(l.size()-1);
        for(int i=0;i<a.length;i++){
            if(a[i]>=start_value){
                return i;
            }
        }
        return -1;
    }

//    from right to left
//    get the first value that is smaller than new target.
    int available_pos(int[] a,int t){
        for(int i=a.length-1;i>=0;i--){
            if(a[i]<=t){
                return i;
            }
        }
        return -1;
    }
}