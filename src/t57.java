import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class t57 {
    public static void main(String[] args){
        Solution57 solution=new Solution57();
        int[][] a=new int[][]{{11,13},{2,8},{8,10},{15,18}};
        int[][] b=new int[][]{{0,2},{1,4},{3,5}};
        for(int[] is:solution.insert(b,new int[]{1,4})){
            System.out.println( Arrays.toString(is) );
        }
        System.out.println(solution);

    }
}

class Solution57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] new_intervals=new int[intervals.length+1][2];
        System.arraycopy(intervals, 0, new_intervals, 0, intervals.length);
        new_intervals[intervals.length]=newInterval;
        return merge(new_intervals);
    }

    public int[][] merge(int[][] intervals) {
        List<int[]> list=new ArrayList<>();
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        int max=-1;
        int pos=-1;
        for(int[] ints : intervals){
            if(ints[0]>max){
                pos++;
                list.add(new int[]{ints[0],ints[1]});
            }
            if(ints[0]<=max){
                list.get(pos)[1]=Math.max(max,ints[1]);
            }
            max=list.get(pos)[1];
        }

        int [][] ans=new int[list.size()][2];
        for(int i=0;i< ans.length;i++){
            ans[i]= list.get(i);
        }
        return ans;

    }

}