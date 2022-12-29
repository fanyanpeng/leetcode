import java.util.ArrayList;
import java.util.List;

public class T119 {
    public static void main(String[] args){
        Solution119 solution=new Solution119();

        System.out.println(solution);

    }
}

class Solution119 {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans=new ArrayList<>();
        if(rowIndex==0){
            ans.add(1);
            return ans;
        }
        List<Integer> lastRow=getRow(rowIndex-1);
        ans.add(1);
        for(int i=0;i<lastRow.size()-1;i++){
            ans.add(lastRow.get(i)+lastRow.get(i+1));
        }
        ans.add(1);
        return ans;
    }
}