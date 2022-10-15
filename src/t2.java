import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

public class t2 {
    public static void main(String[] args){
        ListNode l1=new ListNode(9);
        ListNode l2=new ListNode(9);
        ListNode l3=new ListNode(9);
        l1.next=l2;
        l2.next=l3;
        ListNode l4=new ListNode(9);
        ListNode l5=new ListNode(9);
        ListNode l6=new ListNode(9);
        l4.next=l5;
        l5.next=l6;

        printList(Solution.addTwoNumbers(l1,l4));

    }

    private static void printList(ListNode l) {
        while (l!=null){
            System.out.print(l.val);
            l=l.next;
        }
    }
}


//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {



    public static ListNode addTwoNumbers_again(ListNode l1, ListNode l2) {
        ListNode head=new ListNode();
        ListNode ptr=head;
        int carry=0;
        int newVal;
        while (l1!=null || l2!=null|| carry!=0){
            ptr.next= new ListNode();
            ptr=ptr.next;
            int sum=carry;
            if(l1!=null){
                sum+=l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                sum+=l2.val;
                l2=l2.next;
            }
            carry=sum/10;
            newVal=sum%10;
            ptr.val=newVal;
        }
        return head.next;
    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head=new ListNode();
        ListNode tail=head;
        int carry=0;
        while (true){
            //add last time carry
            int sum=carry;
            //if contains a value
            if(l1!=null){
                sum+=l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                sum+=l2.val;
                l2=l2.next;
            }
            //get figure for this degree
            tail.val=sum%10;
            carry=sum/10;
            //no carry on, and no more listnode
            //it's time to end
            if(carry==0 && l1==null && l2==null){
                break;
            }
            //not the end, make a new tail, do this loop again
            ListNode new_tail=new ListNode();
            tail.next=new_tail;
            tail=new_tail;
        }
        //I used head this time
        //more understandable
        return head;
    }






    //3
    public int lengthOfLongestSubstring(String s) {
        char[] chars=s.toCharArray();
        int left=0;
        int right=0;
        int max=0;
        HashSet<Character> set=new HashSet<>(100);
        while (right<s.length()){
            if(set.contains(chars[right])){
                while (left<right){
                    set.remove(chars[left]);
                    if(chars[left]==chars[right]) {
                        left++;
                        break;
                    }
                    left++;
                }
            }
            set.add(chars[right]);
            right++;
            max=Math.max(max,set.size());
        }
        return max;
    }
}


