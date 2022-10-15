import java.util.Arrays;

public class t35 {
    public static void main(String[] args){
        Solution35 solution=new Solution35();
        int[] a=new int[]{1,3,5,6};
        System.out.println(solution.searchInsert(a,0));

    }
}

class Solution35 {
    public int searchInsert(int[] nums, int target) {
        int left=0,right=nums.length;
        int mid=-1;
        while (left<right){
            mid=(left+right)/2;
            if(nums[mid]<target){
                left=mid+1;
            }
            if(nums[mid]>target){
                right=mid;
            }
            if(nums[mid]==target){
                break;
            }
        }
        return (left+right)/2;
    }
}