import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class t51 {
    public static void main(String[] args){
        Solution51 solution=new Solution51();
        int[] a=new int[]{3,4,-1,1};
        long t1 = Calendar.getInstance().getTimeInMillis();
        List<List<String>> ans_list=solution.solveNQueens(9);
        long t2 = Calendar.getInstance().getTimeInMillis();

        for(List<String> list:ans_list){
            System.out.println(Arrays.toString(list.toArray()));
        }
        System.out.println(t2-t1);
    }
}

//快速验证能否填表
class Solution51 {
    List<List<String>> ans_list=new ArrayList<>();
    //occupied?
    boolean[] row;
    boolean[] line;
    boolean[] right;
    boolean[] left;
    int n;
    public List<List<String>> solveNQueens(int n) {
        this.n=n;
        char[] new_table=new char[n*n];
        row=new boolean[n];
        line=new boolean[n];
        right=new boolean[2*n];
        left=new boolean[2*n];
        Arrays.fill(new_table,'.');

        fill_table(0,new_table,0);

        return ans_list;
    }

    public void fill_table(int pos,char[] table,int th) {
        if(th==n){
            ans_list.add(to_list_Str(table));
            return;
        }

        //this place, you only have to go through the next line!!!
        //don't go through to the end, because if you can't place a Q in this line,
        //it is bound to fail to meet the demand.
        for(int i=pos;i<pos+n;i++) {
            int ii=i/n;
            int jj=i%n;
            if (row[ii]||line[jj]||right[ii+jj]||left[n-1-ii+jj]) continue;
            //else
            table[i] = 'Q';
            row[ii]=line[jj]=right[ii+jj]=left[n-1-ii+jj]=true;
            //don't consider places in this line,
            //just begin with next line.
            fill_table((ii+1)*n, table, th + 1);
            row[ii]=line[jj]=right[ii+jj]=left[n-1-ii+jj]=false;
            table[i] = '.';
        }

    }


    public List<String> to_list_Str(char[] table) {

        List<String> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            StringBuilder builder=new StringBuilder();
            for(int j=0;j<n;j++){
                builder.append(table[i*n+j]);
            }
            ans.add(builder.toString());
        }
        return ans;
    }
}


//线性
//class Solution51 {
//    List<List<String>> ans_list=new ArrayList<>();
//    public List<List<String>> solveNQueens(int n) {
//        char[] new_table=new char[n*n];
//        boolean[] avail=new boolean[n*n];
//        Arrays.fill(new_table,'.');
//        fill_table(0,new_table,avail,0);
//        return ans_list;
//    }
//
//    public void fill_table(int pos,char[] table,boolean[] occupied,int th) {
//        int n=(int)Math.sqrt(occupied.length);
//        if(th==n){
//            ans_list.add(to_list_Str(table));
//            return;
//        }
//        for(int i=pos;i<table.length;i++) {
//            if (occupied[i]) continue;
//            //else
//            char[] filled = Arrays.copyOf(table,table.length);
//            boolean[] available=change_available(occupied, i);
//            filled[i] = 'Q';
//            fill_table(i+1, filled, available, th + 1);
//        }
//
//    }
//
//    boolean[]  change_available(boolean[] occupied,int pos){
//        int n=(int)Math.sqrt(occupied.length);
//        int ii=pos/n;
//        int jj=pos%n;
//        boolean[] new_occupied=Arrays.copyOf(occupied,occupied.length);
//        int[][] moves =new int[][]{{1,1},{1,-1},{-1,1},{-1,-1},{-1,0},{0,-1},{1,0},{0,1}};
//        for(int[] move:moves){
//            int i=ii;
//            int j=jj;
//            while (i>=0 && i<n && j>=0 && j<n){
//                new_occupied[i*n+j]=true;
//                i+=move[0];
//                j+=move[1];
//            }
//        }
//        return new_occupied;
//    }
//
//
//    public List<String> to_list_Str(char[] table) {
//        int n=(int)Math.sqrt(table.length);
//        List<String> ans=new ArrayList<>();
//        for(int i=0;i<n;i++){
//            StringBuilder builder=new StringBuilder();
//            for(int j=0;j<n;j++){
//                builder.append(table[i*n+j]);
//            }
//            ans.add(builder.toString());
//        }
//        return ans;
//    }
//}

//i, j
//public class t51 {
//    public static void main(String[] args){
//        Solution51 solution=new Solution51();
//        int[] a=new int[]{3,4,-1,1};
//        List<List<String>> ans_list=solution.solveNQueens(5);
//
//        for(List<String> list:ans_list){
//            System.out.println(Arrays.toString(list.toArray()));
//            System.out.println();
//        }
//
//    }
//}
//
//class Solution51 {
//    List<List<String>> ans_list=new ArrayList<>();
//    public List<List<String>> solveNQueens(int n) {
//        char[][] new_table=new char[n][n];
//        for(char[] chars:new_table){
//            Arrays.fill(chars,'.');
//        }
//        fill_table(0,0,new_table,new boolean[n][n],0);
//        return ans_list;
//    }
//
//    public void fill_table(int ii,int jj,char[][] table,boolean[][] occupied,int th) {
//        if(th==table.length){
//            ans_list.add(to_list_Str(table));
//            return;
//        }
//        for(int i=ii;i<table.length;i++){
//            for(int j=0;j<table.length;j++){
//                if(i==ii && j<jj)continue;
//                if(occupied[i][j])continue;
//                //else
//                char[][] fill_i_j=copy_table(table);
//                fill_i_j[i][j]='Q';
//                fill_table(i,j,fill_i_j,change_available(occupied,i,j),th+1);
//            }
//        }
//
//    }
//
//    boolean[][]  change_available(boolean[][] occupied,int ii,int jj){
//        boolean[][] new_occupied=new boolean[occupied.length][occupied.length];
//        for(int i=0;i<occupied.length;i++){
//            System.arraycopy(occupied[i], 0, new_occupied[i], 0, occupied.length);
//        }
//
//        for(int i=0;i<occupied.length;i++){
//            new_occupied[ii][i]=true;
//            new_occupied[i][jj]=true;
//        }
//        int[][] moves =new int[][]{{1,1},{1,-1},{-1,1},{-1,-1}};
//        for(int[] move:moves){
//            int i=ii;
//            int j=jj;
//            while (i>=0 && i<occupied.length && j>=0 && j<occupied.length){
//                new_occupied[i][j]=true;
//                i+=move[0];
//                j+=move[1];
//            }
//        }
//        return new_occupied;
//    }
//
//
//    char[][] copy_table(char[][] table){
//        char[][] copied=new char[table.length][table.length];
//        for(int i=0;i<table.length;i++){
//            System.arraycopy(table[i], 0, copied[i], 0, table.length);
//        }
//        return copied;
//    }
//
//    public List<String> to_list_Str(char[][] table) {
//        List<String> ans=new ArrayList<>();
//        for(char[] chars:table){
//            ans.add(String.valueOf(chars));
//        }
//        return ans;
//    }
//}