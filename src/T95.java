import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T95 {
    public static void main(String[] args){
        Solution95 solution=new Solution95();
        Solution94 inorder=new Solution94();

        List<TreeNode> ans=solution.generateTrees(3);
        for(TreeNode treeNode:ans){
            List<Integer> order = inorder.inorderTraversal(treeNode);
            System.out.println(Arrays.toString(order.toArray()));
        }

    }
}

class Solution95 {

    /**
     * 通过组合获得结果的，将组合的过程放在递归过程中，而不要将组合的过程提取出来。
     * @author   fanyanpeng
     * @date 2022/10/23 3:11
     * @param n
     * @return List<TreeNode>
     */
    public List<TreeNode> generateTrees(int n) {
        return  binarySearchTree(1,n+1);
    }

    List<TreeNode> binarySearchTree(int left,int right){

        List<TreeNode> ans = new ArrayList<>();
        if(left==right){
            ans.add(null);
            return ans;
        }
        for(int i=left;i<right;i++){
            List<TreeNode> l_r=new ArrayList<>();
            List<TreeNode> lNode = binarySearchTree(left,i);
            List<TreeNode> rNode = binarySearchTree(i+1,right);
            for(TreeNode l:lNode){
                for(TreeNode r:rNode){
                    ans.add(new TreeNode(i,l,r));
                }
            }
        }
        return ans;

    }
}