import java.util.*;

public class t1363 {
    public static void main(String[] args){
        Solution1363 solution=new Solution1363();

        System.out.println(solution.largestMultipleOfThree(new int[]{0,0}));

    }
}

class Solution1363 {

    public static List<Integer> getBig(List<Integer> list,int n){
        int toAbondon= (list.size()-n)%3;
        list.sort(Comparator.reverseOrder());
        list= list.subList(0, list.size()-toAbondon);
        return list;
    }

    public static List<Integer> dropMin(List<Integer> list){
        if(list.size()==0)return list;

        list.sort(Comparator.reverseOrder());
        list= list.subList(0, list.size()-1);
        return list;
    }

    public String largestMultipleOfThree(int[] digits) {
        String ans="";

        if(Arrays.stream(digits).sum()==0){
            return "0";
        }
        List<Integer> one=new ArrayList<>();
        List<Integer> two=new ArrayList<>();
        List<Integer> zero=new ArrayList<>();


        for(int  i: digits){
            int left=i%3;
            if(left==1){
                one.add(i);
            }
            if(left==2){
                two.add(i);
            }
            if(left==0){
                zero.add(i);
            }
        }

        int oneSize=one.size();
        int twoSize=two.size();


        if(oneSize>twoSize){
            if((oneSize-twoSize)%3==2 && twoSize!=0){
                two=dropMin(two);
            }
            else {
                one=getBig(one,twoSize);
            }


        }
        else if(twoSize>oneSize){
            if((twoSize-oneSize)%3==2&& oneSize!=0){
                one=dropMin(one);
            }
            else {
                two=getBig(two,oneSize);
            }


        }
        oneSize=one.size();
        twoSize=two.size();
        int countAll=oneSize+twoSize+twoSize;
        ArrayList<Integer> allNumbers=new ArrayList<>(countAll);
        allNumbers.addAll(one);
        allNumbers.addAll(two);
        allNumbers.addAll(zero);
        allNumbers.sort(Comparator.reverseOrder());

        StringBuffer buffer=new StringBuffer(countAll);
        for(int i:allNumbers){
            buffer.append(i);
        }
        ans=buffer.toString();

        if(ans.matches("0+")){
            ans="0";
        }
        return ans;


    }

}