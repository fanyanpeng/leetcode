public class T116 {
    public static void main(String[] args){
        Solution116 solution=new Solution116();

        System.out.println(solution);

    }
}
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
class Solution116 {
    //想法，逐层遍历（从右往左，遍历后得到一个列表，立马对列表中数据进行逐个赋值，即将next（初始化为null）赋值给当前元素，然后将当前元素置为next；
    // 以上思想不满足进阶要求，since只能使用常量空间
    // ！其实可以加强复杂度为logN，所有的树都自取，都编号完成了。
    // 1；2；4；8；16；取一个数最多需要12下，遍历一遍消耗时间N*Log N，无额外空间消耗。
    // 仅仅针对完全二叉树。
    // 4:100; 5:101; 6: 110; 7:111;  从当前数字的第二位开始，为0，向左，为1，向右；
    // 2：10,3:11，
    public Node connect(Node root) {
        int level = 0;
        int start = 1;
        int end = 1;
        while (getNode(root,start)!=null){
            Node next = null;
            for(int i=end;i>=start;i--){
                Node curNode = getNode(root,i);
                curNode.next = next;
                next = curNode;
            }
            level++;
            start = 1<<level;
            end=(1<<(level+1)) - 1;
        }
        return root;

    }

    Node getNode(Node root,int n){
        String d = getBinary(n);
        for(int i=0;i<d.length();i++){
            if(d.charAt(i)=='0'){
                root=root.left;
            }else {
                root=root.right;
            }
        }
        return root;
    }

    String getBinary(int n){
        StringBuilder ans= new StringBuilder();
        while (n!=0){
            ans.append(n % 2);
            n=n/2;
        }
        return ans.reverse().substring(1);
    }

}