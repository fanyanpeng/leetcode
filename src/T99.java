import java.util.ArrayList;
import java.util.List;

public class T99 {
    public static void main(String[] args){
        Solution99 solution=new Solution99();
        TreeNode n1=new TreeNode(-33);
        TreeNode n2=new TreeNode(231);
        TreeNode n3=new TreeNode(399);

        TreeNode t1=new TreeNode(321,n1,null);
        TreeNode t2=new TreeNode(55,t1,null);
        TreeNode t3=new TreeNode(71,t2,null);

        TreeNode r1=new TreeNode(-13,n2,n3);
        TreeNode t4=new TreeNode(146,t3,r1);
        solution.recoverTree1(t4);

    }
}

class Solution99 {


    /**
     * 1ms
     * @author   fanyanpeng
     * @date 2022/10/26 2:14
     * @param null
     * @return
     */
    TreeNode left = null;
    TreeNode right = null;
    TreeNode last = null;

    public void recoverTree1(TreeNode root) {

        inOrderL(root);
        inOrderR(root);
        int temp = left.val;
        left.val=right.val;
        right.val=temp;
    }


    void  inOrderL(TreeNode node){
        if(node==null){
            return ;
        }
        inOrderL(node.left);
        if(last!=null){
            if(last.val> node.val && left==null){
                left=last;
                last=null;
                return;
            }
        }
        last=node;
        inOrderL(node.right);
    }

    void  inOrderR(TreeNode node){
        if(node==null){
            return ;
        }
        inOrderR(node.right);

        if(last!=null){
            if(last.val < node.val && right==null){
                right=last;
                last=null;
                return;
            }
        }
        last=node;
        inOrderR(node.left);
    }




    /**
     * 中序遍历，将所有node取出来，然后交换左边第一个比右边大的，交换右边第一个比左边小的值。
     * @author   fanyanpeng
     * @date 2022/10/26 1:15
     * @return
     */
    public void recoverTree(TreeNode root) {
        List<TreeNode> list=new ArrayList<>();
        inOrder(root,list);
        int left=0;int right=0;
        TreeNode[] nodes=list.toArray(new TreeNode[0]);
        for(left=0;left<nodes.length-1;left++){
            if(nodes[left].val>nodes[left+1].val){
                break;
            }
        }

        for(right= nodes.length - 1 ;right>1;right--){
            if(nodes[right].val < nodes[right-1].val){
                break;
            }
        }

        int temp = nodes[left].val;
        nodes[left].val=nodes[right].val;
        nodes[right].val=temp;
    }


    void  inOrder(TreeNode node,List<TreeNode> list){
        if(node==null){
            return ;
        }
        inOrder(node.left,list);
        list.add(node);
        inOrder(node.right,list);
    }

}