public class T114 {
    public static void main(String[] args){
        Solution114 solution=new Solution114();

        System.out.println(solution);

    }
}

class Solution114 {
// 前序展开树，对于当前节点，先把右子树保留下来，然后去展开左子树，将左子树展开好了之后，将右子树赋值给展开后的右子树；
    //根据前序的定义，先本身，再左子树，所以左子树一定在右子树的上面。
    // 思路：返回值为子树最后一个，用于和右子树对接

    public void flatten(TreeNode root) {

        dealNode(root);
    }

    private void dealNode(TreeNode root){
        if(root==null){
            return;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        if(left!=null){
            dealNode(left);
            TreeNode end = getRightEnd(left);
            root.right = left;
            root.left=null;
            end.right = right;
        }
        if(right!=null){
            dealNode(right);
        }
    }
    private TreeNode getRightEnd(TreeNode root){
        while (root.right!=null){
            root=root.right;
        }
        return root;
    }

}