public class T110 {
    public static void main(String[] args) {
        Solution110 solution = new Solution110();

        System.out.println(solution);

    }
}

class Solution110 {

    public boolean isBalanced(TreeNode root) {
        return isAVL(root).isAVL;
    }

    public AVL isAVL(TreeNode node) {
        if (node == null) {
            return new AVL(true, 0);
        }

        AVL l = isAVL(node.left);
        AVL r = isAVL(node.right);
        if(!l.isAVL||!r.isAVL){
            return new AVL(false,0);
        }

        boolean isAVL = l.isAVL
                && r.isAVL
                && Math.abs(l.height - r.height) <= 1;
        int height = Math.max(l.height, r.height) + 1;

        return new AVL(isAVL,height);
    }
    class AVL {
        boolean isAVL;
        int height;

        AVL(boolean isAVL, int height) {
            this.isAVL = isAVL;
            this.height = height;
        }
    }
}