import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class T107 {
    public static void main(String[] args){
        Solution107 solution=new Solution107();

        System.out.println(solution);

    }
}

class Solution107 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        Deque<List<Integer>> stack =new ArrayDeque<>();
        List<List<Integer>> ans =new ArrayList<>();
        List<TreeNode> cur = new ArrayList<>();
        if(root!=null){
            cur.add(root);
        }


        while (cur.size()!=0){
            List<Integer> row=new ArrayList<>();
            List<TreeNode> next=new ArrayList<>();
            for(TreeNode node:cur){
                row.add(node.val);
                if(node.left!=null){
                    next.add(node.left);
                }
                if(node.right!=null){
                    next.add(node.right);
                }
            }

            stack.push(row);
            cur=next;
        }

        while (!stack.isEmpty()){
            ans.add(stack.pop());
        }
        return ans;
    }

}