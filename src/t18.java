import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class t18 {
    public static void main(String[] args){
        Solution18 solution=new Solution18();
        System.out.println(solution);

    }
}

class Solution18{
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int sum3=target-nums[i];
            if (i>0&&nums[i]==nums[i-1])continue;
            for(int j=i+1;j<nums.length;j++){
                int sum2=sum3-nums[j];
                if (j>i+1&&nums[j]==nums[j-1])continue;
                int l=j+1;
                int r=nums.length-1;
                while (l<r){
                    if(nums[l]+nums[r]<sum2)l++;
                    if(nums[l]+nums[r]>sum2)r--;
                    if(nums[l]+nums[r]==sum2){
                        list.add(Arrays.asList(nums[i],nums[j],nums[l],nums[r]));
                        while (l<r&&nums[l]==nums[l+1])l++;
                        while (l<r&&nums[r]==nums[r-1])r--;
                        l++;r--;
                    }
                }
            }
        }
        return list;

    }
}