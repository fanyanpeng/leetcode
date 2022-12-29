import java.util.HashMap;

public class T106 {
    public static void main(String[] args){
        Solution106 solution=new Solution106();

        System.out.println(solution);

    }
}

class Solution106 {
    int [] postorder;
    int[] inorder;
    int pos;

    HashMap<Integer,Integer> indexMap=new HashMap<>();



    public void buildMap(){
        for(int i=0;i<inorder.length;i++){
            indexMap.put(inorder[i],i);
        }
    }

    public TreeNode buildTree_1(int[] inorder, int[] postorder) {

        this.postorder = postorder;
        pos = this.postorder.length-1;
        this.inorder = inorder;
        buildMap();
        return buildTree_1(0,inorder.length-1);
    }

    public TreeNode buildTree_1(int from,int to){
        if(from>to){
            return null;
        }
        int val = postorder[pos--];
        int mid = indexMap.get(val);
        TreeNode cur=new TreeNode(val);
        cur.right = buildTree_1(mid+1,to);
        cur.left = buildTree_1(from,mid-1);
        return cur;
    }

}