//import java.util.*;
//
//class Node {
//    public int val;
//    public List<Node> neighbors;
//    public Node() {
//        val = 0;
//        neighbors = new ArrayList<Node>();
//    }
//    public Node(int _val) {
//        val = _val;
//        neighbors = new ArrayList<Node>();
//    }
//    public Node(int _val, ArrayList<Node> _neighbors) {
//        val = _val;
//        neighbors = _neighbors;
//    }
//}
//
//public class T133 {
//    public static void main(String[] args){
//        Solution133 solution=new Solution133();
//        Node node1 = new Node(1);
//        Node node2 = new Node(2);
//        Node node3 = new Node(3);
//        Node node4 = new Node(4);
//
//        node1.neighbors = Arrays.asList(node2,node4);
//        node2.neighbors = Arrays.asList(node1,node3);
//        node3.neighbors = Arrays.asList(node2,node4);
//        node4.neighbors = Arrays.asList(node1,node3);
//
//        Node node =solution.cloneGraphBFS(node1);
//        System.out.println('1');
//
//    }
//}
//
//class Solution133 {
//
//    // 如何克隆一个图？
//    // 克隆节点和所有连接关系
//    // 广度优先遍历
//    // 每次clone一个节点，返回克隆后的节点，或者从已经构造好的节点表中取出。
//    // 若输入是null，返回null，若输入不是null，确定当前值是否被访问过，若没有访问过，就新建节点，然后以此克隆邻居节点，最后返回当前节点。
//    // 需要一个数组，按照节点值索引节点。
//    // 终止条件是：都构造完成了,dfs
//    Node[] nodesList= new Node[101];
//    public Node cloneGraph(Node node) {
//        if (node==null){
//            return null;
//        }
//        int val = node.val;
//        if(nodesList[val]!=null){
//            return nodesList[val];
//        }
//        if(nodesList[val]==null){
//            Node newNode=new Node(val);
//            nodesList[val]=newNode;
//            for(Node neighbour:node.neighbors){
//                newNode.neighbors.add(cloneGraph(neighbour));
//            }
//        }
//        return nodesList[val];
//    }
//
//
//
//
//    Node[] nodesListBFS= new Node[101];
//    boolean[] visited = new boolean[101];
//    public Node cloneGraphBFS(Node node) {
//        if (node==null){
//            return null;
//        }
//        Deque<Node> deque=new ArrayDeque<>();
//        deque.addLast(node);
//        int val = node.val;
//        nodesListBFS[val]= new Node(val);
//        while (!deque.isEmpty()){
//            Node originalNode=deque.pollFirst();
//            val = originalNode.val;
//            if(visited[val]) {
//                continue;
//            }
//            visited[val] = true;
//            for(Node n: originalNode.neighbors) {
//                Node neighbour;
//
//                if(nodesListBFS[n.val]!=null){
//                    neighbour = nodesListBFS[n.val];
//                }else {
//                    neighbour = new Node(n.val);
//                    nodesListBFS[n.val] = neighbour;
//                    deque.addLast(n);
//                }
//
//                nodesListBFS[val].neighbors.add(neighbour);
//            }
//        }
//
//
//        return nodesListBFS[1];
//    }
//
//}