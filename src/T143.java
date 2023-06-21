

public class T143 {
    public static void main(String[] args){
        Solution143 solution=new Solution143();

        System.out.println(solution);

    }
}

// 143. 重排链表
class Solution143 {



    public void reorderList(ListNode head) {
        int n = count(head);
        ListNode[] nodeArray = new ListNode[n];
        ListNode cur = head;
        for(int i=0;i<n;i++){
            nodeArray[i]=cur;
            cur=cur.next;
        }

        int step = 1;
        int l=1;
        int r=n-1;

        cur = head;
        while (step<n){
            ListNode node;
            if(step%2 == 1){
                node=nodeArray[r--];
            }else {
                node=nodeArray[l++];
            }
            cur.next=node;
            cur=node;
            step++;
        }
        cur.next=null;
    }

    private int count(ListNode node){
        int count = 0;
        while (node!=null){
            count++;
            node=node.next;
        }
        return count;
    }
}