import java.util.Arrays;

public class t31 {
    public static void main(String[] args){
        Solution31 solution=new Solution31();
        int[] nums=new int[]{3,7,33,3};
        solution.nextPermutation_2023_6_18(nums);
        System.out.println(Arrays.toString(nums));
    }
}

class Solution31 {

    public void nextPermutation_2023_6_18(int[] nums){
        boolean swapped = false;    //针对特殊情况，全部逆序
        int leftLow = nums.length-1;
        for(;leftLow>=0;leftLow--){
            int minRightBiggerThanLeft=1000; // 比左侧大的最小值
            int minRightBiggerThanLeftIndex=-1;
            // 遍历左侧值，找到比当前值大的最小值。
            for(int i=leftLow+1;i< nums.length;i++){
                if(nums[i]>nums[leftLow] &&nums[i]<minRightBiggerThanLeft){
                    minRightBiggerThanLeft = nums[i];
                    minRightBiggerThanLeftIndex = i;
                }
            }
            // 交换位置，因为这是最靠近右边的值，是最小的向上趋势
            if(minRightBiggerThanLeftIndex>=0){
                swap(nums,leftLow,minRightBiggerThanLeftIndex);
                swapped=true;
                break;
            }
        }
        if(!swapped){
            leftLow=-1;
        }
        Arrays.sort(nums,leftLow+1,nums.length);
    }
    private void swap(int[] nums,int i,int j){
        int tmp = nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }

























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