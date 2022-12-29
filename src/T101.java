public class T101 {
    public static void main(String[] args){
        Solution101 solution=new Solution101();

        System.out.println(solution);

    }
}

class Solution101 {
    public boolean isSymmetric(TreeNode root) {
        return areSymmetric(root.left,root.right);

    }

    public boolean areSymmetric(TreeNode left,TreeNode right) {
        if(left==null && right==null){
            return true;
        }
        if(left!=null && right!=null){
            return left.val == right.val
                    && areSymmetric(left.left,right.right)
                    && areSymmetric(left.right,right.left);
        }
        return false;
    }

}