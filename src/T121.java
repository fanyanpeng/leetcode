

public class T121 {
    public static void main(String[] args){
        Solution121 solution=new Solution121();

        System.out.println(solution.maxProfit(new int[]{7,5,654,55554}));

    }
}

// 找到最小值和最大值，遍历一边走就可
class Solution121 {
    public int maxProfit(int[] prices) {

        int min = Integer.MAX_VALUE;
        int maxEarn = 0;
        for(int price:prices){
            int earn = price-min;
            maxEarn = Math.max(earn,maxEarn);
            min = Math.min(price,min);
        }
        return maxEarn;
    }

}