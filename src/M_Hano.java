import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

public class M_Hano {


    public static void main(String[] args){


        startHano(20,'a','b');


    }

    static HashMap<Character, ArrayDeque<Integer>>  stacks = new HashMap<>();

    static {
        stacks.put('a',new ArrayDeque<Integer>());
        stacks.put('b',new ArrayDeque<Integer>());
        stacks.put('c',new ArrayDeque<Integer>());
    }
    public static void move(char from,char to){
        int transfer = stacks.get(from).pop();
        stacks.get(to).push(transfer);
        System.out.printf("Move %d from %c to %c.\n", transfer, from, to);
    }


    public static void init(int n,char start){
        for(int i=n;i>=1;i--){
            stacks.get(start).push(i);
        }
    }

    public static void verify(char end){
        while (!stacks.get(end).isEmpty()){
            System.out.println(stacks.get(end).pop());
        }
    }


    public static void startHano(int n, char from, char to){
        init(n,from);
        move(n, from, to);
        verify(to);
    }
    public static void move(int n, char from, char to){
        if(n<1){
            return;
        }
        move(n-1,from,getIdle(from,to));
        move(from,to);
        move(n-1,getIdle(from,to),to);
    }

    public static char getIdle(char c1,char c2){
        char c = 'a' ^ 'b' ^ 'c';
        return (char) (c ^ c1 ^ c2);
    }

}
