public class T117 {
    public static void main(String[] args){
        Solution117 solution=new Solution117();

        System.out.println(solution);

    }
}

class Solution117 {
    public Node connect(Node root) {
        if(root==null){
            return null;
        }
        if(root.left!=null){
            root.left.next=root.right;
        }
        Node rightedtSon = findRightestSon(root);
        if(rightedtSon!=null){
            System.out.println(rightedtSon.val);
            Node next = findNext(root);
            rightedtSon.next = next;

            System.out.println(""+rightedtSon.val+" next= "+((next==null)?"null":next.val));
        }
        // 必须先右边，循环找子节点的时候，需要先确定右边的情况
        connect(root.right);
        connect(root.left);

        return root;
    }


    public Node findRightestSon(Node root){
        if(root.right!=null){
            return root.right;
        }
        if(root.left!=null){
            return root.left;
        }
        return null;
    }


    public Node findNext(Node root) {
        root=root.next;
        while (root!=null){

            if(root.left!=null){
                return root.left;
            }
            if(root.right!=null){
                return root.right;
            }
            System.out.println("root切换至下一个:"+root.val);
            root=root.next;
        }
        return null;

    }

}