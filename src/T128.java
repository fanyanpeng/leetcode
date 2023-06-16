import java.util.Arrays;
import java.util.HashSet;

public class T128 {
    public static void main(String[] args){
        Solution128 solution=new Solution128();

        System.out.println(solution.longestConsecutive(new int[]{100,4,200,1,3,2}));

    }
}

class Solution128 {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> visited =new HashSet<>();
        for(int i:nums){
            set.add(i);
        }
        int max=0;

        for(int i:nums){
            if(visited.contains(i)){
                continue;
            }
            int down=0;
            int up=0;
            while (set.contains(i-down-1)){
                down++;
                visited.add(i-down);
            }
            while (set.contains(i+up+1)){
                up++;
                visited.add(i+up);
            }
            max=Math.max(down+up+1,max);
        }
        return max;
    }
}