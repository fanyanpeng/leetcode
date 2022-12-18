
import java.util.ArrayList;
import java.util.List;



class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


public class T94 {
    public static void main(String[] args){
        Solution94 solution=new Solution94();

        System.out.println();

    }
}

class Solution94 {

    List<Integer> ans = new ArrayList<>();


    public List<Integer> inorderTraversal(TreeNode root) {
        if(root==null){
            return ans;
        }
        inorder(root);
        return ans;
    }


    public void inorder(TreeNode root) {

        if(root.left!=null){
            inorderTraversal(root.left);
        }
        ans.add(root.val);
        if(root.right!=null){
            inorderTraversal(root.right);
        }
    }

}