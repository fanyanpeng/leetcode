import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class t72 {
    public static void main(String[] args){
        Solution72 solution=new Solution72();
        System.out.println(solution.minDistance("a","b"));

    }
}

class Solution72{
    public int minDistance(String word1, String word2) {
        int m=word1.length();
        int n=word2.length();
        char[] w1=word1.toCharArray();
        char[] w2=word2.toCharArray();

        int[][] dp=new int[m+1][n+1];
        for(int i=0;i<m+1;i++){
            dp[i][0]=i;
        }
        for(int j=0;j<n+1;j++){
            dp[0][j]=j;
        }
        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if(w1[i-1]==w2[j-1]){
                    dp[i][j]=minInt(dp[i-1][j-1],dp[i][j-1]+1,dp[i-1][j]+1);
                }
                else {
                    dp[i][j]=minInt(dp[i-1][j-1]+1,dp[i][j-1]+1,dp[i-1][j]+1);
                }

            }

        }
        System.out.println(UUID.randomUUID());
        return dp[m][n];

    }

    private int minInt(int a1,int a2,int a3){
        int b2=Math.min(a1,a2);
        return Math.min(b2,a3);

    }

}
