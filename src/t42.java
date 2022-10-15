import java.util.Arrays;

public class t42 {
    public static void main(String[] args){
        Solution42 solution=new Solution42();
        int[] a=new int[]{0,1,0,2,1,0,1,0,2,1,2,1};
        System.out.println(solution.trap(a));

    }
}

class Solution42 {

    public int trap(int[] height) {
        int left=0;
        int right=height.length-1;
        int h=0;
        int total=0;

        while (left<right){
            h=Math.max(Math.min(height[left],height[right]),h);
            if(height[left]<height[right]){
                total+=h-height[left];
                left++;
            }
            else{
                total+=h-height[right];
                right--;
            }
        }
        return total;

    }













//    public int trap(int[] height) {


//        int sum=0;
//        int [] water_height=new int[height.length];
//        //System.out.println(Arrays.toString(water_height));
//        int left=0;
//        int right=height.length-1;
//        int left_max=0;
//        int right_max=0;
//        while (left<right){
//            if(height[left]>left_max)left_max=height[left];
//            if(height[right]>right_max)right_max=height[right];
//
//            int h=Math.min(right_max,left_max);
//
//            if(height[left]<=height[right]){//left bound add 1
//                water_height[left]=h;
//                left++;
//            }
//            else {
//                water_height[right]=h;
//                right--;
//            }
//        }
//
//        //System.out.println(Arrays.toString(water_height));
//        for(int i=0;i<height.length;i++){
//            int water=water_height[i]-height[i];
//            if(water<=0)continue;
//            sum+=water;
//        }
//
//        return sum;












//        //idea 2:
//        int sum=0;
//        int [] water_height=new int[height.length];
//        //System.out.println(Arrays.toString(water_height));
//        int left=0;
//        int right=height.length-1;
//        while (left<right){
//            int h=Math.min(height[left],height[right]);
//            for(int i=left;i<right;i++){
//                if(h>water_height[i]){
//                    water_height[i]=h;
//                }
//            }
//            if(height[left]<=height[right]){//left bound add 1
//                left++;
//            }
//            else {
//                right--;
//            }
//        }
//
//        //System.out.println(Arrays.toString(water_height));
//        for(int i=0;i<height.length;i++){
//            int water=water_height[i]-height[i];
//            if(water<=0)continue;
//            sum+=water;
//        }
//
//        return sum;

//        //idea1:
//        int len=height.length;
//        int sum=0;
//        int left=0,right=0;
//        while (left<=len-2){
//            boolean bigger=false;
//            int cur_max=-1;
//            int max_right=-1;
//            for(right = left+1;right<height.length;right++){
//                if(height[right]>=height[left]){
//                    bigger=true;break;
//                }
//                if(height[right]>=cur_max){
//                    cur_max=height[right];
//                    max_right=right;
//                }
//            }
//            if(!bigger){
//                right=max_right;
//            }
//            sum+=fill(height,left,right);
//            left=right;
//        }
//        return sum;

//    }
//
//    int fill(int[] height,int left,int right){
//        int sum=0;
//        int water_height=Math.min(height[left],height[right]);
//        for(int i=left+1;i<right;i++){
//            sum+=water_height-height[i];
//        }
//        return sum;
//    }

}