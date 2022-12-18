public class T86 {
    public static void main(String[] args){
        Solution86 solution=new Solution86();

        System.out.println(solution);

    }
}

class Solution86 {

    /**
     * 思路：新建节点，便利两边插入。
     * @author   fanyanpeng
     * @date 2022/10/15 17:12
     * @param head
     * @param x
     * @return ListNode
     */
    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(-1);
        ListNode ansPtr = dummy;


        ListNode ptr = head;
        while (ptr!=null){
            if(ptr.val<x){
                ansPtr.next=new ListNode(ptr.val);
                ansPtr=ansPtr.next;
            }
            ptr=ptr.next;
        }

        ptr = head;
        while (ptr!=null){
            if(ptr.val>=x){
                ansPtr.next=new ListNode(ptr.val);
                ansPtr=ansPtr.next;
            }
            ptr=ptr.next;
        }
        return dummy.next;

    }

}