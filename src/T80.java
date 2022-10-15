import java.util.Arrays;

public class T80 {
    public static void main(String[] args){
        Solution80 solution=new Solution80();

        int[] ins=new int[]{1,1,1,2,2,3};

        System.out.println(solution.removeDuplicates2(ins));
        System.out.println(Arrays.toString(ins));
    }
}

class Solution80 {

    static int REMOVED=100000;
    public int removeDuplicates(int[] nums) {

        int cur=REMOVED;
        int len=nums.length;
        int count=0;
        for(int i=0;i<nums.length;i++){
           if(nums[i]==cur){
               count+=1;
           }
           if(nums[i]!=cur){
               count=1;
               cur=nums[i];
           }

           if(count>2){
               nums[i]=REMOVED;
               len--;
           }
        }


        int ptr=0;
        for(int i=0;i<len;i++){
            ptr=findNextNotRemoved(ptr,nums);
            swap(nums,i,ptr);
            ptr++;
        }
        return len;

    }

    private int findNextNotRemoved(int ptr,int[] nums){
        for(int i=ptr;i<nums.length;i++){
            if(nums[i]!=REMOVED){
                return i;
            }
        }
        return 0;
    }

    private void swap(int[] nums,int i,int j){
        int t=nums[i];
        nums[i]=nums[j];
        nums[j]=t;
    }


    public int removeDuplicates2(int[] nums) {

        int k=2;
        int pos=0;
        for(int i=0;i<nums.length;i++){
            if(pos>=k && nums[pos-k]==nums[i]){
                continue;
            }
            nums[pos++]=nums[i];
        }
        return pos;
    }

}