import java.lang.reflect.Array;
import java.util.Arrays;

public class T88 {
    public static void main(String[] args){
        Solution88 solution=new Solution88();

//        int[] num1=new int[]{1,2,3,0,0,0};
//        int[] num2=new int[]{2,5,6};
//        int[] num1=new int[]{1};
//        int[] num2=new int[]{};
        int[] num1=new int[]{0};
        int[] num2=new int[]{88};

        solution.merge(num1,0,num2,1);

        System.out.println(Arrays.toString(num1));

    }
}

class Solution88 {

    //从后面归并就不需要额外数组啦！
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums1_copy = Arrays.copyOf(nums1,m);

        int ptr1=0,ptr2=0,ptr_ans=0;
        while (ptr1<m || ptr2<n){
            if(ptr1==m){
                nums1[ptr_ans++]=nums2[ptr2++];
                continue;
            }
            if(ptr2==n){
                nums1[ptr_ans++]=nums1_copy[ptr1++];
                continue;
            }
            int n1=nums1_copy[ptr1];
            int n2=nums2[ptr2];
            if(n1<n2){
                nums1[ptr_ans++]=nums1_copy[ptr1++];
            }
            else {
                nums1[ptr_ans++]=nums2[ptr2++];
            }
        }

    }

}