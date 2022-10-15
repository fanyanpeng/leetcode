import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class t56 {
    public static void main(String[] args){
        Solution56 solution=new Solution56();
        int[][] a=new int[][]{{11,13},{2,8},{8,10},{15,18}};
        int[][] b=new int[][]{{0,2},{1,4},{3,5}};
        for(int[] is:solution.merge(b)){
            System.out.println( Arrays.toString(is) );
        }
    }
}

class Solution56 {

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





//    public int[][] merge(int[][] intervals) {
//        while (true){
//            int last_len=intervals.length;
//            intervals=merge_once(intervals);
//            int cur_len=intervals.length;
//            if(last_len==cur_len)break;
//        }
//        return intervals;
//    }
//
//    public int[][]  merge_once(int[][] intervals) {
//        List<Integer[]> ans=new ArrayList<>();
//        for (int[] ints : intervals) {
//            boolean found=false;
//            for (Integer[] in_list : ans) {
//                if (ints[0] >= in_list[0] && ints[0] <= in_list[1]) {
//                    in_list[1] = Math.max(in_list[1], ints[1]);
//                    found=true;
//                    break;
//                }
//                if (ints[1] >= in_list[0] && ints[1] <= in_list[1]) {
//                    in_list[0] = Math.min(in_list[0], ints[0]);
//                    found=true;
//                    break;
//                }
//                if (ints[1] >= in_list[1] && ints[0] <= in_list[0]) {
//                    in_list[0] =ints[0];
//                    in_list[1] =ints[1];
//                    found=true;
//                    break;
//                }
//            }
//            if(!found)ans.add(new Integer[]{ints[0], ints[1]});
//        }
//        int[][] ans_array=new int[ans.size()][2];
//        for(int i=0;i< ans.size();i++){
//            ans_array[i][0]=ans.get(i)[0];
//            ans_array[i][1]=ans.get(i)[1];
//        }
//        return ans_array;
//    }

}