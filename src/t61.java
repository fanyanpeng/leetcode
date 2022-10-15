public class t61 {
    public static void main(String[] args){
        Solution61 solution=new Solution61();
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(2);
        ListNode l3=new ListNode(3);
        l1.next=l2;
        l2.next=l3;
        ListNode l4=new ListNode(4);
        ListNode l5=new ListNode(5);
        ListNode l6=new ListNode(6);
        l3.next=l4;
        l4.next=l5;
        //l5.next=l6;
        ListNode ans= solution.rotateRight(l1,2);
        while (ans!=null){
            System.out.println(ans.val);
            ans=ans.next;
        }


    }
}

class Solution61 {
    //1,2
    //2,1
    public ListNode rotateRight(ListNode head, int k) {
        int len=len(head);
        if(len<=1||k%len==0)return head;
        k--;
        ListNode dummy=new ListNode(0,head);
        ListNode node_right=get_node(dummy,reverse(len,k+1));
        ListNode node_left=get_node(dummy,reverse(len,k));
        ListNode node_end=get_node(dummy,len-1);
        //first make it a circle
        node_end.next=head;
        //then find the the end spot and make it end.
        node_right.next=null;
        return node_left;
    }
    //1,2,3,4,5
    //0,4.

    //1,2
    //0,1
    //1,0
    int reverse(int len,int back_pos){
       return len-1-(back_pos%len);
    }

    int len(ListNode head){
        int count=0;
        while (head!=null){
            count++;
            head=head.next;
        }
        return count;
    }
    ListNode get_node(ListNode dummy,int index){
        ListNode p=dummy.next;
        for(int i=0;i<index;i++){
            p=p.next;
        }
        return p;
    }

}