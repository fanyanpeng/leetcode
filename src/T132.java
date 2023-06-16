import java.lang.reflect.Array;
import java.util.Arrays;

public class T132 {
    public static void main(String[] args){
        Solution132 solution=new Solution132();

        System.out.println(solution.minCut("aab"));

    }
}

class Solution132 {

    private boolean[][] isPal(String s){
        int n=s.length();
        char[] arr=s.toCharArray();
        boolean[][] isPal=new boolean[n][n];
        for(int i=n-1;i>=0;i--){
            for(int j=Math.max(0,i-1);j<n;j++){ //减少赋值范围，可以轻微提高速度
                if(i>=j){
                    isPal[i][j]=true;
                }
                else {
                    isPal[i][j]=arr[i]==arr[j] && isPal[i+1][j-1];
                }
            }
        }
        return isPal;
    }

    public int minCut(String s) {
        int n=s.length();
        boolean[][] isPal=isPal(s);
        int[] minCut=new int[n];
        Arrays.fill(minCut,n);
        minCut[0]=0;
        for(int i =1;i<n;i++){
            if(isPal[0][i]){
                minCut[i]=0;
                continue;
            }
            for(int k=1;k<=i;k++){
                if(isPal[k][i]){
                    minCut[i]=Math.min(minCut[i],minCut[k-1]+1);
                }
            }
        }
        return minCut[n-1];
    }
}