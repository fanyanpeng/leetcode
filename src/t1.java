import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;

public class t1 {
    public static void main(String[] args){
        int[] nums={1,4,8,6,4};
        int target=8;
        int[] pos=Solution1.twoSum_HASH(nums,target);
        for(int i:pos){
            System.out.print(i);
        }




    }
}
class Solution1 {





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