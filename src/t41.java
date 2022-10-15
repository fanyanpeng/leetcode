import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class t41 {
    public static void main(String[] args){
        Solution41 solution=new Solution41();
        int[] a=new int[]{3,4,-1,1};
        System.out.println(solution.firstMissingPositive(a));

    }
}

class Solution41 {


    public int firstMissingPositive(int[] nums) {


        for (int i=0;i<nums.length;i++) {
            if(nums[i]<=0||nums[i]>nums.length)nums[i]=nums.length+1;
        }

        for(int i=0;i<nums.length;i++){
            int t=Math.abs(nums[i]);
            if(t!=nums.length+1){
                nums[t-1]=-Math.abs(nums[t-1]);
            }
        }

        for(int i=0;i<nums.length;i++){
            if(nums[i]>=0)return i+1;
        }

        return nums.length+1;

    }



//    //swap to the right position
//    //attention: avoid swap dead loop: if nums[x-1]==nums[i], program would do that forever
//    public int firstMissingPositive(int[] nums) {
//
//
//        for (int i=0;i<nums.length;i++) {
//            while (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i]-1]!=nums[i]) {
//                swap(nums,i,nums[i]-1);
//            }
//        }
//        for(int i=0;i< nums.length;i++){
//            if(nums[i]!=i+1){
//                return i+1;
//            }
//        }
//        return nums.length+1;
//
//    }
//    void swap(int[] nums,int i,int j){
//        int t=nums[i];
//        nums[i]=nums[j];
//        nums[j]=t;
//    }



//    static final int SIZE=500000;
//    public int firstMissingPositive(int[] nums) {
//
//        boolean[] used=new boolean[Math.min(nums.length,SIZE)+1];
//        for (int num : nums) {
//            if (num > 0 && num < used.length) {
//                used[num - 1] = true;
//            }
//        }
//        for(int i=0;i< used.length;i++){
//            if(!used[i]){
//                return i+1;
//            }
//        }
//
//        return 0;
//
//    }

}