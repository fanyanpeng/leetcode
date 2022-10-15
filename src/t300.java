public class t300 {
    public static void main(String[] args){
        Solution300 solution=new Solution300();

        System.out.println(solution.lengthOfLIS(new int[]{10,1,0,2,0,0,3,0,4}));

    }
}

class Solution300 {
    public int lengthOfLIS(int[] nums) {
        int len=0;
        int[] tail=new int[nums.length];
        tail[0]=nums[0];
        for(int num:nums){
            if(num<tail[len]){
                //replace
                int l=0;
                int r=len;
                while (l<=r){
                    int mid=(l+r)/2;
                    if(tail[mid]>=num){
                        r=mid-1;
                    }
                    else {
                        l=mid+1;
                    }
                }
                //l is the pos
                tail[l]=num;
            }
            if(num>tail[len]){
                len+=1;
                tail[len]=num;
            }

        }
        return len+1;

    }

}