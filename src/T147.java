

public class T147 {
    public static void main(String[] args){
        Solution147 solution=new Solution147();

        System.out.println(solution);

    }
}


class Solution147 {

    // 4 2 1 3
    // -10,4
    // -10,

    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(-100000);
        ListNode cur = head;
        while (cur!=null){
            ListNode next = cur.next;
            // do insert cur into dummy
            ListNode i = dummy;
            while (i!=null){
                if(i.next == null){ // next is null, add to the end
                    i.next=cur;
                    cur.next=null;
                    break;
                }
                else {
                    //next is not null, the cursor val must be smaller than
                    // the next one, so that the node
                    // could be put in the middle
                    if(cur.val<i.next.val){
                        cur.next = i.next;
                        i.next = cur;
                        break;
                    }
                    else{
                        i=i.next;
                    }
                }
            }
            //
            cur = next;
        }
        return dummy.next;

    }

}




