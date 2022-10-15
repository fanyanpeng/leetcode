public class T83 {
    public static void main(String[] args){
        Solution83 solution=new Solution83();

        System.out.println(solution);

    }
}

class Solution83 {
    public ListNode deleteDuplicates(ListNode head) {

        ListNode dummy=new ListNode(-1000,head);
        ListNode ptr=dummy;
        int cur=ptr.val;
        while (ptr!=null&&ptr.next!=null){
            int val=ptr.next.val;
            if(val==cur){
                ptr.next=ptr.next.next;
            }
            //注意点：必须分情况
            else {
                cur=val;
                ptr=ptr.next;
            }
        }
        return dummy.next;
    }

}