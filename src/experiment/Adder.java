package experiment;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

/**
 * @author fanyanpeng
 * @date 2023/3/26 4:26
 */
public class Adder {

    HashMap<String,String> sh;
    LinkedHashMap<String,String> sh1;
    public static void main(String[] args){

        // redis ttl


        Adder adder=new Adder();


        for (int i=0;i<10;i++){
            String s1 = adder.int2String((int) (Math.random()*500000000),32);
            String s2 = adder.int2String((int) (Math.random()*500000000),32);
            String s_sum = adder.add(s1,s2);

            System.out.println(adder.add(s1,s2));

            int i1 = adder.string2Int(s1);
            int i2 = adder.string2Int(s2);
            int sum = adder.string2Int(s_sum);
            System.out.printf(" expected: %d+%d=%d \n actual: %d+%d=%d\n",i1,i2,i1+i2,i1,i2,sum);
            assert i1+i2==sum;
        }

//        String s1="00101101000000000101010101010101";
//        String s2="00101101000011000101010101010101";
//


    }


    public String int2String(int i,int count){
        StringBuilder stringBuilder=new StringBuilder(count);
        int left=i;

        for (int j=0;j<count;j++){
            stringBuilder.append(left%2);
            left=left/2;
        }
        return stringBuilder.reverse().toString();
    }
    public int string2Int(String s){
        int[] nums=string2IntReversedArray(s);
        int num = 0;
        for(int i=0;i<s.length();i++){
            int bit = nums[i];
            num+=bit<<i;
        }
        return num;
    }

    final int BYTE_COUNT = 8;

    public int[] oneAdder(int i1,int i2){
        int high = i1 & i2;
        int low = i1^i2;
        return new int[]{low,high};
    }

    public int[] oneAdderWithCarry(int i1,int i2,int carry){
        // 计算两数相加
        int[] add1= oneAdder(i1,i2);
        int low = add1[0];
        int high1 = add1[1];
        // 计算低位
        int[] add2 = oneAdder(low,carry);
        int low1 = add2[0];
        int high2 = add2[1];
        // 计算高位
        int[] add3 = oneAdder(high1,high2);
        int high3 = add3[0];
        return new int[]{low1,high3};
    }

    public int[] byteAdder(int[] bits1,int[] bits2,int carry){
        int[] result = new int[bits1.length+1];
        for(int i=0;i<bits1.length;i++){

            int[] add = oneAdderWithCarry(bits1[i],bits2[i],carry);
            result[i]=add[0];
            carry=add[1];
        }
        result[bits1.length]=carry;
        return result;
    }
    public String add(String s1,String s2){
        int[] num1 = string2IntReversedArray(s1);
        int[] num2 = string2IntReversedArray(s2);

        StringBuilder ans= new StringBuilder();
        int bits = num1.length;

        int carry = 0;
        for(int i=0;i<bits;i+=BYTE_COUNT){
            int[] add = byteAdder(Arrays.copyOfRange(num1,i,i+BYTE_COUNT),Arrays.copyOfRange(num2,i,i+8),carry);
            carry = add[BYTE_COUNT];
            ans.append(Arrays.stream(Arrays.copyOfRange(add, 0, BYTE_COUNT)).mapToObj(String::valueOf).collect(Collectors.joining()));
        }
        return ans.reverse().toString();

    }

    public int[] string2IntReversedArray(String s){
        return Arrays.stream(new StringBuilder(s).reverse().toString().split("")).mapToInt(Integer::valueOf).toArray();
    }

}
