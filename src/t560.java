import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

public class t560 {
    public static void main(String[] args){
        Solution560 solution=new Solution560();

        System.out.println(solution.subarraySum(new int[]{1,2,3},6));

    }
}

class Solution560 {
    public int subarraySum(int[] nums, int k) {
        int count=0;
        HashMap<Integer,Integer> map=new HashMap<>(nums.length);
        int sum=0;
        for (int num : nums) {
            sum += num;
            if (sum == k) {
                count++;
            }
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        Deque<Integer> integerDeque=new ArrayDeque<>();
        integerDeque.add(1);
        integerDeque.add(2);
        System.out.println(integerDeque.getFirst());

        return count;

    }

}