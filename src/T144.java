import java.util.ArrayList;
import java.util.List;

public class T144 {
    public static void main(String[] args){
        Solution144 solution=new Solution144();

        System.out.println(solution);

    }
}

class Solution144 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        preDfs(root,ans);
        return ans;
    }

    private void preDfs(TreeNode root,List<Integer> ans){
        if(root==null){
            return;
        }
        ans.add(root.val);
        preDfs(root.left, ans);
        preDfs(root.right, ans);
    }
}