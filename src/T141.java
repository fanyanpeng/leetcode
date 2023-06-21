import java.util.HashSet;

public class T141 {
    public static void main(String[] args){
        Solution141 solution=new Solution141();

        System.out.println(solution);

    }
}

// 141. 环形链表
class Solution141 {


    //常数内存空间
    // 快慢指针，每走一步，间隔多一步，若最终走到同一个地方，有环
    // 更加普通的想法
    public boolean hasCycle_2(ListNode head) {
        ListNode one = head;
        ListNode two = head;

        while (two!=null){
            one=one.next;
            two=two.next;
            if(two==null){
                return false;
            }
            two=two.next;
            if(one == two){
                return true;
            }
        }
        return false;
    }

    //常数内存空间
    // 快慢指针，每走一步，间隔多一步，若最终走到同一个地方，有环
    public boolean hasCycle_1(ListNode head) {
        ListNode one = head;
        ListNode two = head;

        int timeCount = 0;
        while (true){
            if(one==null||two==null){
                return false;
            }
            if(timeCount++ %2 == 0){
                one=one.next;
                two=two.next;
            }
            else {
                two=two.next;
                if(one == two){
                    return true;
                }
            }
        }
    }


    // O(n)存储
    public boolean hasCycle(ListNode head) {

        HashSet<ListNode> visited = new HashSet<>();
        while (head!=null){
            if(visited.contains(head)){
                return true;
            }
            visited.add(head);
            head=head.next;
        }
        return false;
    }

}