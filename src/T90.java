import java.util.*;

public class T90 {
    public static void main(String[] args){
        Solution90 solution=new Solution90();
        List<List<Integer>> ans = solution.subsetsWithDup3(new int[]{1,2,2,1});

        for(List<Integer> set : ans){
            System.out.println(Arrays.toString(set.toArray()));
        }


    }
}

class Solution90 {


    /**
     * 思路三：带有剪枝的回溯法 1ms 99%
     * @author   fanyanpeng
     * @date 2022/10/21 2:10
     * @param nums
     * @return java.util.List<java.util.List<java.lang.Integer>>
     */
    public List<List<Integer>> subsetsWithDup3(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<>();
        int bits = nums.length;
        List<Integer> set = new ArrayList<>();
        dfs(nums,0,set,ans,false);
        return ans;
    }

    void dfs(int[] nums,int currIndex,List<Integer> set, List<List<Integer>> ans,boolean chosen){
        if(currIndex == nums.length){
            ans.add(new ArrayList<>(set));
            return;
        }

        // 当前一个没选的时候，当前元素也不选。保证选中的元素之间不能出现未被选中的情况。
        if(currIndex>0 && nums[currIndex-1]==nums[currIndex] && !chosen){
            dfs(nums, currIndex+1, set, ans, false);
            return;
        }

        set.add(nums[currIndex]);
        dfs(nums, currIndex+1, set, ans, true);
        set.remove(set.size()-1);
        dfs(nums, currIndex+1, set, ans, false);
    }


    /**
     * 思路二：依然位运算，只处理连续的1. 遇到001,101,010，都不采用；只处理：100,110,111这种。
     * 逻辑是：若前后数字相同 && 当前位置选中 && 上一个位置没选中 -》不采用。 2ms
     * @author   fanyanpeng
     * @date 2022/10/21 2:10
     * @param nums
     * @return java.util.List<java.util.List<java.lang.Integer>>
     */
    public List<List<Integer>> subsetsWithDup2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<>();
        int bits = nums.length;
        List<Integer> set = new ArrayList<>();
        for(int i=0;i<1<<bits;i++){
            set.clear();
            boolean adapted = true;
            for(int j=0;j<bits;j++){
                if(j>0 &&nums[j]==nums[j-1] && ((i & (1<<j))>0)  && ((i & (1<<j-1))==0)){
                    adapted=false;
                    continue;
                }
                if((i & (1<<j))>0){
                    set.add(nums[j]);
                }
            }
            if(adapted){
                ans.add(new ArrayList<>(set));
            }
        }
        return ans;
    }

    /**
     * 思路一：位运算，使用hashset存是否重复。
     * 复杂度 n*2^n，空间复杂度2^n,因为最终的结果也需要本空间复杂度来存储，忽略。 4ms
     * @author   fanyanpeng
     * @date 2022/10/21 2:10
     * @param nums
     * @return java.util.List<java.util.List<java.lang.Integer>>
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<>();
        HashSet<String> sets = new HashSet<>();
        int bits = nums.length;
        for(int i=0;i<1<<bits;i++){
            List<Integer> set = new ArrayList<>();
            for(int j=0;j<bits;j++){
                if((i & (1<<j))>0){
                    set.add(nums[j]);
                }
            }

            String key = Arrays.toString(set.toArray());

            if(!sets.contains(key)){
                ans.add(set);
                sets.add(key);
            }
        }
        return ans;
    }



}