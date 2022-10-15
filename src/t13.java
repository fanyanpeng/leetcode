import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class t13 {
    public static void main(String[] args){
        Solution13 solution=new Solution13();
        System.out.println(solution.romanToInt("LVIII"));

    }
}

class Solution13{
    public int romanToInt(String s) {
        String[] output=new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] figure=new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};
        int ans=0;
        while (!Objects.equals(s, "")){
            for(int i=0;i<output.length;i++){
                if(s.startsWith(output[i])){
                    ans+=figure[i];
                    s=s.substring(output[i].length());
                    break;
                }
            }
        }
        return ans;
    }


}

