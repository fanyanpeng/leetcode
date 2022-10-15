import java.util.Arrays;

public class t34 {
    public static void main(String[] args){
        Solution34 solution=new Solution34();
        int[] a=new int[]{5,7,7,8,8,10};
        System.out.println(Arrays.toString(solution.searchRange(a,33)));

    }
}

class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{left_edge(nums,target),right_edge(nums,target)};
    }

    int left_edge(int[] nums, int target){
        int left=0;
        int right=nums.length;

        while (left<right){
            int mid=(right+left)/2;
            if(nums[mid]<target){
                left=mid+1;
            }
            if(nums[mid]>target){
                right=mid;
            }

            if(nums[mid]==target){
                if(mid-1>=0&&nums[mid-1]==target){
                    right=mid;
                }
                else return mid;
            }
        }
        return -1;
    }
    int right_edge(int[] nums, int target){

        int left=0;
        int right=nums.length;

        while (left<right){
            int mid=(right+left)/2;
            if(nums[mid]<target){
                left=mid+1;
            }
            if(nums[mid]>target){
                right=mid;
            }

            if(nums[mid]==target){
                if(mid+1<nums.length&&nums[mid+1]==target){
                    left=mid+1;
                }
                else return mid;
            }
        }
        return -1;
    }
}