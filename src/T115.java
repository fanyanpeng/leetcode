public class T115 {
    public static void main(String[] args){
        Solution115 solution=new Solution115();

        System.out.println(solution.numDistinct("",""));

    }
}

class Solution115 {

    // s.length=5, t.length=2
    /**
     * - | - | a | b | c | d | e |
     * - | 1 | 1 | 1 | 1 | 1 | 1 |
     * a | 0 | 1 | 1 | 1 | 1 | 1 |
     * e | 0 | 0 | 0 | 0 | 0 | 1 |
     */

    public int numDistinct(String s, String t) {
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();

        int rows=ct.length+1;
        int lines = cs.length+1;
        int[][] a=new int[rows][lines];
        //含有空字符串的数目是1
        for(int j=0;j<lines;j++){
            a[0][j]=1;
        }
        //空字符串含有其他字串的数目是0
        for(int i=1;i<rows;i++){
            a[i][0]=0;
        }

        //若一个字符多个重复，则存在可替换，选当前字符和不选的可能性都允许，求和
        for(int i=1;i<rows;i++){
            for(int j=1;j<lines;j++){
                a[i][j]=a[i][j-1] + (cs[j-1]==ct[i-1]?a[i-1][j-1]:0);
            }
        }
        return a[rows-1][lines-1];
    }

}