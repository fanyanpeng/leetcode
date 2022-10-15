import java.util.Arrays;

public class t43 {
    public static void main(String[] args){
        Solution43 solution=new Solution43();
        int[] a=new int[]{3,4,-1,1};
        System.out.println((solution.multiply("11","400")));

    }
}


class Solution43 {

    //简化竖式乘法
    public String multiply(String num1, String num2) {
        int len1=num1.length();
        int len2=num2.length();
        int[] n1=new int[len1];
        int[] n2=new int[len2];
        int[] ans=new int[len1+len2];

        for(int i=len1-1;i>=0;i--){
            n1[len1-i-1]=num1.charAt(i)-'0';
        }
        for(int i=len2-1;i>=0;i--){
            n2[len2-i-1]=num2.charAt(i)-'0';
        }
        //n1 right shift
        //get i-th from n2
        for(int i=0;i<len1;i++){
            for(int j=0;j<len2;j++){
                int multi = n1[i]*n2[j]+ans[i+j];
                ans[i+j]=multi%10;
                ans[i+j+1]+=multi/10;//attention, if you use = , override could happen!
            }
        }
        return to_num_str(ans);


    }

    public String to_num_str(int[] nums){
        boolean in_num=false;
        StringBuilder builder=new StringBuilder();
        for(int i=nums.length-1;i>0;i--){
            if(!in_num && nums[i]!=0){
                in_num=true;
            }
            if(in_num){
                builder.append(nums[i]);
            }
        }
        builder.append(nums[0]);
        return builder.toString();
    }



    //竖式乘法：
//    public String multiply(String num1, String num2) {
//
//        int[] n1=new int[200];
//        int[] n2=new int[200];
//        int[] ans=new int[200];
//        int len1=num1.length();
//        int len2=num2.length();
//
//        for(int i=len1-1;i>=0;i--){
//            n1[len1-i-1]=num1.charAt(i)-'0';
//        }
//        for(int i=len2-1;i>=0;i--){
//            n2[len2-i-1]=num2.charAt(i)-'0';
//        }
//        //n1 right shift
//        //get i-th from n2
//        for(int i=0;i<len2;i++){
//            int[] multi=multi(n1,n2[i],len1);//len<=len1+1
//            int[] shifted=right_shift(multi,i,len1+1);//len<=len+i+1
//            ans=add(ans,shifted,len1+i+1);
//        }
//        return to_num_str(ans);
//
//
//    }
//
//    /*
//     * num1: as a param.
//     * len1 and len2 decide how many steps should be done.
//     *
//     */
//    public int[] add(int [] num1,int [] num2,int len1){
//        int [] ans=new int[len1+1];
//        int carry=0;
//        for(int i = 0; i< len1; i++){
//            int sum=carry+num1[i]+num2[i];
//            carry=sum/10;
//            ans[i]=sum%10;
//        }
//        return ans;
//    }
//
//    public int[] multi(int [] num1,int figure,int len){
//        int [] ans=new int[len+1];
//        int carry=0;
//        for(int i=0;i<=len;i++){
//            int sum=carry+num1[i]*figure;
//            carry=sum/10;
//            ans[i]=sum%10;
//        }
//        return ans;
//    }
//
//    public int[] right_shift(int[] nums,int distance,int len){
//        int[] ans=new int[len+distance+1];
//        for(int i=0;i<len;i++){
//            ans[i+distance]=nums[i];
//        }
//        return ans;
//    }
//    public String to_num_str(int[] nums){
//        boolean in_num=false;
//        StringBuilder builder=new StringBuilder();
//        for(int i=nums.length-1;i>0;i--){
//            if(!in_num && nums[i]!=0){
//                in_num=true;
//            }
//            if(in_num){
//                builder.append(nums[i]);
//            }
//        }
//        builder.append(nums[0]);
//        return builder.toString();
//    }








//    public String multiply(String num1, String num2) {
//
//        int[] n1=new int[500];
//        int[] n2=new int[500];
//        int[] ans=new int[500];
//        int len1=num1.length();
//        int len2=num2.length();
//
//        for(int i=len1-1;i>=0;i--){
//            n1[len1-i-1]=num1.charAt(i)-'0';
//        }
//        for(int i=len2-1;i>=0;i--){
//            n2[len2-i-1]=num2.charAt(i)-'0';
//        }
//        //n1 right shift
//        //get i-th from n2
//        for(int i=0;i<len2;i++){
//            int[] shifted=right_shift(n1,i,len1);
//            for(int j=0;j<n2[i];j++){
//                ans=add(ans,shifted,450,450);
//            }
//        }
//        String str_ans=to_num_str(ans);
//        return str_ans;
//
//
//    }
//
//    /*
//    * num1: as a param.
//    * len1 and len2 decide how many steps should be done.
//    *
//     */
//    public int[] add(int [] num1,int [] num2,int len1,int len2){
//        int [] ans=new int[500];
//        int len=Math.max(len1,len2)+1;
//        int carry=0;
//        for(int i=0;i<len;i++){
//            int sum=carry+num1[i]+num2[i];
//            carry=sum/10;
//            ans[i]=sum%10;
//        }
//        return ans;
//    }
//    public int[] right_shift(int[] nums,int distance,int len){
//        int[] ans=new int[500];
//        for(int i=0;i<len;i++){
//            ans[i+distance]=nums[i];
//        }
//        return ans;
//    }
//    public String to_num_str(int[] nums){
//        boolean in_num=false;
//        StringBuilder builder=new StringBuilder();
//        for(int i=nums.length-1;i>0;i--){
//            if(!in_num && nums[i]!=0){
//                in_num=true;
//            }
//            if(in_num){
//                builder.append(nums[i]);
//            }
//        }
//        builder.append(nums[0]);
//        return builder.toString();
//    }
}