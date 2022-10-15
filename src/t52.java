import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class t52 {
    public static void main(String[] args){
        Solution52 solution=new Solution52();
        int[] a=new int[]{3,4,-1,1};
        long t1 = Calendar.getInstance().getTimeInMillis();
        int ans=solution.totalNQueens(4);
        long t2 = Calendar.getInstance().getTimeInMillis();

        System.out.println(ans);
        System.out.println(t2-t1);
    }
}

//快速验证能否填表
class Solution52 {
    int count=0;
    //occupied?
    boolean[] row;
    boolean[] line;
    boolean[] right;
    boolean[] left;
    int n;
    public int totalNQueens(int n){
        this.n=n;
        char[] new_table=new char[n*n];
        row=new boolean[n];
        line=new boolean[n];
        right=new boolean[2*n];
        left=new boolean[2*n];
        Arrays.fill(new_table,'.');

        fill_table(0,new_table,0);

        return count;
    }
    public void fill_table(int pos,char[] table,int th) {
        if(th==n){
            count++;
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
}