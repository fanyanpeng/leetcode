public class t8 {
    public static void main(String[] args){
        String s="-fgdrg453452346";
        System.out.print(Solution8.myAtoi(s));
    }
}

class Solution8 {
    public static int myAtoi(String s) {
        if(s.length()==0){
            return 0;
        }
        int min=1<<31;
        int max=min-1;

        int start=0,end=0;
        int sign=1;
        for(int i=start;i<s.length();i++){//elimilate blanks;
            if(s.charAt(i)!=' '){
                start=i;
                break;
            }
        }
        if(s.charAt(start)=='-'){
            sign=-1;
            start++;
        }
        else if(s.charAt(start)=='+'){
            start++;
        }

        for(end=start;end<s.length();end++){
            if(!(s.charAt(end)>='0'&&s.charAt(end)<='9')){
                break;
            }
        }

        if(start>=end){//not a number
            return 0;
        }

        String num=s.substring(start,end);
        int ans=0;
        for(int i=0;i<num.length();i++){
            int n=(num.charAt(i)-'0')*sign;
            if(sign>0 && (max-n)/10<ans){
                //too big
                return max;
            }
            if(sign<0 && (min-n)/10>ans){
                //too small
                return min;
            }
            ans=10*ans+n;

        }
        return ans;
    }
}