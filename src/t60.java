import java.util.Arrays;

public class t60 {
    public static void main(String[] args){
        Solution60 solution=new Solution60();
        int[] a=new int[]{3,4,-1,1};
//        System.out.println(solution.getPermutation(9,9*8*7*6*5*4*3*2));
        System.out.println(solution.getPermutation(9,9*8*7*6*5*4*3*2));
    }
}

class Solution60 {

    //计算
    int count=0;
    public String getPermutation(int n, int k) {
        int[] list=new int[n];
        boolean[] used=new boolean[n];
        int pos=0;
        //k begins with 1, to put it into computer, k-1.
        k--;
        while (pos<n){
            int factorial=get_factorial(n-1-pos);//for 3, the first is 2!
            int th=k/factorial;//if k==1, that means the position 1, the 2rd one
            k=k%factorial;
            int nums_pos=get_pos(used,th);
            list[pos++]=nums_pos+1;
            used[nums_pos]=true;
        }
        return list_2_string(list);
    }

    int get_pos(boolean[] used,int th){
        for(int i=0;i<used.length;i++){
            if(!used[i]){
                if(th==0)return i;//0 means the first one !
                th--;

            }
        }
        return -1;
    }

    int get_factorial(int ii){
        if(ii==0)return 1;
        int ans=1;
        for(int i=2;i<=ii;i++){
            ans*=i;
        }
        return ans;
    }


    String list_2_string(int[] list){
        StringBuilder builder=new StringBuilder();
        for(int i:list){
            builder.append(i);
        }
        return builder.toString();
    }

    //列举
//    int count=0;
//
//    public String getPermutation(int n, int k) {
//        int[] list=new int[n];
//        boolean[] used=new boolean[n];
//        return permutation(list,used,0,k);
//    }
//
//    String permutation(int[] list,boolean[] used,int pos, int k) {
//        int n=list.length;
//        if(pos==list.length){
//            count++;
//            if(count==k){
//                return list_2_string(list);
//            }
//            else return null;
//        }
//        for(int i=0;i<n;i++){
//            if(used[i])continue;
//            list[pos]=i+1;
//            used[i]=true;
//            String temp=permutation(list,used,pos+1,k);
//            if(temp!=null)return temp;
//            used[i]=false;
//        }
//        return null;
//    }
//    String list_2_string(int[] list){
//        StringBuilder builder=new StringBuilder();
//        for(int i:list){
//            builder.append(i);
//        }
//        return builder.toString();
//    }

}