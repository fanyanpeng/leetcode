import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class T130 {
    public static void main(String[] args){
        Solution130 solution=new Solution130();
        solution.solve(new char[][]{{'X'}});
        System.out.println();

    }
}

class Solution130 {


    /**
     * 解放O
     * @author   fanyanpeng
     * @date 2023/1/1 17:13
     * @param i
     * @param j
     * @param m
     * @param n
     * @param board
     * @param isFree
     * @return void
     */
    private void free(int i,int j,int m,int n,char[][] board,boolean[][] isFree){
        if(i<m&&i>=0&&j<n&&j>=0&& board[i][j]=='O'&&!isFree[i][j]){
            isFree[i][j]=true;
            free(i+1, j, m, n, board, isFree);
            free(i-1, j, m, n, board, isFree);
            free(i, j+1, m, n, board, isFree);
            free(i, j-1, m, n, board, isFree);

        }
    }

    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        //当前O是否已经被解放
        boolean[][] isFree=new boolean[m][n];
        for(int i=0;i<m;i++){
            free(i,0,m,n,board,isFree);
            free(i,n-1,m,n,board,isFree);
        }
        for(int j=0;j<n;j++){
            free(0,j,m,n,board,isFree);
            free(m-1,j,m,n,board,isFree);
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!isFree[i][j]){
                    board[i][j]='X';
                }
            }
        }
    }







    public void solve1(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] isFree=new boolean[m][n];
        boolean[][] visited=new boolean[m][n];
        List<Integer[]> freeList=new ArrayList<>();
        int[][] pos=new int[][]{{1,0},{0,1},{-1,0},{0,-1}};

        List<int[]> boarder=new ArrayList<>();
        for(int i=0;i<m;i++){
            boarder.add(new int[]{i,0});
            boarder.add(new int[]{i,n-1});
        }
        for(int j=0;j<n;j++){
            boarder.add(new int[]{0,j});
            boarder.add(new int[]{m-1,j});
        }
        for(int[] b:boarder){
            int i=b[0];
            int j=b[1];
            char c = board[i][j];
            if(c=='X'){
                continue;
            }
            if(i == 0 || i == m - 1 || j == 0 || j == n - 1){
                isFree[i][j]=true;
                freeList.add(new Integer[]{i,j});
                visited[i][j]=true;
            }
        }
        while (freeList.size()!=0){
            List<Integer[]> next=new ArrayList<>();
            for(Integer[] freePos:freeList){
                int i = freePos[0];
                int j=freePos[1];
                for (int[] p:pos){
                    int ii=i+p[0];
                    int jj=j+p[1];
                    if(ii<0||jj<0||ii>=m||jj>=n){
                        continue;
                    }
                    if(board[ii][jj]=='X'){
                        continue;
                    }
                    if(!visited[ii][jj]){
                        visited[ii][jj]=true;
                        isFree[ii][jj]=true;
                        next.add(new Integer[]{ii,jj});
                    }
                }
            }
            freeList=next;
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!isFree[i][j]){
                    board[i][j]='X';
                }
            }
        }

    }



}