import java.util.Arrays;

public class T73 {
    public static void main(String[] args){
        Solution73 solution=new Solution73();

        System.out.println(solution);

    }
}

class Solution73 {

    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[] row = new boolean[m];   //行
        boolean[] columns = new boolean[n];   //列

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    break;
                }
            }
        }

        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                if (matrix[i][j] == 0) {
                    columns[j] = true;
                    break;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            if (row[i]) {
                Arrays.fill(matrix[i], 0);
            }
        }
        for (int j = 0; j < n; j++) {
            if (columns[j]) {
                for (int i = 0; i < m; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}