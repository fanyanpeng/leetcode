public class t53 {
    public static void main(String[] args){
        Solution53 solution=new Solution53();
        int[] a=new int[]{3,4,-1,1};
        System.out.println(solution);

    }
}

class Solution53 {
    public int maxSubArray(int[] nums) {
        int max=nums[0];
        int sum=0;
        for(int num : nums){
            sum+=num;
            max=Math.max(max,sum);
            sum= Math.max(sum, 0);
        }
        return max;
    }
}