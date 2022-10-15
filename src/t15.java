import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class t15 {
    public static void main(String[] args){
        Solution15 solution=new Solution15();
        int[] a =new int[]{-2,0,1,1,2};
        List<List<Integer>> ans=solution.threeSum(a);
        for (List<Integer> list:ans) {
            for(Integer i:list){
                System.out.print(i+" ");
            }
            System.out.println("");
        }
        System.out.println();

    }
}

class Solution15{
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if(i>0 && nums[i]==nums[i-1])continue;
            int num = (nums[i]);
            if(num>0)break;
            int l = i + 1;
            int r = len - 1;
            while (l < r) {
                int t = nums[l] + nums[r];
                if (t > -num) r--;
                else if (t < -num) l++;
                else if (t == -num) {
                    List<Integer> list = new ArrayList<>();
                    ans.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    while (l<r && nums[l]==nums[l+1])l++;
                    while (l<r && nums[r]==nums[r-1])r--;
                    r--;l++;
                }
            }
        }
        return ans;
    }
}
