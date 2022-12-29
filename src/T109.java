public class T109 {
    public static void main(String[] args){
        Solution109 solution=new Solution109();

        System.out.println(solution);

    }
}

class Solution109 {


    private int[] nums;
    public TreeNode sortedListToBST(ListNode head) {
        initNums(head);
        return makeTree(0,nums.length-1);
    }

    private TreeNode makeTree(int l, int r) {
        if(l>r){
            return null;
        }
        int mid = (l+r)/2;
        return new TreeNode(nums[mid],
                makeTree(l,mid-1),
                makeTree(mid+1,r));
    }


    private void initNums(ListNode head) {
        int l = 0;
        for(ListNode it = head;it!=null;it=it.next){
            l++;
        }
        nums=new int[l];
        l=0;
        for(ListNode it = head;it!=null;it=it.next){
            nums[l++]=it.val;
        }
    }


}