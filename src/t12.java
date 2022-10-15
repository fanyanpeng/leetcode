import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class t12 {
    public static void main(String[] args){
        Solution12 solution12=new Solution12();
        System.out.println(solution12.intToRoman(3999));

    }
}

class Solution12{
    Map<Integer,Character> map=new HashMap<>();
    int[] numbers_base=new int[]{1000,100,10,1};
    public String intToRoman(int num) {
        map.put(1,'I');
        map.put(5,'V');
        map.put(10,'X');
        map.put(50,'L');
        map.put(100,'C');
        map.put(500,'D');
        map.put(1000,'M');

        //build numbers;
        String[] output=new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] figure=new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};
//        int index=0;
//        for(int i=0;i<numbers_base.length;i++){
//            figure[index]=numbers_base[i];
//            output[index]=""+map.get(numbers_base[i]);
//            index++;
//            if(numbers_base[i]==1)break;
//            figure[index]=numbers_base[i]-numbers_base[i+1];
//            output[index]=""+map.get(numbers_base[i+1])+map.get(numbers_base[i]);
//            index++;
//            figure[index]=numbers_base[i]/2;
//            output[index]=""+map.get(numbers_base[i]/2);
//            index++;
//            figure[index]=numbers_base[i]/2-numbers_base[i+1];
//            output[index]=""+map.get(numbers_base[i+1])+map.get(numbers_base[i]/2);
//            index++;
//        }




        StringBuilder ans= new StringBuilder();


        while (num!=0){
            for(int i=0;i<figure.length;i++){
                if(num>=figure[i]){
                    ans.append(output[i]);num-=figure[i];break;
                }
            }
        }


        return ans.toString();
    }


}

