

public class T122 {
    public static void main(String[] args){
        Solution122 solution=new Solution122();

        System.out.println(solution);

    }
}
//找到所有上升阶段的股票，买入；当下一个不如当前的时候，就离手。
// 即求一个数据：后一个比前一个大时的，求和。
class Solution122 {
    public int maxProfit(int[] prices) {
        int earn = 0;
        for(int i = 0;i<prices.length-1;i++){
            if(prices[i+1]>prices[i]){
                earn+=(prices[i+1]-prices[i]);
            }
        }
        return earn;
    }
}