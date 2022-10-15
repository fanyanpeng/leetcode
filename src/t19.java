import java.awt.*;
import java.security.Timestamp;
import java.sql.Time;
import java.util.Calendar;
import java.util.Timer;

public class t19 {
    public static void main(String[] args){
        Solution19 solution=new Solution19();
//        System.out.println(solution);
        ListNode l1=new ListNode(2);
        ListNode l2=new ListNode(6);
        ListNode l3=new ListNode(9);
        l1.next=l2;
        l2.next=l3;
        ListNode l4=new ListNode(9);
        ListNode l5=new ListNode(12);
        ListNode l6=new ListNode(77);
        l4.next=l5;
        l5.next=l6;
        ListNode ans= solution.removeNthFromEnd(l3,1);
        while (ans!=null){
            System.out.println(ans.val);
            ans=ans.next;
        }

    }





}

class Solution19{
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy_node=new ListNode(-1,head);
        ListNode r_ptr=dummy_node;
        ListNode l_ptr=dummy_node;
        for(int i=0;i<n;i++){
            r_ptr= r_ptr.next;
        }
        while (r_ptr.next!=null){
            r_ptr=r_ptr.next;
            l_ptr=l_ptr.next;
        }
        l_ptr.next=l_ptr.next.next;
        return dummy_node.next;
    }
}