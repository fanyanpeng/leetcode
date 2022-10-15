import java.util.ArrayList;
import java.util.List;

public class t54 {
    public static void main(String[] args){
        Solution54 solution=new Solution54();
        int[][] a=new int[][]{{1, 2, 3, 4},{5,6,7,8},{9,10,11,12}};
        System.out.println(solution.spiralOrder(a).toString());

    }
}

class Solution54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m= matrix.length;
        int n=matrix[0].length;
        boolean[][] visited=new boolean[m][n];
        int[][] moves=new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        int count=0;
        int move_id=0;
        int i=0,j=0;
        List<Integer> ans=new ArrayList<>();
        while (count!=m*n){
            ans.add(matrix[i][j]);
            count++;
            visited[i][j]=true;
            int try_i=i+moves[move_id][0];
            int try_j=j+moves[move_id][1];
            if(try_i<0 || try_i >= m
                    ||try_j <0 || try_j >= n
                    ||visited[try_i][try_j]){
                move_id=(move_id+1)%4;
            }
            i+=moves[move_id][0];
            j+=moves[move_id][1];
        }
        return ans;
    }

}