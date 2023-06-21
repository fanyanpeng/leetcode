import java.util.*;

public class T145 {
    public static void main(String[] args){
        Solution145 solution=new Solution145();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        System.out.println(solution.postorderTraversal_1(root));

    }
}

class Solution145 {




    // 迭代实现
    public List<Integer> postorderTraversal_1(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        List<Integer> ans=new ArrayList<>();
        HashSet<TreeNode> visited = new HashSet<>();
        if(root!=null){
            deque.addLast(root);
        }
        while (!deque.isEmpty()){
            TreeNode node = deque.peekLast();
            if(visited.contains(node)){
                ans.add(node.val);
                visited.add(node);
                deque.pollLast();
            }else {
                visited.add(node);
                if(node.right!=null){
                    deque.addLast(node.right);
                }
                if(node.left!=null){
                    deque.addLast(node.left);
                }
            }
        }
        return ans;
    }
    
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        postDfs(root,ans);
        return ans;
    }

    private void postDfs(TreeNode root,List<Integer> ans){
        if(root==null){
            return;
        }
        postDfs(root.left, ans);
        postDfs(root.right, ans);
        ans.add(root.val);

    }

}