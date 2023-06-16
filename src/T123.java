

public class T123 {
    public static void main(String[] args){
        Solution123 solution=new Solution123();

        System.out.println(solution.maxProfit(new int[]{7,6,5}));

    }
}

// 需要找到左右两段：底入高出的机会。且，你只有一次遍历机会。
class Solution123 {
    public int maxProfit(int[] prices) {
        int max=0;
        int[] left=new int[prices.length];
        int leftMin = 1000000;
        int leftEarn=0;
        for(int i=0;i<prices.length;i++){
            int earn = prices[i]-leftMin;
//            System.out.println(earn);
            leftEarn = Math.max(earn,leftEarn);
            leftMin = Math.min(leftMin,prices[i]);
            left[i]=leftEarn;
        }

        int[] right=new int[prices.length];
        int rightMax = 0;
        int rightEarn=0;
        for(int i=prices.length-1;i>=0;i--){
            int earn = rightMax - prices[i];
            rightMax = Math.max(rightMax,prices[i]);
            rightEarn = Math.max(rightEarn,earn);
            right[i]=rightEarn;
        }

        for(int i=0;i<prices.length;i++){
            int sum = left[i]+right[i];
            max=Math.max(max,sum);
        }
        return max;
    }

}