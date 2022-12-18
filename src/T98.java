import java.util.ArrayList;

public class T98 {
    public static void main(String[] args){
        Solution98 solution=new Solution98();

        System.out.println(solution);

    }
}

class Solution98 {






    /**
     * 思路2：中序遍历，然后遍历一遍结果，若出现前面>=后面大的情况，返回false，否则成功。
     * 1ms
     * @author   fanyanpeng
     * @date 2022/10/26 0:33
     * @param root
     * @return boolean
     */
    public boolean isValidBST2(TreeNode root) {
        ArrayList<Integer> list=new ArrayList<>();
        inOrder(root,list);
        Integer[] array = list.toArray(new Integer[0]);
        for(int i=0;i<array.length-1;i++){
            if(array[i]>=array[i+1]){
                return false;
            }
        }
        return true;

    }
    void inOrder(TreeNode node, ArrayList<Integer> list){
        if(node==null){
            return;
        }
        inOrder(node.left,list);
        list.add(node.val);
        inOrder(node.right,list);
    }









    /**
     * 一棵树是二叉搜索树，当且仅当：左右子树都是二叉搜索树，且左子树的最大值小于当前值，且右子树的最小值大于当前值。当前位置的最大值、最小值是右子树的最大值和左子树的最小值。
     * 当没有子节点时，返回true，min=本身，max=本身。
     * 0ms
     * @author   fanyanpeng
     * @date 2022/10/26 0:33
     * @param root
     * @return boolean
     */
    public boolean isValidBST(TreeNode root) {
        return dfs(root).isBST;

    }


    State dfs(TreeNode node){
        if(node==null){
            return null;
        }
        if(node.left==null && node.right==null){
            return new State(node.val,node.val,true);
        }

        State left = dfs(node.left);
        State right =dfs(node.right);

        if(left!=null && !left.isBST ||right!=null && !right.isBST){
            return new State(0,0,false);
        }

        if(left!=null&&left.max>=node.val ||right!=null && right.min<=node.val){    //注意此处，去等时就应该判为非BST
            return new State(0,0,false);
        }

        int min = left!=null? left.min : node.val;
        int max = right!=null? right.max : node.val;

        return new State(min,max,true);

    }
    class State{
        int min;
        int max;
        boolean isBST;
        State(int min,int max,boolean isBST){
            this.isBST=isBST;
            this.min=min;
            this.max=max;
        }
    }
}