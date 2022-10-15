public class T74 {
    public static void main(String[] args){
        Solution74 solution=new Solution74();

        System.out.println(solution);

    }
}

class Solution74 {

    public boolean searchMatrix(int[][] matrix, int target) {
        boolean found=false;
        int rows=matrix.length;
        int columns=matrix[0].length;
        int l=0;
        int r=rows*columns;
        while (l<r){
            int mid=(l+r)/2;
            int val=get(mid,matrix);
            if(val<target){
                l=mid+1;
            }
            if (val > target) {
                r=mid;
            }
            if(val==target){
                found=true;
                break;
            }
        }


        return found;
    }

    int get(int pos,int[][] matrix){
        int columns=matrix[0].length;
        return matrix[pos/columns][pos%columns];
    }

}