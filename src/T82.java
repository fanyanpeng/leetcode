import java.util.HashSet;

public class T82 {
    public static void main(String[] args){
        Solution82 solution=new Solution82();

        System.out.println(solution);

    }
}

class Solution82 {

    public ListNode deleteDuplicates(ListNode head) {

        ListNode dummy=new ListNode(-100000,head);
        ListNode ptr=dummy;
        //遍历所有的节点
        while (ptr!=null){
            //若下面有两个节点，每一步都需要判断
            while (ptr.next!=null&&ptr.next.next!=null){
                //若两个节点是否相等，找到该值的后一个，赋值为当前位置的下一个
                if(ptr.next.val==ptr.next.next.val){
                    int val=ptr.next.val;
                    ListNode node=ptr.next;
                    //找到下一个
                    while (node!=null && node.val==val){
                        node=node.next;
                    }
                    ptr.next=node;
                }
                //若不相等，计入下一步
                else {
                    ptr=ptr.next;
                }
            }
            //最后一步
            ptr=ptr.next;
        }
        //返回dummy下一个
        return dummy.next;

    }
//        ListNode dummy=new ListNode(-100000,head);
//        ListNode ptr=dummy;
//
//        HashSet<Integer> toRemove=new HashSet<>();
//        int cur=-999;
//        ListNode tmp=head;
//        while (tmp!=null){
//            int val=tmp.val;
//            if(val==cur){
//                toRemove.add(val);
//            }
//            cur=val;
//            tmp=tmp.next;
//
//        }
//
//        while (ptr.next!=null){
//            int nextVal=ptr.next.val;
//            if(!toRemove.contains(nextVal)){
//                cur=nextVal;
//                ptr=ptr.next;
//                continue;
//            }
//            //equals
//            removeNextNode(ptr);
//        }
//        return dummy.next;
//
//    }
//
//    void removeNextNode(ListNode node){
//        ListNode next=node.next;
//        node.next= next.next;
//    }
}