

public class T124 {
    public static void main(String[] args){
        Solution124 solution=new Solution124();

        System.out.println(solution);

    }
}

class Solution124 {
    int maxConnectValue=-10000;
    public int maxPathSum(TreeNode root) {
        singlePathSum(root);
        return maxConnectValue;
    }

    private int singlePathSum(TreeNode root){
        if(root==null){
            return -1;
        }
        int leftMax = singlePathSum(root.left);
        int rightMax = singlePathSum(root.right);
        int chosen = Math.max(leftMax,rightMax);
        if(chosen<=0){
            chosen = 0;//从此中断
        }
        int currentValue = root.val+chosen;

        int connectValue = root.val;
        if(leftMax>0){
            connectValue+=leftMax;
        }
        if(rightMax>0){
            connectValue+=rightMax;
        }
        maxConnectValue = Math.max(maxConnectValue,connectValue);
        return currentValue;
    }

}