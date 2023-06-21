

public class T137 {
    public static void main(String[] args){
        Solution137 solution=new Solution137();
        int[] nums = new int[]{1,2,1,2,-4565,1,2};

        System.out.println(solution.singleNumber(nums));

    }
}

/**
 *
 * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。
 * 请你找出并返回那个只出现了一次的元素。
 *
 * 你必须设计并实现线性时间复杂度的算法且不使用额外空间来解决此问题。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/single-number-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution137 {



    public int singleNumber(int[] nums) {
        int[] count = new int[32];
        int ans=0;
        // 遍历每个数字
        for(int num:nums){
            //遍历数字的32位，若第i位上为1，则计数值+1.
            for(int i =0;i< count.length;i++){
                count[i]+=(num>>i)&1;
            }
        }
        //遍历计数，取余3.
        for(int i =0;i< count.length;i++){
            if(count[i]%3==1){
                ans= ans | (1<<i);
            }
        }
        return ans;
    }
}