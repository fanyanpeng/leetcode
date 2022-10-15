import java.util.Arrays;

public class t11 {
    public static void main(String[] args){
        Solution11 solution11=new Solution11();
        int[] height=new int[]{5,6};
        System.out.println(solution11.maxArea(height));
        System.out.println(solution11.get_i_max(new int[]{6,2,3,4,7,321,45,6},2));

    }
}

class Solution11{


    public int maxArea(int[] height) {
        int l=0,r=height.length-1;
        int max_area=0;
        while (l<r){
            int area=(r-l)*Math.min(height[l],height[r]);
            max_area=Math.max(area,max_area);
            if(height[l]>height[r]){
                r--;
            }
            else {
                l++;
            }
        }
        return max_area;
    }

    public int maxArea1(int[] height) {

        int second_max=get_i_max(height,2);

        int max_area=0;
        for(int i=10000;i>0;i--){
            if(i>second_max){
                continue;
            }
            //two index that satisfies the height - i;
            int l_index=-1;
            int r_index=-1;
            int l=height.length;
            for(int j=0;j<l;j++){
                if(height[j]>=i){
                    l_index=j;
                    break;
                }
            }

            for(int j=l-1;j>=0;j--){
                if(height[j]>=i){
                    r_index=j;
                    break;
                }
            }
            if(l_index<r_index){
                int area=i*(r_index-l_index);
                max_area= Math.max(area, max_area);
            }
        }
        return max_area;

    }

    public int get_i_max(int[] height, int th) {//get the i_th max number;
        //插入
        int[] row = new int[th];    //maintain a row with th menber
        Arrays.fill(row, Integer.MIN_VALUE);
        for (int k : height) {
            for (int j = 0; j < th; j++) {
                if (k > row[j]) {
                    if (th - 1 - j >= 0) System.arraycopy(row, j, row, j + 1, th - 1 - j);
                    row[j] = k;
                    break;
                }
            }
        }
        return row[th-1];
    }
}
