public class t55 {
    public static void main(String[] args){
        Solution55 solution=new Solution55();
        int[] a=new int[]{0,2,3};
        System.out.println(solution.canJump(a));

    }
}

class Solution55 {

    public boolean canJump(int[] nums) {
        return  canJump_to_pos(nums,nums.length-1);

    }
    //2,0,1
    public boolean canJump_to_pos(int[] nums,int pos) {
        if(pos<=0)return true;
        for(int i=pos-1;i>=0;i--){
            if(nums[i]>=pos-i){
                if(i==0)return true;
                return canJump_to_pos(nums,i);
            }
        }
        return false;

    }


}