import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class t16 {
    public static void main(String[] args){
        Solution16 solution=new Solution16();
        System.out.println(solution);

    }
}

class Solution16{

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int best_match=1000000;
        for(int i=0;i<nums.length;i++){
            int sum2=target-nums[i];
            //if (i>0&&nums[i]==nums[i-1])continue;

            int l=i+1;
            int r=nums.length-1;
            while (l<r){
                if(nums[l]+nums[r]<sum2) l++;
                else if(nums[l]+nums[r]>sum2)r--;
                else if(nums[l]+nums[r]==sum2){
                    best_match=target;return best_match;
                }
                int sum=nums[i]+nums[l]+nums[r];
                if(Math.abs(sum-target)<Math.abs(target-best_match)){
                    best_match=sum;
                }
                if(l==r-1){

                }
            }

        }
        return best_match;

    }
}