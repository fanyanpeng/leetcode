import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

public class t25 {
    public static void main(String[] args){
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(2);
        ListNode l3=new ListNode(3);
        ListNode l4=new ListNode(4);
        ListNode l5=new ListNode(5);
        ListNode l6=new ListNode(6);
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        l4.next=l5;
        l5.next=l6;
        Solution25 solution=new Solution25();
        ListNode ans= solution.reverseKGroup(l1,2);
        while (ans!=null){
            System.out.println(ans.val);
            ans=ans.next;
        }

    }
}

class Solution25{
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode dummy_node=new ListNode(0,head);
        ListNode t1,t2,ptr,pre;
        ptr=dummy_node;
        while (ptr!=null){
            //get next node, could be node or null
            t1=ptr.next;
            for(int i=0;i<k;i++){
                if(t1==null)return dummy_node.next;
                t1=t1.next;
            }
            //here, t1=ptr.next, so after k steps,
            // t1 has been to the beginning of next k-queue
            pre=t1;
            t1=ptr.next;

            for(int i=0;i<k;i++){

                //when you reach the last node in the group
                //turn it to the first one
                //all sorting work have been already done
                if(i==k-1)ptr.next=t1;

                t2=t1.next; //get next node
                t1.next=pre;    //pre to follow
                pre=t1; //for next node t2, t1: before t2 -> t1 follow t2
                t1=t2;  //finished deal with t1

            }
            //ptr go k steps
            for(int i=0;i<k;i++){
                ptr=ptr.next;
            }
        }
        return dummy_node.next;







//        Stack<ListNode> stack=new Stack<>();
//        ListNode dummy=new ListNode(0,head);
//        ListNode ptr1,ptr2;
//        ptr1=dummy;
//        while (true){
//            ptr2=ptr1.next;
//            for(int i=0;i<k;i++){
//                if(ptr2==null)break;
//                stack.push(ptr2);
//                ptr2=ptr2.next;
//            }
//            if(stack.size()!=k)break;
//
//            ListNode t_end = null;
//            for(int i=0;i<k;i++){
//                ListNode t=stack.pop();
//                if(i==0){
//                    t_end=t.next;
//                }
//                ptr1.next=t;
//                ptr1=ptr1.next;
//            }
//            ptr1.next=t_end;
//        }
//        return dummy.next;
//
    }
}