import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class T105 {
    public static void main(String[] args){
        Solution105 solution=new Solution105();

        System.out.println(solution);

    }
}

class Solution105 {

    int [] preorder;
    int[] inorder;
    int pos;

    public TreeNode buildTree_1(int[] preorder, int[] inorder) {
        pos = 0;
        this.preorder = preorder;
        this.inorder = inorder;
        return buildTree_1(0,inorder.length-1);
    }

    public TreeNode buildTree_1(int from,int to){
        if(from>to){
            return null;
        }
        int val = preorder[pos++];
        int mid = 0;
        for(int i=from;i<=to;i++){
            if(this.inorder[i]==val){
                mid = i;
                break;
            }
        }
        TreeNode cur=new TreeNode(val);
        cur.left = buildTree_1(from,mid-1);
        cur.right = buildTree_1(mid+1,to);
        return cur;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        pos = 0;
        this.preorder = preorder;
        return buildTree(Arrays.stream(inorder).boxed().collect(Collectors.toList()));
    }

    public TreeNode buildTree(List<Integer> nodes){
        if(nodes.size()==0){
            return null;
        }
        TreeNode curNode = new TreeNode(preorder[pos++]);
        int value = curNode.val;
        List<List<Integer>> l = split(nodes,value);
        curNode.left = buildTree(l.get(0));
        curNode.right = buildTree(l.get(1));
        return curNode;
    }

    private List<List<Integer>> split(List<Integer> nodes, int mid){
        List<Integer> l = new ArrayList<>();
        List<Integer> r= new ArrayList<>();
        List<Integer> cur = l;
        for( int i:nodes){
            if(i==mid){
                cur=r;
                continue;
            }
            cur.add(i);
        }
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(l);
        ans.add(r);
        return ans;
    }

}