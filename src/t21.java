
public class t21 {
    public static void main(String[] args){
        Solution21 solution=new Solution21();
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
        ListNode ans= solution.mergeTwoLists(null,l3);
        while (ans!=null){
            System.out.println(ans.val);
            ans=ans.next;
        }
    }
}

class Solution21{
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy=new ListNode(-1);
        ListNode ptr=dummy;
        if(list1==null)return list2;
        if(list2==null)return list1;

        while (list1!=null&&list2!=null){
            if(list1.val<list2.val){
                ptr.next=list1;
                list1=list1.next;
            }
            else {
                ptr.next=list2;
                list2=list2.next;
            }
            ptr=ptr.next;
        }
        ptr.next=list1!=null?list1:list2;
        return dummy.next;
    }
}