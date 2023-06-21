import java.util.HashMap;
import java.util.Map;

public class T138 {
    public static void main(String[] args){
        Solution138 solution=new Solution138();

        Solution138.Node node1 = new Solution138.Node(7);
        Solution138.Node node2 = new Solution138.Node(13);
        Solution138.Node node3 = new Solution138.Node(11);
        Solution138.Node node4 = new Solution138.Node(10);
        Solution138.Node node5 = new Solution138.Node(1);

        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;


        node2.random=node1;
        node3.random=node5;
        node4.random=node2;
        node5.random = node1;

        Solution138.Node node = solution.copyRandomList(node1);

        while (node!=null){
            System.out.println(node.toString());
            node=node.next;
        }

    }
}

class Solution138 {
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {

        Map<Node,Node> copyMap = new HashMap<>();

        Node node = head;
        while (node!=null){
            copyMap.put(node,new Node(node.val));
            node=node.next;
        }

        node = head;
        while (node!=null){
            Node copiedNode = copyMap.get(node);
            copiedNode.next = copyMap.get(node.next);
            copiedNode.random = copyMap.getOrDefault(node.random,null);
            node=node.next;
        }

        return copyMap.get(head);

    }

}