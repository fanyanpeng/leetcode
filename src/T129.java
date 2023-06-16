import java.util.ArrayList;
import java.util.List;

public class T129 {
    public static void main(String[] args){
        Solution129 solution=new Solution129();

        System.out.println(solution);

    }
}

class Solution129 {

    int sum=0;
    void dfs(TreeNode root, int value, List<Integer> nums){
        value+=root.val;
        if(root.left==null && root.right==null){
//            nums.add(value);
            sum+=value;
            return;
        }
        if(root.left!=null){
            dfs(root.left,value*10,nums);
        }
        if(root.right!=null){
            dfs(root.right,value*10,nums);
        }

    }

    public int sumNumbers(TreeNode root) {
        List<Integer> nums = new ArrayList<>();

        dfs(root,0,nums);

//        return nums.stream().reduce((accumulator,currentValue)->accumulator+currentValue).get();

        return sum;
    }

}