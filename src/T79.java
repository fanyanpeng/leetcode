import java.util.ArrayList;
import java.util.List;

public class T79 {
    public static void main(String[] args){
        Solution79 solution=new Solution79();

        char[][] board=new char[][]{
                {'a','a'},{'a','a'},{'A','A'}
        };
        String word="aaaAAa";
        System.out.println(solution.exist(board,word));

    }
}

class Solution79 {

    char[] chars;
    char[][] board;

    boolean visit(boolean[][] visited,int offset,int ii,int jj){

        if(chars[offset]!=board[ii][jj]){
            return false;
        }
        //pass the last check
        if(offset==chars.length-1){
            return true;
        }
        visited[ii][jj]=true;
        List<int[]> nextSteps=getAvailablePositions(visited,ii,jj);

        //try each path
        for(int[] ij:nextSteps){
            int i=ij[0];
            int j=ij[1];
            if(visit(visited,offset+1,i,j)){
                return true;
            }

        }
        visited[ii][jj]=false;
        return false;
    }

    List<int[]> getAvailablePositions(boolean[][] visited, int ii, int jj){
        int m=visited.length;
        int n=visited[0].length;
        List<int[]> positions=new ArrayList<>();
        int[][] moves=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

        for(int[] move:moves){
            int i=move[0];
            int j=move[1];

            int try_i=ii+i;
            int try_j=jj+j;
            if(try_i<0||try_i>=m||try_j<0||try_j>=n||visited[try_i][try_j]){
                continue;
            }

            positions.add(new int[]{try_i,try_j});
        }

        return positions;
    }




    public boolean exist(char[][] board, String word) {
        int row=board.length;
        int col=board[0].length;
        char[] chars=word.toCharArray();
        this.chars=chars;
        this.board=board;

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(visit(new boolean[row][col],0,i,j)){
                    return true;
                }
            }
        }
        return false;
    }
}