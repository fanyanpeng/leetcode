import java.util.ArrayList;

public class t10 {
    public static void main(String[] args){
        String s="aaaaaaaaaaaa";
        String p="a*b*";
        Solution10 solution10=new Solution10();
        System.out.print(solution10.isMatch(s,p));
    }
}
class  Solution10{

    State[] states=new State[30];
    public boolean isMatch(String s, String p) {
        for(int i=0;i<30;i++){
            states[i]=new State();
            for(int j=0;j<27;j++){
                states[i].tokens[j]=new ArrayList<>();
            }
        }
        build_states(0,p,0);
        return accepted(0,s,0);
    }


    void build_states(int pos,String p,int state){
        if(pos==p.length()){
            states[state].accepted=true;return;
        }
        char c=p.charAt(pos);
        if(pos+1<p.length() && p.charAt(pos+1)=='*'){
            if(c=='.'){
                for(char c1='a';c1<='z';c1++){
                    states[state].get_token(c1).add(state);
                }
            }
            else {
                states[state].get_token(c).add(state);
            }
            pos+=2;
            if(pos==p.length()){
                states[state].accepted=true;return;
            }

        }
        else {
            if(c=='.'){
                for(char c1='a';c1<='z';c1++){
                    states[state].get_token(c1).add(state+1);
                }
            }
            else {
                states[state].get_token(c).add(state+1);
            }
            state+=1;
            pos+=1;
        }

        //next epsilon
        if(pos+1<p.length() && p.charAt(pos+1)=='*'){
            states[state].epsilon=state+1;
            state+=1;
        }
        build_states(pos,p,state);
    }

    boolean is_accepted(int state){
        if(states[state].epsilon!=null){
            return is_accepted(states[state].epsilon);
        }
        return states[state].accepted;
    }

    boolean accepted(int pos,String s,int state){
        if(pos==s.length()){
            return is_accepted(state);
        }
        char c=s.charAt(pos++);
        ArrayList<Integer> jumpable=get_jump_list(state,c);
        for(Integer next_state:jumpable){
            if(accepted(pos,s,next_state)){
                return true;
            }
        }
        return false;
    }

    ArrayList<Integer> get_jump_list(int state,char c){
        ArrayList<Integer> ans = new ArrayList<>(states[state].get_token(c));
        if(states[state].epsilon!=null){
            ans.addAll(get_jump_list(states[state].epsilon,c));
        }
        return ans;
    }


    class State{
        ArrayList<Integer>[] tokens=new ArrayList[27];
        boolean accepted=false;
        Integer epsilon=null;
        State(){

        }
        ArrayList<Integer> get_token(char c){
            return tokens[c-'a'];
        }
    }



}