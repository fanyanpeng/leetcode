import java.util.ArrayList;
import java.util.List;

public class T89 {
    public static void main(String[] args){
        Solution89 solution=new Solution89();

        System.out.println(solution.grayCode(3).toString());

    }
}

class Solution89 {
    public List<Integer> grayCode(int n) {
        ArrayList<Integer> ans = new ArrayList<>(1>>n);
        ans.add(0);
        ans.add(1);

        for(int i=1;i<n;i++){
            int len=ans.size();
            for(int j=len-1;j>=0;j--){
                ans.add(ans.get(j)+(1<<i));
            }
        }
        return ans;
    }
}