import java.util.Arrays;

public class t66 {
    public static void main(String[] args){
        Solution66 solution=new Solution66();

        System.out.println(Arrays.toString(solution.plusOne(new int[]{9, 8})));

    }
}

class Solution66 {

    public int[] plusOne(int[] digits) {
        if(Arrays.stream(digits).allMatch(i->i==9)){
            //all is 9
            int[] sum=new int[digits.length+1];
            sum[0]=1;
            return sum;
        }

        //no need to plus a number
        int carry=1;
        for(int i=digits.length-1;i>=0;i--){
            int tmp=digits[i]+carry;
            int left=tmp%10;
            carry=tmp/10;
            digits[i]=left;
        }
        return digits;
    }

}