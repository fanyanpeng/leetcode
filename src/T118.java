import java.util.ArrayList;
import java.util.List;

public class T118 {
    public static void main(String[] args){
        Solution118 solution=new Solution118();

        System.out.println(solution);

    }
}

class Solution118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        ans.add(firstRow);
        for(int i=1;i<numRows;i++){
            List<Integer> lastRow=ans.get(i-1);
            List<Integer> thisRow=new ArrayList<>();
            thisRow.add(1);
            for(int j=0;j<lastRow.size()-1;j++){
                thisRow.add(lastRow.get(j)+lastRow.get(j+1));
            }
            thisRow.add(1);
            ans.add(thisRow);
        }
        return ans;
    }
}