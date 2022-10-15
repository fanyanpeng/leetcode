public class t27 {
    public static void main(String[] args){
        Solution27 solution=new Solution27();
        int[] nums=new int[]{0,1,2,2,3,0,4,2};
        int count=solution.removeElement(nums,2);
        for(int i=0;i<count;i++)
            System.out.println(nums[i]);
    }
}

class Solution27 {
    public int removeElement(int[] nums, int val) {
        int count=nums.length;
        int pos=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==val)count--;//若已经重复或者存在
            if(nums[i]!=val){//若和上一个数不同
                nums[pos++]=nums[i];
            }
        }
        return count;
    }
}