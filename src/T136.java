

public class T136 {
    public static void main(String[] args){
        Solution136 solution=new Solution136();

        System.out.println(solution);

    }
}

class Solution136 {

    public int singleNumber(int[] nums) {
        int ans  = 0;
        for(int num : nums){
            ans = num^ans;
        }
        return ans;

    }

}