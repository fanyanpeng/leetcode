import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T120 {
    public static void main(String[] args){
        Solution120 solution=new Solution120();

        System.out.println(solution);

    }
}

class Solution120 {
    public int minimumTotal1(List<List<Integer>> triangle) {
        int[] min = new int[triangle.size()];
        for(int i=0;i<triangle.size();i++){
            List<Integer> rawList=triangle.get(i);
            adjustMin(min,i);
            for(int j=0;j<rawList.size();j++){
                min[j]+= rawList.get(j);
            }
        }
        return Arrays.stream(min).min().getAsInt();
    }

    // i = 1, 第二行，需要构造到2个元素
    private void adjustMin(int[] min, int i) {
        if(i==0){
            return;
        }
        min[i]=min[i-1];
        for(int j=i-1;j>0;j--){
            min[j]=Math.min(min[j],min[j-1]);
        }
    }


    public int minimumTotal(List<List<Integer>> triangle) {
        int min=Integer.MAX_VALUE;
        for(int value: getRow(triangle.size()-1,triangle)){
            if(value<min){
                min=value;
            }
        }
        return min;

    }

    List<Integer> getRow(int n,List<List<Integer>> triangle){
        List<Integer> rawRow=triangle.get(n);
        if(n==0){
            return rawRow;
        }
        List<Integer> lastRow=getRow(n-1,triangle);
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<rawRow.size();i++){
            int toAdd=0;
            if(i==0){
                toAdd = lastRow.get(i);
            }
            else if(i==rawRow.size()-1){
                toAdd = lastRow.get(i-1);
            }
            else {
                toAdd = Math.min(lastRow.get(i),lastRow.get(i-1));
            }
            ans.add(rawRow.get(i)+toAdd);
        }
        return ans;
    }

}