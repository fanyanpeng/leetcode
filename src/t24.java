public class t24 {
    public static void main(String[] args){
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
        Solution24 solution=new Solution24();
        ListNode ans= solution.swapPairs(l1);
        while (ans!=null){
            System.out.println(ans.val);
            ans=ans.next;
        }
    }
}

class Solution24{
    public ListNode swapPairs(ListNode head) {
        ListNode dummy=new ListNode(-1,head);
        ListNode ptr=dummy;
        while (true){
            ListNode l1=ptr.next;
            if(l1==null)break;
            ListNode l2=l1.next;
            if(l2==null)break;
            //exchange l1 and l2
            l1.next=l2.next;
            l2.next=l1;
            ptr.next=l2;

            //new head
            ptr=l1;
        }
        return dummy.next;
    }
}