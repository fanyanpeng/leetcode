public class T104 {
    public static void main(String[] args){
        Solution104 solution=new Solution104();

        System.out.println(solution);

    }
}

class Solution104 {

    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
}