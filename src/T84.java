import java.util.ArrayDeque;
import java.util.Deque;

public class T84 {
    public static void main(String[] args){
        Solution84 solution=new Solution84();

        System.out.println(solution.largestRectangleArea(new int[]{2,1,5,6,2,3}));

    }
}

class Solution84 {



    public int largestRectangleArea(int[] heights) {
        int maxArea=0;
        int[] left=new int[heights.length];
        int[] right=new int[heights.length];
        Deque<Integer> l_stack=new ArrayDeque<>();
        Deque<Integer> r_stack=new ArrayDeque<>();

        int n= heights.length;
        l_stack.push(-1);
        r_stack.push(heights.length);

        for(int i=0;i<n;i++){
            int h=heights[i];
            while (l_stack.size()>1 && heights[l_stack.peek()]>=h){
                int pop=l_stack.pop();

            }
            left[i]=l_stack.peek();
            l_stack.push(i);
        }
        for(int i=n-1;i>=0;i--){
            int h=heights[i];
            while (r_stack.size()>1 && heights[r_stack.peek()]>=h){
                int pop=r_stack.pop();
            }
            right[i]=r_stack.peek();
            r_stack.push(i);
        }

        for(int i=0;i< heights.length;i++){
            int area=heights[i]*(right[i]- left[i] -1 );
            maxArea=Math.max(area,maxArea);
        }
        return maxArea;

    }



//
//    int maxArea=0;
//    public int largestRectangleArea(int[] heights) {
//
//        for(int i=0;i<heights.length;i++){
//            int area=getArea(heights,i);
//            maxArea=Math.max(area,maxArea);
//        }
//
//        return maxArea;
//    }
//
//    private int getArea(int[] heights, int pos) {
//        int h=heights[pos];
//        if(h*heights.length<=maxArea){
//            return  0;
//        }
//        int left=pos,right=pos;
//        for(int i=pos;i>=0;i--){
//            if(heights[i]<h){
//                break;
//            }
//            else {
//                left=i;
//            }
//        }
//        for(int i=pos;i<heights.length;i++){
//            if(heights[i]<h){
//                break;
//            }
//            else {
//                right=i;
//            }
//        }
//        return (right-left+1) *h;
//
//
//    }



//    int maxArea=0;
//    public int largestRectangleArea(int[] heights) {
//        findLargest(heights,0, heights.length-1);
//        return maxArea;
//    }
//
//
//    void findLargest(int[] heights,int l,int r){
//        if(l>r){
//            return;
//        }
//        if(calculateMaxArea(heights, l, r)<=maxArea){
//            return;
//        }
//        int area= calculateMinArea(heights, l, r);
//        maxArea=Math.max(area,maxArea);
//
//        int index=findMinIndex(heights, l, r);
//        findLargest(heights, l, index-1);
//        findLargest(heights,index+1, r);
//
//    }
//
//    private int calculateMinArea(int[] heights, int l, int r){
//        if(l>r){
//            return 0;
//        }
//        int index=findMinIndex(heights, l, r);
//        return heights[index]*(r-l+1);
//    }
//    private int calculateMaxArea(int[] heights, int l, int r){
//        if(l>r){
//            return 0;
//        }
//        int index=findMaxIndex(heights, l, r);
//        return heights[index]*(r-l+1);
//    }
//
//
//
//    private int findMinIndex(int [] nums,int l,int r){
//        int min=l;
//        for(int i=l;i<=r;i++){
//            if(nums[i]<nums[min]){
//                min=i;
//            }
//        }
//        return min;
//    }
//    private int findMaxIndex(int [] nums,int l,int r){
//        int max=l;
//        for(int i=l;i<=r;i++){
//            if(nums[i]>nums[max]){
//                max=i;
//            }
//        }
//        return max;
//    }

}