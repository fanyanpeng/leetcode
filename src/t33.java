public class t33 {
    public static void main(String[] args){
        Solution33 solution=new Solution33();
        System.out.println(solution.search(new int[]{4,5,6,7,0,1,2},0));

    }
}

class Solution33 {
    //attention:
    //1. nums[0], >=, cant use >, or there is a number left
    public int search(int[] nums, int target) {
        int left=0,right=nums.length;
        while (left<right){
            int mid=(left+right)/2;
            int value=nums[mid];
            //if target is on the left side
            //mid is on the left
            if(target>=nums[0] && (value<target && value>=nums[0])){
                left=mid+1;
            }
            //mid is on the right
            if(target>=nums[0] && (value>target||value<nums[0])){
                right=mid;
            }
            //if target is on the right side
            //mid is on the left
            if(target<nums[0] &&(value<target||value>=nums[0])){
                left=mid+1;
            }
            //mid is on the right
            if(target<nums[0] &&(value>target&&value<nums[0])){
                right=mid;
            }
            if(value==target)return mid;
        }
        return -1;
    }

    public boolean search2(int[] nums, int target) {


        int left=nums[0];
        int right=nums[nums.length-1];
        int l=0;
        int r= nums.length;
        while (l<r){
            int mid=(l+r)/2;
            int midValue=nums[mid];
            if(midValue==target){
                return true;
            }
            if(target>=left){
                if(midValue>target){
                    r=mid;
                }
                if(midValue<target){
                    if(midValue>=left){
                        l=mid+1;
                    }
                    if(midValue<left){
                        r=mid;
                    }
                }
            }
            else if(target<=right){
                if(midValue<target){
                    l=mid+1;
                }
                if(midValue>target){
                    if(midValue<=right){
                        r=mid;
                    }
                    if(midValue>right){
                        l=mid+1;
                    }
                }
            }
        }
        return false;
    }
}