import java.util.Arrays;

public class t31 {
    public static void main(String[] args){
        Solution31 solution=new Solution31();
        int[] nums=new int[]{2,2,7,5,4,3,2,2,1};
        solution.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}

class Solution31 {
    public void nextPermutation(int[] nums) {
        int up=1;
        int len=nums.length;
        if(len==1)return;
        for(int i=len-1;i>0;i--){
            if(nums[i]<=nums[i-1]){
                up++;
            }
            else break;
        }
        int left=len-1-up;
        left=Math.max(0,left);

        int count=0;
        for(int i=len-1;i>left;i--){
            count+=1;
            if(nums[i]>nums[left])break;
        }
        if(len-up==0)count=1;

        for(int k=0;k<count;k++){
            //move the min to the begin
            int pre_value=nums[len-1];
            for(int i=left;i<len;i++){
                int temp=nums[i];
                nums[i]=pre_value;
                pre_value=temp;
            }
        }


        //sort
        Arrays.sort(nums,left+1,len);
//        for(int i=left+1;i<len;i++){
//            for(int j=0;j<len-1-i;j++){
//                if(nums[j]>nums[j+1]){
//                    int temp=nums[j];
//                    nums[j]=nums[j+1];
//                    nums[j+1]=temp;
//                }
//            }
//        }
    }
}