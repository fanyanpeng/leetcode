public class t62 {
    public static void main(String[] args){
        Solution62 solution=new Solution62();
        int[] a=new int[]{3,4,-1,1};
        System.out.println(solution.uniquePaths(16,16));

    }
}

class Solution62 {

//    public int uniquePaths(int m, int n) {
//        return C(m+n-2,Math.min(m-1,n-1));
//    }
//    int C(int max,int min){
//        long A=A(max, min);
//        return (int)(A/fact(min));
//
//    }
//    long A(int max,int min){
//        long ans=1;
//        for(int i=max;i>max-min;i--){
//            ans*=i;
//        }
//        return ans;
//    }
//    int fact(int ii){
//        int ans=1;
//        for(int i=1;i<=ii;i++){
//            ans*=i;
//        }
//        return ans;
//    }



    public int uniquePaths(int m, int n) {
        return C(m+n-2,Math.min(m-1,n-1));
    }
    int C(int max,int min){
        long ans=1;
        boolean[] used=new boolean[min];
        for(int i=max;i>max-min;i--){
            ans*=i;
            for(int j=0;j<min;j++){
                if(used[j])continue;
                if(ans%(j+1)==0){
                    ans/=(j+1);
                    used[j]=true;
                }
            }
        }
        return (int)ans;
    }



}


