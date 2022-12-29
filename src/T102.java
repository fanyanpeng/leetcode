import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class T102 {
    public static void main(String[] args){
        Solution102 solution=new Solution102();

        System.out.println(solution);

    }
}

class Solution102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        List<TreeNode> curLevel = new ArrayList<>();

        if(root!=null){
            curLevel.add(root);
        }


        while (curLevel.size()!=0){
            List<TreeNode> nextLevel = new ArrayList<>();
            List<Integer> iteration = new ArrayList<>();
            for( TreeNode node : curLevel){
                iteration.add(node.val);
                if(node.left!=null){
                    nextLevel.add(node.left);
                }
                if(node.right!=null){
                    nextLevel.add(node.right);
                }
            }
            ans.add(iteration);
           curLevel=nextLevel;
        }
        return ans;
    }

}