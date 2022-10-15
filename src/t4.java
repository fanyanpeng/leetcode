import java.util.ArrayList;

public class t4 {

    public static void main(String[] args){

        int[] a={1,2};
        int[] b={1,1};
        System.out.print(Solution4.findMedianSortedArrays(a,b));

    }
}




class Solution4 {













    public double findMedianSortedArrays_standard(int[] nums1, int[] nums2) {
        /**
         如果两个数组的中位数 mid1 < mid2, 则说明合并后的中位数位于 num1.right + num2之间
         否则合并后的中位数位于 nums2.right + nums1 之间 (right 是相对于 mid 而言的)
         getKth 函数负责找到两个数组合并(假设)后有序的数组中的第 k 个元素, k 从 1 开始计算
         **/
        if(nums1.length == 0 && nums2.length == 0) return 0.0;
        int m = nums1.length, n = nums2.length;
        // l: 合并后数组的左半部分的最后一个数 r: 合并后数组的右半部分的第一个数
        int l = (m+n+1) / 2;
        int r = (m+n+2) / 2;
        // 如果 m+n 是奇数 getKth 的返回值是相同的, 是偶数则是合并后数组的中间两个数
        if(l == r) return getKth(nums1, 0, nums2, 0, l);
        return (getKth(nums1, 0, nums2, 0, l) + getKth(nums1, 0, nums2, 0, r)) / 2.0;
    }

    private double getKth(int[] nums1, int st1, int[] nums2, int st2, int k) {
        // 边界情况, 如果 nums1数组已经穷尽了, 则只能返回 nums2 中的第 k 个元素
        if(st1 > nums1.length-1) return nums2[st2 + k - 1];
        if(st2 > nums2.length-1) return nums1[st1 + k - 1];
        // 边界情况, k = 1 则返回两个数组中最小的那个
        if(k == 1) return Math.min(nums1[st1], nums2[st2]);
        // 在 nums1 和 nums2 当前范围内找出 mid1 和 mid2 判断舍弃哪半部分
        int mid1 = Integer.MAX_VALUE;
        int mid2 = Integer.MAX_VALUE;
        if(st1 + k/2 - 1 < nums1.length) mid1 = nums1[st1 + k/2 - 1];
        if(st2 + k/2 - 1 < nums2.length) mid2 = nums2[st2 + k/2 - 1];
        // mid1 < mid2 在 nums1.right 和 nums2 之间搜索, 丢掉 k/2 个数.
        if(mid1 < mid2)
            return getKth(nums1, st1 + k/2, nums2, st2, k - k/2);
        else
            return getKth(nums1, st1, nums2, st2 + k/2, k - k/2);
    }



    /*
    先判断一个不会走到头的列表：长度更大 or 长度相同_最大值更小
    （若选择了最大值更大，那么最大值更小的一方可能移动长度n，导致数组越界）
    （选择最大值更小，left，right应用与最大值更大的列表，不可能移动n；）

    不断以小换大；L2中的小换L1中的大。
    说明：需要与L1中前一个位置比较；如果和当前位置比较，是没有办法决定是否移动的；需要考虑后一个位置更大的值。
    二分法查找可以移动到的位置，L2中的数与L1的后一个位置作比较，比它小，说明需要移动
    比它大，不能以大换小；
    两个值相等时处理方式不要求：>= or > 都可以
     */


    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int l1=nums1.length;
        int l2=nums2.length;
        int[] big,small;
        if(l1>l2 || l1==l2 && nums1[l1-1]<=nums2[l2-1] ){
            big=nums1;small=nums2;
        }
        else {
            big=nums2;small=nums1;
        }

        int l_big=big.length;
        int l_small=small.length;

        int pos_1=(l_big+l_small-1)/2;
        int pos_2=-1;
        int left=0;
        int right=l_small;

        if(l_small!=0 && small[0]<big[pos_1]){
            while (left != right) {
                int mid = (right + left) / 2;   //
                int move = mid - pos_2;
                int temp1 = big[pos_1 - move + 1];//考虑列表2与列表1的前一个位置比较
                //若比前一个位置大，移动后：不是有效的移动；
                //若不比前一个位置大，可以移动；
                int temp2 = small[pos_2 + move];
                if (temp1 >= temp2) {//moveable
                    //(mid+1, right)
                    left = mid + 1;
                    pos_1 -= move;
                    pos_2 += move;
                } else {
                    //(left, mid)
                    right = mid;
                }
            }
        }

        int mid1=1;
        mid1=big[pos_1];
        if(pos_2!=-1 && (small[pos_2]>mid1)){
            mid1=small[pos_2];
        }

        boolean initialized=false;

        int mid2=1;
        pos_1++;
        pos_2++;
        if(pos_1<l_big){
            mid2=big[pos_1];
            initialized=true;
        }
        if(pos_2<l_small && (!initialized || small[pos_2]<mid2)){
            mid2=small[pos_2];
            initialized=true;
        }
        if((l1+l2)%2==1){
            return mid1*1.0;
        }
        else {
            return (mid1+mid2)*1.0/2;
        }
    }
}




