import java.util.HashSet;

public class T142 {
    public static void main(String[] args){
        Solution142 solution=new Solution142();

        System.out.println(solution);

    }
}

class Solution142 {

    public ListNode detectCycle(ListNode head) {

        HashSet<ListNode> visited = new HashSet<>();
        ListNode cur = head;
        while (cur!=null){
            if(visited.contains(cur)){
                return cur;
            } else {
                visited.add(cur);
            }
            cur = cur.next;
        }
        return null;
    }

}