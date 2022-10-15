import java.util.PriorityQueue;

public class t407 {
    public static void main(String[] args){
        Solution407 solution=new Solution407();

        System.out.println(solution.trapRainWater1(new int[][]{{1,4,3,1,3,2},{3,2,1,3,2,4},{2,3,3,2,3,1}}));

    }
}

class Solution407 {

    /**
     *
     * 考虑动态规划
     * record it
     * @author   fanyanpeng
     * @date 2022/4/14 2:01
     */
    public int trapRainWater1(int[][] heightMap) {
        int m= heightMap.length;
        int n=heightMap[0].length;
        boolean[][] visited=new boolean[m][n];
        PriorityQueue<int[]> margin=new PriorityQueue<>((o1, o2) -> o1[2]-o2[2]);
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0||j==0||i==m-1||j==n-1){
                    margin.add(new int[]{i,j,heightMap[i][j]});
                    visited[i][j]=true;
                }
            }
        }
        int [][] dirs=new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        int total=0;
        while (!margin.isEmpty()){
            int[] minMargin=margin.poll();
            for(int[] dir:dirs){
                int x=minMargin[0]+dir[0];
                int y=minMargin[1]+dir[1];
                if(x>0 && x<m && y>0 && y<n && !visited[x][y]){
                    if(heightMap[x][y]<minMargin[2]){
                        total+=minMargin[2]-heightMap[x][y];
                        heightMap[x][y]=minMargin[2];
                    }
                    margin.add(new int[]{x,y,heightMap[x][y]});
                    visited[x][y]=true;
                }
            }
        }


        return total;

    }

    /**
     * record it
     * 错误，因为水可以拐弯流出
     * @author   fanyanpeng
     * @date 2022/4/14 2:01
     */
    public int trapRainWater2(int[][] heightMap) {

        int m=heightMap.length;
        int n=heightMap[0].length;

        int[][] m_level=new int[m][n];

        int[][] n_level=new int[n][m];

        for(int i=0;i<m;i++){
            int left=0;
            int right=n-1;
            int level=0;
            while (left<right){
                int cur_level=Math.min(heightMap[i][left],heightMap[i][right]);
                level=Math.max(cur_level,level);
                if(heightMap[i][left]<heightMap[i][right]){
                    m_level[i][left++]=level;
                }
                else {
                    m_level[i][right--]=level;
                }
            }
        }

        for(int i=0;i<n;i++){
            int left=0;
            int right=m-1;
            int level=0;
            while (left<right){
                int cur_level=Math.min(heightMap[left][i],heightMap[right][i]);
                level=Math.max(cur_level,level);
                if(heightMap[left][i]<heightMap[right][i]){
                    n_level[i][left++]=level;
                }
                else {
                    n_level[i][right--]=level;
                }

            }
        }

        int total=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int cur=Math.min(m_level[i][j],n_level[j][i])-heightMap[i][j];
                if(cur<0){
                    cur=0;
                }
                total+=cur;
            }
        }


        return total;

    }



}