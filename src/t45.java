public class t45 {
    public static void main(String[] args){
        Solution45 solution=new Solution45();
        int[] a=new int[]{3,2,1};
        System.out.println(solution.jump(a));

    }
}

class Solution45 {
    public int jump(int[] nums) {
        int count=0;
        int pos=0;
        while (pos < nums.length-1){//when it comes to len-1, it should end
            pos=jump_to(nums,pos);
            count++;
        }
        return count;
    }

    //typical max replace function
    int jump_to(int [] nums,int pos){
        int max=0;//the furthest position can reach
        int max_pos=pos+1;
        for(int i=pos+1;i<=pos+nums[pos] && i<nums.length;i++){
            if(nums[i]+i>=max){
                max=nums[i]+i;
                max_pos=i;
            }
            if(i==nums.length-1)return i;//finished!!!
        }
        return max_pos;
    }

}