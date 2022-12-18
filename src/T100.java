public class T100 {
    public static void main(String[] args) {
        Solution100 solution = new Solution100();

        System.out.println(solution);

    }
}

class Solution100 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p != null && q != null) {
            return p.val == q.val
                    && isSameTree(p.left, q.left)
                    && isSameTree(p.right, q.right);
        }
        return false;
    }
}