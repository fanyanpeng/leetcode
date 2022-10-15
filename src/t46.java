import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class t46 {
    public static void main(String[] args){
        Solution46 solution=new Solution46();
        int[] a=new int[]{1,2,3};
        System.out.println(solution.permute(a).toString());

    }
}

class Solution46 {



    //使用数组代替列表，减少函数调用。
    List<List<Integer>> ans=new ArrayList<>();
    boolean[] used;
    int[] list;
    public List<List<Integer>> permute(int[] nums) {
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
        for(int i=0;i< nums.length ;i++){
            //only for not used ones
            if(!used[i]){
                //fill this pos; and make this index used.
                list[pos]=nums[i];
                used[i]=true;

                fill_pos(nums,pos+1);
                used[i]=false;
            }
        }
    }




//    //用链表记录，用是否使用列表保证只会遍历一遍。
//    List<List<Integer>> ans=new ArrayList<>();
//    boolean[] used=new boolean[6];
//    List<Integer> list=new ArrayList<>();
//    public List<List<Integer>> permute(int[] nums) {
//        fill_pos(nums,0);
//        return ans;
//    }
//    void fill_pos(int[] nums,int pos){
//        if(pos==nums.length){
//            ans.add(new ArrayList<>(list));return;
//        }
//        //not used
//        for(int i=0;i< nums.length ;i++){
//            if(!used[i]){
//                list.add(nums[i]);
//                used[i]=true;
//                fill_pos(nums,pos+1);
//                used[i]=false;
//                list.remove(list.size()-1);
//            }
//        }
//    }





//    List<List<Integer>> ans=new ArrayList<>();
//    public List<List<Integer>> permute(int[] nums) {
//        fill_pos(nums,new ArrayList<>(6));
//        return ans;
//    }
//    void fill_pos(int [] nums,List<Integer> chosen){
//        if(chosen.size()==nums.length){
//            ans.add(new ArrayList<>(chosen));
//            return;
//        }
//        List<Integer> avail=get_available_list(nums,chosen);
//        for(Integer i:avail){
//            //List<Integer> t_chosen=new ArrayList<>(chosen);
//            chosen.add(i);
//            fill_pos(nums,chosen);
//            chosen.remove(chosen.size()-1);
//        }
//    }
//    List<Integer> get_available_list(int[] nums,List<Integer> chosen){
//        List<Integer> avail=new ArrayList<>();
//        for(int i:nums){
//            if(!chosen.contains(i)){
//                avail.add(i);
//            }
//        }
//        return avail;
//    }




//
//    public List<List<Integer>> permute(int[] nums,int pos){
//        List<List<Integer>> ans=new ArrayList<>();
//        if(pos==0){
//            List<Integer> l=new ArrayList<>();
//            l.add(nums[0]);
//            ans.add(l);
//            return ans;
//        }
//        //pos>=1
//        List<List<Integer>> last_lists=permute(nums,pos-1);
//        for(List<Integer> list: last_lists){
//            //[1,2,3]
//            Integer[] before=list.toArray(new Integer[0]);
//            int[] pos_added=new int[before.length+1];
//            for(int i=0;i<before.length;i++){
//                pos_added[i]=before[i];
//            }
//            pos_added[before.length]=nums[pos];
//            //[1,2,3,4]
//
//            for(int i=0;i<pos_added.length;i++){
//                int[] temp= pos_added.clone();
//                if(temp[i]!=temp[pos] || i==pos){
//                    //replace and add to ans
//                    int t=temp[i];
//                    temp[i]=temp[pos];
//                    temp[pos]=t;
//                    List<Integer> new_list=new ArrayList<>();
//                    for(int k=0;k<temp.length;k++){
//                        new_list.add(temp[k]);
//                    }
//                    ans.add(new_list);
//                }
//            }
//        }
//        return ans;
//    }

}