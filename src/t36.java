public class t36 {
    public static void main(String[] args){
        Solution36 solution=new Solution36();
        char[][] board= new char[][]{
                {'8','.','.','.','.','.','.','.','.'},
                {'.','.','3','3','.','.','.','.','.'},
                {'.','7','.','.','9','.','2','.','.'},
                {'.','5','.','.','.','7','.','.','.'},
                {'.','.','.','.','4','5','7','.','.'},
                {'.','.','.','1','.','.','.','3','.'},
                {'.','.','1','.','.','.','.','6','8'},
                {'.','.','8','5','.','.','.','1','.'},
                {'.','9','.','.','.','.','4','.','.'}};
        System.out.println(solution.isValidSudoku(board));
    }
}

class Solution36 {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] row=new boolean[9][9];
        boolean[][] line=new boolean[9][9];
        boolean[][][] cell=new boolean[3][3][9];

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.')continue;
                int num=board[i][j]-'1';

                if(row[i][num]||line[j][num]||cell[i/3][j/3][num]) {
                    return false;
                }
                row[i][num]=true;
                line[j][num]=true;
                cell[i/3][j/3][num]=true;
            }
        }
        return true;
    }
}