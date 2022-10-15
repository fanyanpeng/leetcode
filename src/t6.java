import java.util.ArrayList;

public class t6 {
    public static void main(String[] args){
        String s="PAYPALISHIRING";
        int num=2;
        System.out.print(Solution6.convert(s,num));
    }
}


class Solution6 {
    public static String convert(String s, int numRows) {
        if(numRows==1){
            return s;
        }
        ArrayList<ArrayList<Character>> ditribution=new ArrayList<>();
        for(int i=0;i<numRows;i++){
            ditribution.add(new ArrayList<Character>());
        }
        int len=s.length();
        int line=0;
        boolean down=true;
        for(int i=0;i<len;i++){
            ditribution.get(line).add(s.charAt(i));
            if(down){
                line++;
            }
            else {
                line--;
            }
            if(line==numRows-1){
                down=false;
            }
            if(line==0){
                down=true;
            }
        }
        StringBuilder ans= new StringBuilder();
        for(ArrayList<Character> arrayList:ditribution){
            for(Character c:arrayList){
                ans.append(c);
                //System.out.print(c);
            }
        }
    return ans.toString();
    }
}