import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class t20 {
    public static void main(String[] args){
        Solution20 solution=new Solution20();
        System.out.println(solution.isValid("[(])"));

    }
}

class Solution20{
    public boolean isValid(String s) {
        Deque<Character> validator=new ArrayDeque<>();
        for(Character c:s.toCharArray()){
            if(c=='{'||c=='['||c=='('){
                validator.push(c);
            }
            //when you use stack, you have to ensure on stack under-flow
            if(validator.size()<1)return false;//detail!
            if(c=='}'){
                if(validator.pop()!='{')return false;
            }
            if(c==']'){
                if(validator.pop()!='[')return false;
            }
            if(c==')'){
                if(validator.pop()!='(')return false;
            }
        }
        //stack should be clean at the end!
        return validator.size()==0;

    }
}