import java.util.Arrays;

public class t48 {
    public static void main(String[] args){
        Solution48 solution=new Solution48();
        int[][] a=new int[][]{{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        solution.rotate(a);
        for(int[] i:a){
            System.out.println(Arrays.toString(i));
        }
    }
}

class Solution48 {
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        int cell=(int)Math.ceil(n/2.0);
        int floor=(int)Math.floor(n/2.0);
        for(int i=0;i<cell;i++){
            for(int j=0;j<floor;j++){
                int cur=matrix[i][j];
                int ii=i;
                int jj=j;
                for(int k=0;k<4;k++){
                    int[] new_pos=get_next_pos(new int[]{ii,jj},n);
                    ii=new_pos[0];
                    jj=new_pos[1];
                    int temp=matrix[ii][jj];
                    matrix[ii][jj]=cur;
                    cur=temp;
                }
            }
        }
    }
    int[] get_next_pos(int[] index,int n){
        return new int[]{index[1], n -1 - index[0]};
    }
}