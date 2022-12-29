public class T112 {
    public static void main(String[] args){
        Solution112 solution=new Solution112();

        System.out.println(solution);

    }
}

class Solution112 {

    int sum = 0;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null){
            return false;
        }
        sum+=root.val;
        if(root.left==null && root.right==null){
            if(targetSum == sum){
                return true;
            }
        }
        TreeNode[] nodes = new TreeNode[]{root.left,root.right};
        for(TreeNode node :nodes){
            if(node!=null){
                if(hasPathSum(node, targetSum)){
                    return true;
                }
            }
        }
        sum-= root.val;
        return false;
    }
}