public class t23 {
    public static void main(String[] args){
        Solution23 solution=new Solution23();
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
        ListNode[] listNodes=new ListNode[]{l1,l4};
        ListNode ans= solution.mergeKLists(listNodes);
        while (ans!=null){
            System.out.println(ans.val);
            ans=ans.next;
        }
    }
}

//class ListNode {
//    int val;
//    ListNode next;
//    ListNode() {}
//    ListNode(int val) { this.val = val; }
//    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//}

class Solution23{
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0)
            return null;
        if(lists.length==1)
            return lists[0];
        int pos=0;
        int ceil=(int) Math.ceil(lists.length/2.0);
        ListNode[] list=new ListNode[ceil];
        for(int i=0;i<ceil;i++){
            ListNode l=connect(lists[2*i],2*i+1 < lists.length?lists[2*i+1]:null);
            list[pos++]=l;
        }
        return mergeKLists(list);
    }

    //divide
//    public ListNode mergeKLists(ListNode[] lists) {
//        if(lists.length==0)return null;
//        ListNode ans=lists[0];
//        for(int i=1;i< lists.length;i++){
//            ans=connect(ans,lists[i]);
//        }
//        return ans;
//
//    }
    ListNode connect(ListNode listNode1,ListNode listNode2){
        ListNode ans=new ListNode();
        ListNode list=ans;
        while (listNode1!=null && listNode2!=null){
            if(listNode1.val<listNode2.val){
//                list.next=new ListNode(listNode1.val);
//                listNode1=listNode1.next;
                list.next=listNode1;
                listNode1=listNode1.next;

            }
            else {
//                list.next=new ListNode(listNode2.val);
//                listNode2=listNode2.next;
                list.next=listNode2;
                listNode2=listNode2.next;
                int i=0;
            }
            list=list.next;
        }
        list.next=listNode1!=null?listNode1:listNode2;
        return ans.next;
    }
}
