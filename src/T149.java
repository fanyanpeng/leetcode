

public class T149 {
    public static void main(String[] args){
        Solution149 solution=new Solution149();

        System.out.println(solution);

    }
}

class Solution149 {


    // 最大共线：直接的思路是，遍历每两个点，可以获得9W条线，然后计算其他点到该直线的距离
    // obviously, this is not going to work, because float is not real number
    // so if you could find a way to judge on the same line, then we could get it done
    // if three points are in the same line
    // x1,y1  x2,y2  x3,y3
    // (y3-y1)/(x3-x1) = (y3-y2)/(x3-x2)
    // (y3-y1)*(x3-x2) == (y3-y2)*(x3-x1);
    // it's precise!
    public int maxPoints(int[][] points) {
        int pointCount = points.length;
        int max=2;
        for(int i=0;i<pointCount;i++){
            for(int j =0;j<pointCount;j++){
                if(i==j){
                    continue;
                }
                int sameLineCount = 2;
                for(int k=0;k<pointCount;k++){
                    if(k==i || k==j){
                        continue;
                    }
                    if(sameLine(points[i][0],
                            points[i][1],
                            points[j][0],
                            points[j][1],
                            points[k][0],
                            points[k][1])){
                        sameLineCount++;
                    }
                }
                max=Math.max(max,sameLineCount);
            }
        }
        return max;

    }


    private boolean sameLine(int x1,
                             int y1,
                             int x2,
                             int y2,
                             int x3,
                             int y3){
        return (y3-y1)*(x3-x2) == (y3-y2)*(x3-x1);
    }



}