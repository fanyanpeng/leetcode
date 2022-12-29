import sun.reflect.generics.tree.Tree;

public class T108 {
    public static void main(String[] args){
        Solution108 solution=new Solution108();

        System.out.println(solution);

    }
}

class Solution108 {
    private int[] nums;
    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums=nums;
        return makeTree(0,nums.length-1);
    }

    private TreeNode makeTree(int left,int right){
        if(left>right){
            return null;
        }
        int mid = (left+right)/2;
        TreeNode m = new TreeNode(nums[mid]);
        m.left = makeTree(left,mid-1);
        m.right= makeTree(mid+1,right);
        return m;
    }

}