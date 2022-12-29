import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T103 {
    public static void main(String[] args){
        Solution103 solution=new Solution103();

        System.out.println(solution);

    }
}

class Solution103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        List<TreeNode> curLevel = new ArrayList<>();
        if(root!=null){
            curLevel .add(root);
        }
        int level = 0;
        while (curLevel.size()!=0){
            List<TreeNode> nextLevel = new ArrayList<>();
            List<Integer> iteration = new ArrayList<>();
            for(TreeNode node :curLevel){
                iteration.add(node.val);
                if(node.left!=null){
                    nextLevel.add(node.left);
                }
                if(node.right!=null){
                    nextLevel.add(node.right);
                }
            }
            ans.add(level%2 == 1 ? reverse(iteration):iteration);
            curLevel=nextLevel;
            level++;
        }

        return ans;
    }

    public List<Integer> reverse(List<Integer> list){
        List<Integer> ans=new ArrayList<>();
        Integer[] ori = list.toArray(new Integer[0]);
        for(int i=ori.length-1;i>=0;i--){
            ans.add(ori[i]);
        }
        return ans;
    }



}