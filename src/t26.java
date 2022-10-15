public class t26 {
    public static void main(String[] args){
        Solution26 solution=new Solution26();
        int[] nums=new int[]{0,0,1,1,1,2,2,3,3,4};
        int count=solution.removeDuplicates(nums);
        for(int i=0;i<count;i++)
            System.out.println(nums[i]);
    }
}

class Solution26 {
    public int removeDuplicates(int[] nums) {
        int count=nums.length;
        int min=-100000;
        int pos=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==min)count--;//若已经存在
            if(nums[i]!=min){//若和上一个数不同
                nums[pos++]=nums[i];
                min=nums[i];
            }
        }
        return count;
    }
}
