import java.util.Arrays;

public class t67 {
    public static void main(String[] args){
        Solution67 solution=new Solution67();

        System.out.println(solution.addBinary("0","0"));

    }
}

class Solution67 {

    public static String reverse(String s){
        char[] c=s.toCharArray();
        char[] ans=new char[c.length];
        for(int i=0;i<c.length;i++){
            ans[i]=c[c.length-i-1];
        }
        return new String(ans);

    }
    public String addBinary(String a, String b) {

        int len1=a.length();
        int len2=b.length();

        char[] c1=reverse(a).toCharArray();
        char[] c2=reverse(b).toCharArray();

        //注意点1：此处需要多一位，预留进位
        char[] sum=new char[Math.max(len1,len2)+1];
        //注意点3，非常重要！！！默认值为\u0000，最后的去除末尾的0失效
        Arrays.fill(sum,'0');

        int carry=0;
        int i=0;
        //注意2：此处是继续条件，还未遍历完，或者还有一位没有写到数组中去
        while (i<len1 || i<len2 ||carry!=0){
            int bitSum=carry;
            if(i<len1){
                int i1=c1[i]-'0';
                bitSum+=i1;
            }
            if(i<len2){
                int i2=c2[i]-'0';
                bitSum+=i2;
            }

            int remain=bitSum%2;
            carry=bitSum/2;
            sum[i]=remain==1?'1':'0';
            i++;
        }

        String ans=new String(sum);
        System.out.println(ans.length());

        if(ans.endsWith("0")){
            if(ans.length()>1){
                ans=ans.substring(0,ans.length()-1);
            }
        }

        return reverse(ans);
    }

}