import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class T113 {
    public static void main(String[] args){
        Solution113 solution=new Solution113();

        System.out.println(solution);

    }
}

class Solution113 {

    int sum=0;
    Deque<Integer> path = new ArrayDeque<>();
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root==null){
            return ans;
        }
        sum += root.val;;
        path.addLast(root.val);
        if(root.left==null &&root.right==null){
            if(sum==targetSum){
                saveAns();
            }
        }
        TreeNode[] nodes=new TreeNode[]{root.left,root.right};
        for(TreeNode node :nodes){
            if(node!=null){
                pathSum(node,targetSum);
            }
        }

        sum-= root.val;;
        path.pollLast();
        return ans;
    }

    private void saveAns() {
        List<Integer> pathList = new ArrayList<>();
        while (!path.isEmpty()){
            pathList.add(path.pollFirst());
        }
        for(Integer i:pathList){
            path.addLast(i);
        }
        ans.add(pathList);
    }
}