import java.util.*;

public class t37 {
    public static void main(String[] args){

        long t1=Calendar.getInstance().getTimeInMillis();
        Solution37 solution=new Solution37();
        System.out.println("百度百科“世界最难数独”：");
        char[][]board= new char[][]{
                {'8','.','.','.','.','.','.','.','.'},
                {'.','.','3','6','.','.','.','.','.'},
                {'.','7','.','.','9','.','2','.','.'},
                {'.','5','.','.','.','7','.','.','.'},
                {'.','.','.','.','4','5','7','.','.'},
                {'.','.','.','1','.','.','.','3','.'},
                {'.','.','1','.','.','.','.','6','8'},
                {'.','.','8','5','.','.','.','1','.'},
                {'.','9','.','.','.','.','4','.','.'}};
        solution.solveSudoku(board);
        for (char[] chars : board) {
            System.out.println(Arrays.toString(chars));
        }
        System.out.println("求解耗时"+(Calendar.getInstance().getTimeInMillis()-t1)+"ms");
    }
}

class Solution37 {

    //算法3：将状态从 单个 转为 一行、一列、一宫格
    boolean[][] row=new boolean[9][9];
    boolean[][] line=new boolean[9][9];
    boolean[][][] cell=new boolean[3][3][9];

    public void solveSudoku(char[][] board) {
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]!='.'){
                    int pos=board[i][j]-'1';
                    row[i][pos]=line[j][pos]=cell[i/3][j/3][pos]=true;
                }
            }
        }
        //初始化状态表，true代表已经出现。'1'->0;'2'->1...,'9'->8
        fill(board);
    }
    boolean fill(char[][] board){
        if(board_filled(board))return true;
        int key=getMin(board);//getMin key and judge.
        if(key==-1) //dead state/必要的判断，当出现这种情况时，需要退出，否者会出现越界。
            return false;
        int ii=key/9,jj=key%9;
        List<Character> list=get_available(board,ii,jj);
        for(Character c:list){
            int pos=c-'1';
            board[ii][jj]=c;
            row[ii][pos]=line[jj][pos]=cell[ii/3][jj/3][pos]=true;
            if(fill(board))return true;
            //restore
            board[ii][jj]='.';
            row[ii][pos]=line[jj][pos]=cell[ii/3][jj/3][pos]=false;
        }
        return false;
    }
        boolean board_filled(char[][] board){
        for(char[] chars:board) for(char c:chars) if(c=='.') return false;
        return true;
    }
    List<Character> get_available(char[][] board,int ii,int jj){
        List<Character> list=new ArrayList<>();
        for(int k=0;k<9;k++){
            if(!row[ii][k] && !line[jj][k]&&!cell[ii/3][jj/3][k]){
                list.add((char) (k+'1'));
            }
        }
        return list;
    }
    private int getMin(char[][] board) {
        int minKey=-1;
        int min=10;
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.'){
                    int count=0;
                    for(int k=0;k<9;k++){//when none of them used k
                        if(!row[i][k]&&!line[j][k]&&!cell[i/3][j/3][k]){
                            count++;
                        }
                    }
                    if(count==1)
                        return i*9+j;
                    if(count<min&&count>0){
                        minKey=i*9+j;
                    }
                    if(count==0)return -1;//when the state is dead.
                }
            }
        }
        return minKey;
    }

    //算法2：hashmap只生成一次，之后只是对他进行保存修改。

//    public void solveSudoku(char[][] board) {
//        fill(board,initialize_map(board));
//
//    }
//
//    boolean fill(char[][] board,HashMap<Integer,List<Character>> map){
//        if(board_filled(board))
//            return true;
//        if(board_dead(board,map))
//            return false;
//
//        int key=min_key(board,map);
//        int ii=key/board.length,jj=key%board.length;
//        List<Character> avail=map.get(key);
//        //if(key==-1)return false;
//        for(Character c:avail){
//            HashMap<Integer,List<Character>> map_t=new HashMap<>();
//            board[ii][jj]=c;
//            copy(map,map_t);
//            //那些de了很久的bug-1
////            map_t.get(ii*9+jj).remove(c);
//            change_map(board,map_t,ii,jj);
//            if(fill(board,map_t))return true;
//            board[ii][jj]='.';
//        }
//
//        return false;
//    }
//
//    boolean board_dead(char[][] board,HashMap<Integer,List<Character>> map){
//        int len=board.length;
//        for(int i=0;i<81;i++){
//            if(board[i/len][i%len]=='.'&&map.get(i).size()==0)
//                return true;
//        }
//        return false;
//    }
//
//    private void copy(HashMap<Integer, List<Character>> from, HashMap<Integer, List<Character>> to) {
//        for(int key:from.keySet()){
//            List<Character> characters = new ArrayList<>(from.get(key));
//            to.put(key,characters);
//        }
//    }
//
//
//    int min_key(char[][] board,HashMap<Integer,List<Character>> map){
//        int min=10;
//        int min_key=-1;
//        for(Integer key: map.keySet()){
//            int size=map.get(key).size();
//            if(size==1)return key;
//            if(size<min&&size>1){
//                min=size;
//                min_key=key;
//            }
//        }
//        return min_key;
//    }
//
//
//    boolean board_filled(char[][] board){
//        for(char[] chars:board){
//            for(char c:chars){
//                if(c=='.')return false;
//            }
//        }
//        return true;
//    }
//    HashMap<Integer, List<Character>> initialize_map(char[][] board){
//        HashMap<Integer, List<Character>> map=new HashMap<>();
//        int len=board.length;
//        //all '.', generate a full char list
//        for(int i=0;i<len*len;i++){
//            if(board[i/len][i%len]=='.'){
//                List<Character> t=new ArrayList<>();
//                for(char c='1';c<='9';c++){
//                    t.add(c);
//                }
//                calculate_available(board,t,i/len,i%len);
//                map.put(i,t);
//            }
//        }
//        return map;
//    }
//    void calculate_available(char[][] board,List<Character> available, int ii,int jj) {
//        //line
//        for (int j = 0; j < board.length; j++) {
//            //remove函数需要使用对象，
//            // 使用int等类型会去寻找地址。
//            Character c = board[ii][j];
//            available.remove(c);
//        }
//
//        for (int i = 0; i < board.length; i++) {
//            Character c = board[i][jj];
//            available.remove(c);
//        }
//
//        //cell
//        int row = ii / 3;
//        int line = jj / 3;
//        for (int i = row * 3; i < (row * 3 + 3); i++) {
//            for (int j = line * 3; j < line * 3 + 3; j++) {
//                Character c = board[i][j];
//                available.remove(c);
//            }
//        }
//    }
//        void change_map(char[][] board,HashMap<Integer,List<Character>> map, int ii,int jj) {
//            //line
//            Character c = board[ii][jj];
//            List<Character> list=new ArrayList<>();
//            //那些de了很久的bug-1
//            //分析：问题在于填上数字之后，
//            // hash表对应位置列表并没有清空，
//            // 在寻找min列表的时候，
//            // 没有限制只找空白位置
//            //最后导致重复修改一个没有问题的位置。
//            // 修改方式：1，填表的时候清空列表；
//            // 2，选取最小列表的时候加上条件，限制为'.'
//            map.put(ii*9+jj,list);
//            for (int j = 0; j < board.length; j++) {
//                //remove函数需要使用对象，
//                // 使用int等类型会去寻找地址。
//                if (board[ii][j] == '.') {
//                    map.get(ii * 9 + j).remove(c);
//                }
//            }
//
//            for (int i = 0; i < board.length; i++) {
//                if (board[i][jj] == '.') {
//                    map.get(i * 9 + jj).remove(c);
//                }
//            }
//
//            //cell
//            int row = ii / 3;
//            int line = jj / 3;
//            for (int i = row * 3; i < row * 3 + 3; i++) {
//                for (int j = line * 3; j < line * 3 + 3; j++) {
//                    if (board[i][j] == '.') {
//                        map.get(i * 9 + j).remove(c);
//                    }
//                }
//            }
//        }

//算法1：朴素减枝，使用hashmap
//
//    public void solveSudoku(char[][] board) {
//        fill(board);
//
//    }
//
//    boolean fill(char[][] board){
//        if(board_filled(board))return true;
//        HashMap<Integer,List<Character>> map=initialize_map(board);
//        int key=min_key(board,map);
//        int ii=key/board.length,jj=key%board.length;
//        List<Character> avail=map.get(key);
//        for(char c:avail){
//            board[ii][jj]=c;
//            if(fill(board))return true;
//            board[ii][jj]='.';
//        }
//        System.gc();
//        return false;
//    }
//
//
//    int min_key(char[][] board,HashMap<Integer,List<Character>> map){
//        int min=10;
//        int min_key=-1;
//        for(Integer key: map.keySet()){
//            int size=map.get(key).size();
//            if(size==1)return key;
//            if(size<min){
//                min=size;
//                min_key=key;
//            }
//        }
//        return min_key;
//    }
//
//
//    boolean board_filled(char[][] board){
//        for(char[] chars:board){
//            for(char c:chars){
//                if(c=='.')return false;
//            }
//        }
//        return true;
//    }
//    HashMap<Integer, List<Character>> initialize_map(char[][] board){
//        HashMap<Integer, List<Character>> map=new HashMap<>();
//        int len=board.length;
//        //all '.', generate a full char list
//        for(int i=0;i<len*len;i++){
//            if(board[i/len][i%len]=='.'){
//                List<Character> t=new ArrayList<>();
//                for(char c='1';c<='9';c++){
//                    t.add(c);
//                }
//                calculate_available(board,t,i/len,i%len);
//                map.put(i,t);
//            }
//        }
//        return map;
//    }
//    void calculate_available(char[][] board,List<Character> available, int ii,int jj){
//        //line
//        for(int j=0;j<board.length;j++){
//            //remove函数需要使用对象，
//            // 使用int等类型会去寻找地址。
//            Character c=board[ii][j];
//            available.remove(c);
//        }
//
//        for(int i=0;i<board.length;i++){
//            Character c=board[i][jj];
//            available.remove(c);
//        }
//
//        //cell
//        int row=ii/3;
//        int line=jj/3;
//        for(int i=row*3;i<(row*3+3);i++){
//            for(int j=line*3;j<line*3+3;j++){
//                Character c=board[i][j];
//                available.remove(c);
//            }
//        }
//    }
}
