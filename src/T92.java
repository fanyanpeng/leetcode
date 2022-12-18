import java.util.List;

public class T92 {
    public static void main(String[] args){
        Solution92 solution=new Solution92();

        System.out.println(solution);

    }
}

class Solution92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy=new ListNode(0,head);
        ListNode leftOut =new ListNode(0);
        ListNode leftIn=new ListNode(0);
        ListNode lastOne=new ListNode(0);

        ListNode cursor = dummy;
        int index = 0;
        while (cursor!=null){
            ListNode currentNode = cursor;
            cursor=cursor.next;
            if(index == left-1){
                leftOut = currentNode;
            }
            if(index == left){
                leftIn=currentNode;
            }
            if(index == right){
                leftOut.next = currentNode;
                leftIn.next = currentNode.next;
            }
            //需要放在最后处理。
            if(index<=right && index>left){
                currentNode.next=lastOne;
            }
            index++;
            lastOne = currentNode;
        }
        return dummy.next;
    }

}