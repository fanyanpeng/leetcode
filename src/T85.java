import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class T85 {
    public static void main(String[] args){
        Solution85 solution=new Solution85();

        System.out.println(solution.largestRectangleArea(new int[]{12,2,3}));

    }
}

class Solution85 {


    public int maximalRectangle(char[][] matrix) {
        int maxR=0;

        int m=matrix.length;
        int n=matrix[0].length;
        //对于每一列考虑偏移量
        for(int offset=0;offset<n;offset++){
            //m行，每一行计数
            int[] height=new int[m];
            for(int i=0;i<m;i++){
                //此处自偏移量开始计算，遇到0，就跳出
                for(int j=offset;j<n;j++){
                    if(matrix[i][j]=='0'){
                        break;
                    }
                    else {
                        height[i]++;
                    }
                }
            }
            int max=largestRectangleArea(height);
            maxR=Math.max(max,maxR);
        }
        InputStream io;
        return maxR;

    }

    public int largestRectangleArea(int[] heights) {
        int maxArea=0;
        Deque<Integer> l_stack=new ArrayDeque<>();
        int n= heights.length;
        int[] tmp=new int[n+1];
        for(int i=0;i<n;i++){
            tmp[i]=heights[i];
        }
        heights=tmp;
        n= heights.length;
        int[] left=new int[n];

        l_stack.push(-1);

        for(int i=0;i<n;i++){
            int h=heights[i];
            while (l_stack.size()>1 && heights[l_stack.peek()]>=h){
                int pop=l_stack.pop();
                int area=heights[pop]*(i- left[pop] -1 );
                maxArea=Math.max(area,maxArea);
            }
            left[i]=l_stack.peek();
            l_stack.push(i);
        }

        return maxArea;

    }

}