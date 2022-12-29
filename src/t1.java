import java.util.*;

public class t1 {
    public static void main(String[] args){
        int[] nums={1,4,8,6,4};
        int target=8;
        int[] pos=Solution1.twoSum_HASH(nums,target);
//        for(int i:pos){
//            System.out.print(i);
//        }


        System.out.println(Solution1.strStr("s","s"));


    }
}
class Solution1 {



    public static int strStr(String haystack, String needle) {
        char[] c1 = haystack.toCharArray();
        char[] c2 = needle.toCharArray();
        int[] post = new int[c2.length];
        post[0]=0;
        int k =0;
        for(int i=1;i<c2.length;i++){
            char c = c2[i];
            while(c != c2[k]){
                if(k>0){
                    k = post[k-1];
                }
                if(k==0){
                    break;
                }
            }
            if(c==c2[k]){
                k++;
            }
            post[i]=k;
        }
//        System.out.println(Arrays.toString(c2));
//        System.out.println(Arrays.toString(post));

        k=0;
        for(int i=0;i<c1.length;i++){
            char c = c1[i];
            while (c!=c2[k]){
                if(k>0){
                    k = post[k-1];
                }
                if(k==0){
                    break;
                }
            }
            if(c == c2[k]){
                k++;
                if(k==c2.length){
                    return i-k+1;
                }
            }
        }
        return -1;
    }


    public static int[] twoSum_again(int[] nums, int target) {
       HashMap<Integer,Integer> map=new HashMap<>(nums.length);
       for(int i=0;i<nums.length;i++){
           int nextHalf=target-nums[i];
           if(map.containsKey(nextHalf)){
               int[] xy=new int[]{map.get(nextHalf),i};
               return xy;
           }
           map.put(nums[i],i);
       }
       return null;
    }






    public static int[] twoSum(int[] nums, int target) {
        int l=nums.length;

        for(int i=0;i<l;i++){
            for(int j=i+1;j<l;j++){
                if(nums[i]+nums[j]==target){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    public static int[] twoSum_HASH(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<>();
        int l=nums.length;
        for(int i=0;i<l;i++){
            map.put(nums[i],i);
        }
        for(int i=0;i<l;i++){
            int left=target- nums[i];
            if (map.get(left)!=null) {
                if(i!=map.get(left)){
                    return new int[]{i, map.get(left)};
                }

            }
        }

        return null;
    }
}