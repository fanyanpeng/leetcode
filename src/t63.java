public class t63 {
    public static void main(String[] args){
        Solution63 solution=new Solution63();
        int[][] a=new int[][]{{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(solution.uniquePathsWithObstacles(a));

    }
}

class Solution63 {


    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        //
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int [][] dp =new int[m][n];


        //对每一行，遇到障碍后面的东西都处理不了
        for(int i=0;i<m && obstacleGrid[i][0]!=1;i++){
            dp[i][0]=1;
        }
        for(int j=0;j<n && obstacleGrid[0][j]!=1;j++){
            dp[0][j]=1;
        }
        //做完上述遍历后不需要考虑特殊情况
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
                if(obstacleGrid[i][j]==1)dp[i][j]=0;
            }
        }
        return dp[m-1][n-1];
    }




}