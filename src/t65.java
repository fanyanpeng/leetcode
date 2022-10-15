import java.util.regex.Pattern;

public class t65 {
    public static void main(String[] args){
        Solution65 solution=new Solution65();

        String s="1e";
       // System.out.println(solution.isNumber("0.."));
        System.out.println(solution.isNumber("+.8"));
        System.out.println(solution.isNumber("-0.1"));
        System.out.println(solution.isNumber( "-90E3"));
        System.out.println(solution.isNumber("abc"));
        System.out.println(solution.isNumber("99e2.5"));
        System.out.println(solution.isNumber("-+3"));

    }
}

class Solution65 {

    public boolean isNumber(String s) {
        if(s.toLowerCase().contains("e")){
            int index=s.toLowerCase().indexOf("e");
            String part1=s.substring(0,index);
            String part2=s.substring(index+1);

            return isNumber(part1) && is_int(part2);
        }
        return is_int(s)||is_point(s);
    }


    boolean is_point(String s){


        if(s.startsWith("+")||s.startsWith("-")){
            s=s.substring(1);
        }
        int index=s.indexOf('.');
        if(index<0)return false;
        String s1=s.substring(0,index);
        String s2=s.substring(index+1);

        return numberic(s1) && numberic(s2)
                || numberic(s1) && s2.length() == 0
                || s1.length() == 0 && numberic(s2);
    }

    boolean is_int(String s){
        if(s.startsWith("+")||s.startsWith("-")){
            s=s.substring(1);
        }
        return numberic(s);
    }

    boolean numberic(String s){
        if(s.length()<1)return false;
        char[] cs=s.toCharArray();
        for(char c:cs){
            if(!(c<='9'&&c>='0')){
                return false;
            }
        }
        return true;
    }




//    public boolean isNumber(String s) {
//        String INT="([-+]?[0-9]+)";
//        String E = "(([Ee]"+INT+")|)";
//        String POINT1="([-+]?"+"[0-9]+\\.)";
//        String POINT2="([-+]?"+"[0-9]+\\.[0-9]+)";
//        String POINT3="([-+]?"+"\\.[0-9]+)";
//        String POINT="("+POINT1+"|"+POINT2+"|"+POINT3+")";
//
//        //(| |) IS DIFF FROM [ABC]
//        String valid_regex="("+INT+"|"+POINT+")"+E;
//        System.out.println(valid_regex);
//        System.out.println(Pattern.matches(valid_regex,"-25552253.5555222E-555766"));
//        System.out.println(Pattern.matches(valid_regex,"0089"));
//        System.out.println(Pattern.matches(valid_regex,"-0.1"));
//        System.out.println(Pattern.matches(valid_regex,"+3.14"));
//        System.out.println(Pattern.matches(valid_regex,"2e10"));
//        System.out.println(Pattern.matches(valid_regex,"-90e3"));
//        System.out.println(Pattern.matches(valid_regex,"53.5e93"));
//
//        System.out.println(Pattern.matches(valid_regex,"0"));
//        System.out.println(Pattern.matches(valid_regex,"95a54e53"));
//        System.out.println(Pattern.matches(valid_regex,"++3"));
//        return  Pattern.matches(INT,s);
//    }
}
//[([-+]?[0-9]+)[([-+]?[0-9]+.)([-+]?[0-9]+.[0-9]+)([-+]?.[0-9]+)]]([Ee]([-+]?[0-9]+))?

//(([-+]?[0-9]+)|(([-+]?[0-9]+.)|([-+]?[0-9]+.[0-9]+)|([-+]?.[0-9]+)))(([Ee]([-+]?[0-9]+))|)