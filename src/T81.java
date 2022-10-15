public class T81 {
    public static void main(String[] args){
        Solution81 solution=new Solution81();

        System.out.println(solution.search(new int[]{2,2,2,3,2,2,2},3));

    }
}

class Solution81 {

    int[] nums;
    int k;

    public boolean search(int[] nums, int target) {

        this.nums=nums;
        findK(nums);
        int l=0;
        int r= nums.length;
        while (l<r){
            int mid=(l+r)/2;
            int v=getValue(mid);
            if(v>target){
                r=mid;
            }
            else if(v<target){
                l=mid+1;
            }
            else {
                return true;
            }
        }
        return false;


    }

    int getValue(int i){
        int offset= nums.length-k;
        int v=0;
        if(i>k-1){
            v= nums[i-k];
        }
        if(i<=k-1){
            v= nums[i+offset];
        }
        return v;
    }

    void findK(int[] nums){
//        for(int i=1;i<nums.length;i++){
//            if(nums[i]<nums[i-1]){
//                k=nums.length - i;
//                return;
//            }
//        }
        int n=nums.length;
        int l=0;
        int r= nums.length;
        while (l<r && nums[r-1]==nums[0]){
            r--;
        }
        while (l<r){
            int mid=(l+r)/2;
            int val=nums[mid];
            if(val>=nums[0]){
                l=mid+1;
            }
            else if(val<=nums[n-1]){
                r=mid;
            }
        }
        int offset=r;
        k= n-offset;

    }

}