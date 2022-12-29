import sun.reflect.generics.tree.Tree;

public class T111 {
    public static void main(String[] args){
        Solution111 solution=new Solution111();

        System.out.println(solution);

    }
}

class Solution111 {

    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        if(root.right==null&&root.left==null){
            return 1;
        }
        int l = minDepth(root.left);
        int r = minDepth(root.right);
        return Math.min(l==0?Integer.MAX_VALUE:l,r==0?Integer.MAX_VALUE:r)+1;
    }

}