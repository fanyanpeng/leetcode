import java.util.Arrays;

public class t59 {
    public static void main(String[] args){
        Solution59 solution=new Solution59();
        int[] a=new int[]{3,4,-1,1};
        for(int[] ints: solution.generateMatrix(1)){
            System.out.println(Arrays.toString(ints));
        }


    }
}

class Solution59 {
    public int[][] generateMatrix(int n) {
        int[][] moves={{0,1},{1,0},{0,-1},{-1,0}};
        int[][] matrix=new int[n][n];
        boolean[][] occupird=new boolean[n][n];
        int i=0,j=0;
        int move=0;
        for(int value=0;value<n*n;value++){
            matrix[i][j]=value+1;
            occupird[i][j]=true;
            int next_i=i+moves[move][0];
            int next_j=j+moves[move][1];
            if(next_i<0||next_i>=n
                    ||next_j<0||next_j>=n
                    || occupird[next_i][next_j]){
                move=(move+1)%4;
            }
            i=i+moves[move][0];
            j=j+moves[move][1];
        }
        return matrix;
    }
}