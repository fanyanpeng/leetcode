

public class T148 {
    public static void main(String[] args){
        Solution148 solution=new Solution148();

        System.out.println(solution);

    }
}

class Solution148 {

    // planning on using divide and merge,
    // the O() is a little confusing
    // for 8 node,
    // first, count the number 8
    // then, get the first 4 and the last 4, that is 4
    // then, for the first 4, get the first two,that is 2
    // then, for the first 2, get the first one, that is 1
    // now time to merge all, each level, it's 16 times comparison
    // we got 8,4,2,1 4 layers, that is 64 times. this is n*log n
    // before that, each layer, do half iteration.
    // so, it's n*log n.
    public ListNode sortList(ListNode head) {
        int count = count(head);
        return mergeSort(head,count);
    }

    private ListNode mergeSort(ListNode head,int count){
        if(count<=1){
            return head;
        }
        int leftCount = count/2;
        int rightCount = count-leftCount;
        ListNode[] dividedList = divide(head,leftCount,rightCount);
        ListNode leftSorted = mergeSort(dividedList[0],leftCount);
        ListNode rightSorted = mergeSort(dividedList[1],rightCount);

        return merge(leftSorted,rightSorted);
    }

    private int count(ListNode node){
        int count=0;
        while (node!=null){
            count++;
            node=node.next;
        }
        return count;
    }


    private ListNode[] divide(ListNode node,int leftCount,int rightCount){
        int count=0;
        ListNode cur = node;
        for(int i=1;i<leftCount;i++){
            // move (leftCount-1) times
            cur=cur.next;
        }
        // now cur is the last one of left half
        ListNode rightHalf = cur.next;
        cur.next=null;// divide the list
        ListNode leftHalf = node;
        return new ListNode[]{leftHalf,rightHalf};
    }

    private ListNode merge(ListNode left,ListNode right){
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        ListNode lCur=left;
        ListNode rCur=right;
        while (lCur!=null&&rCur!=null){
            if(lCur.val<=rCur.val){
                ListNode nextL= lCur.next;
                cur.next=lCur;
                cur=cur.next;
                cur.next=null;
                lCur=nextL;
            }else {
                ListNode nextR = rCur.next;
                cur.next=rCur;
                cur=cur.next;
                cur.next=null;
                rCur=nextR;
            }
        }
        if(lCur!=null){
            cur.next=lCur;
        }
        if(rCur!=null){
            cur.next=rCur;
        }
        return dummy.next;
    }





}