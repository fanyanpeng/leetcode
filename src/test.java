import jdk.nashorn.internal.objects.annotations.Getter;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.*;

public class test {
    public int id;
    static List<Long> time_list=new ArrayList<>(1000);

    public int getId(){
        return 1;
    }
    public static void main(String[] args){
        /*
        1. will .length() delay the time?
        2. will .length delay the time?
        3. how much will it take to calculate 10^9 times?
        4. will additional codes influence the whole time greatly?
         */
        //time_about();
//        ref_about();
        priority_();
    }



    static class struct_a{
        public int index;
        public int value;
        struct_a(int a,int b){
            index=a;
            value=b;
        }
        public int getValue(){
            return value;
        }

    }



    public static void priority_(){
        struct_a structs[]=new struct_a[]{new struct_a(1,1),new struct_a(2,10),new struct_a(3,23),new struct_a(4,-5),new struct_a(5,456),new struct_a(6,-4234)};


        Arrays.sort(structs, new Comparator<struct_a>() {
            @Override
            public int compare(struct_a o1, struct_a o2) {
                return Integer.compare(o1.value, o2.value);
            }
        });

        for(struct_a s:structs){
            System.out.println(s.index+" "+s.value);
        }



        PriorityQueue<struct_a> max =new PriorityQueue<struct_a>((o2, o1) -> Integer.compare(o1.value, o2.value));
//
        max.addAll(Arrays.asList(structs));

        while (!max.isEmpty()){
            System.out.println(max.poll().index);
        }


        System.out.println(Arrays.stream(structs).max((a,b)->a.index-b.value));


    }

    public static void ref_about(){
        BigDecimal bigDecimal=new BigDecimal("123213123124341231231234123314134");
        System.out.println(bigDecimal.divide(bigDecimal));
        String main_s1="12345";
        String main_s2=string_test(main_s1);
    }
    public static String string_test(String s1){
        String s2="12345";
        String s3="123456";
        return s2;
    }


    public static void time_about(){
        //when got the instance, the time stamp has been settled, unchangeable！
        //so we have to access time every time we need it.

        //the first add, ArrayList will resize the List. It takes around 15ms.
        time_list.add(Calendar.getInstance().getTimeInMillis());
        time_list.add(Calendar.getInstance().getTimeInMillis());
        print_time_stamp(Calendar.getInstance().getTimeInMillis(),"get time");


//        for(int i=0;i<1000000000;i++){
//            int j;
//        }
//        print_time_stamp(Calendar.getInstance().getTimeInMillis(),"10^9 times definition");
//
//
//        for(int i=0;i<1000000000;i++){
//            int j= 1+2;
//        }
//        print_time_stamp(Calendar.getInstance().getTimeInMillis(),"10^9 times definition and add and assign");
//
//        for(int i=0;i<1000000000;i++){
//            function1(i);
//        }
//        print_time_stamp(Calendar.getInstance().getTimeInMillis(),"10^9 times empty function call");
//
//
//
//        //read from array
//        int[] array1=new int[1000000];
//        Arrays.fill(array1,10010);
//
//        time_list.add(Calendar.getInstance().getTimeInMillis());
//        for(int i=0;i<1000000;i++){
//            int j=array1[i];
//        }
//        print_time_stamp(Calendar.getInstance().getTimeInMillis(),"10^6 times visit array call");
//
//
//
//
//        time_list.add(Calendar.getInstance().getTimeInMillis());
//        String string1="";
//        for(int i=0;i<10000;i++){
//            string1+="1";
//        }
//        print_time_stamp(Calendar.getInstance().getTimeInMillis(),"10^4 times string +'1'");
//
//
//
//        time_list.add(Calendar.getInstance().getTimeInMillis());
//        StringBuilder string2= new StringBuilder();
//        for(int i=0;i<10000;i++){
//            string2.append("1");
//        }
//        print_time_stamp(Calendar.getInstance().getTimeInMillis(),"10^4 times stringbuilder");
//
//        time_list.add(Calendar.getInstance().getTimeInMillis());
//        String string3="";
//        for(int i=0;i<10000;i++){
//            string3+="1123ceafef";
//        }
//        print_time_stamp(Calendar.getInstance().getTimeInMillis(),"10^4 times string +'1123ceafef'");
//
//        time_list.add(Calendar.getInstance().getTimeInMillis());
//        StringBuilder string4= new StringBuilder();
//        for(int i=0;i<10000;i++){
//            string4.append("1123ceafef");
//        }
//        print_time_stamp(Calendar.getInstance().getTimeInMillis(),"10^4 times stringbuilder append '1123ceafef'");
//
//
//        time_list.add(Calendar.getInstance().getTimeInMillis());
//        for(int i=0;i<10000;i++){
//            String j=string4.toString();
//        }
//        print_time_stamp(Calendar.getInstance().getTimeInMillis(),"10^4 times stringbuilder toString '1123ceafef'*10^4  ");
//
//
//
//        time_list.add(Calendar.getInstance().getTimeInMillis());
//        for(int i=0;i<1000000000;i++){
//            int cislehfhiosbdu=string3.length();
//            int j=cislehfhiosbdu;
//        }
//        print_time_stamp(Calendar.getInstance().getTimeInMillis(),"10^9 times String length() '1123ceafef'*10^4  ");
//
//
//
//        time_list.add(Calendar.getInstance().getTimeInMillis());
//        for(int i=0;i<1000000000;i++){
//            Integer inuksefhlzfnhue= new Integer("2");
//
//        }
//        print_time_stamp(Calendar.getInstance().getTimeInMillis(),"10^9 times new Integer");
//
//
//        time_list.add(Calendar.getInstance().getTimeInMillis());
//        int injlawd=9;
//        for(int i=0;i<1000000000;i++){
//            injlawd=1+2;
//        }
//        print_time_stamp(Calendar.getInstance().getTimeInMillis(),"10^9 times simple add");
//
//        time_list.add(Calendar.getInstance().getTimeInMillis());
//        for(int i=0;i<1000000000;i++){
//            injlawd=178*2;
//        }
//        print_time_stamp(Calendar.getInstance().getTimeInMillis(),"10^9 times simple multiply");
//
//        time_list.add(Calendar.getInstance().getTimeInMillis());
//        for(int i=0;i<1000000000;i++){
//            injlawd=546345234/274;
//        }
//        print_time_stamp(Calendar.getInstance().getTimeInMillis(),"10^9 times simple division");
//
//
//        int[] ints1=new int[1000000];
////        for(int i=0;i<1000000;i++){
////            ints1[i]=100000-i;
////        }
//
//
//        time_list.add(Calendar.getInstance().getTimeInMillis());
//        for(int i=0;i<1000;i++){
//            Arrays.sort(ints1);
//        }
//        print_time_stamp(Calendar.getInstance().getTimeInMillis(),"10^3 times Arrays.sort, 10^6 int");
//
//        time_list.add(Calendar.getInstance().getTimeInMillis());
//        for(int i=0;i<1000;i++){
//            Arrays.fill(ints1,123);
//        }
//        print_time_stamp(Calendar.getInstance().getTimeInMillis(),"10^3 times Arrays.fill, 10^6 int");
//
//
//        time_list.add(Calendar.getInstance().getTimeInMillis());
//        int sum=0;
//        for(int i=0;i<1000;i++){
//            for(int j=0;j<1000000;j++){
//                sum+=j;
//            }
//
//        }
//        print_time_stamp(Calendar.getInstance().getTimeInMillis(),"10^3 times for int i, 10^6 int");
//
//
//        time_list.add(Calendar.getInstance().getTimeInMillis());
//        time_list.add(Calendar.getInstance().getTimeInMillis());
//
//        for(int i = 0; i< 1000; i++){
//            for(int j:ints1){
//                sum+=j;
//            }
//
//        }
//        print_time_stamp(Calendar.getInstance().getTimeInMillis(),"10^3 times for each, 10^6 int");
//
//
//
//
//
//
//
//
//
//
//        time_list.add(Calendar.getInstance().getTimeInMillis());
//
//        for(int i = 0; i< 1000000; i++){
//            String s=String.valueOf(string2);
//
//        }
//        print_time_stamp(Calendar.getInstance().getTimeInMillis(),"10^6 times String.valueof");
//
//
//
//
//
//
//
//
//
//
//
//        time_list.add(Calendar.getInstance().getTimeInMillis());
//
//        for(int i = 0; i< 10000; i++){
//            for(Character C:string1.toCharArray());
//
//        }
//        print_time_stamp(Calendar.getInstance().getTimeInMillis(),"10^4 times toCharArray");
//
//
//
//
//
//        time_list.add(Calendar.getInstance().getTimeInMillis());
//
//        for(int i = 0; i< 100000000; i++){
//            char c= string1.charAt(88);
//
//        }
//        print_time_stamp(Calendar.getInstance().getTimeInMillis(),"10^8 times str.charAt");
//
//
//        char[] csfsef=string1.toCharArray();
//
//        time_list.add(Calendar.getInstance().getTimeInMillis());
//
//        for(int i = 0; i< 100000000; i++){
//            char c= csfsef[88];
//
//        }
//        print_time_stamp(Calendar.getInstance().getTimeInMillis(),"10^8 times char[]");
//
//
//
//        time_list.add(Calendar.getInstance().getTimeInMillis());
//
//        for(int i = 0; i< 1000000000; i++){
//            int iiiiii= sum;
//        }
//        print_time_stamp(Calendar.getInstance().getTimeInMillis(),"10^9 times assign");
//
//
//
//
//        time_list.add(Calendar.getInstance().getTimeInMillis());
//
//        for(int i = 0; i< 1000000000; i++){
//            int iii=string1.length();
//
//        }
//        print_time_stamp(Calendar.getInstance().getTimeInMillis(),"10^9 times string.length(),small string");
//
//
//        time_list.add(Calendar.getInstance().getTimeInMillis());
//
//        for(int i = 0; i< 1000000000; i++){
//            int iii=string3.length();
//
//        }
//        print_time_stamp(Calendar.getInstance().getTimeInMillis(),"10^9 times string.length(),huge string");


        int [] aswv=new int[100000];
        time_list.add(Calendar.getInstance().getTimeInMillis());

        for(int i = 0; i< 100000; i++){
            aswv[i%124]=i;

        }
        print_time_stamp(Calendar.getInstance().getTimeInMillis(),"10^5 times int [] = ?");

        List<Integer> cleoj=new ArrayList<>(100000);
        time_list.add(Calendar.getInstance().getTimeInMillis());

        for(int i = 0; i< 100000; i++){
            cleoj.add(1);

        }
        print_time_stamp(Calendar.getInstance().getTimeInMillis(),"10^5 times list append");



        time_list.add(Calendar.getInstance().getTimeInMillis());

        Arrays.sort(aswv);
        print_time_stamp(Calendar.getInstance().getTimeInMillis(),"10^5 Array.sort");


        time_list.add(Calendar.getInstance().getTimeInMillis());

        Arrays.sort(cleoj.toArray());
        print_time_stamp(Calendar.getInstance().getTimeInMillis(),"10^5 times list append");


    }
    public static void function1(int i){
    }


    public static void print_time_stamp(long now,String s){
        long last_time=time_list.get(time_list.size()-1);
        System.out.println("time spent: "+(now-last_time)+" milliseconds.\t"+s);
        time_list.add(now);
    }







}
