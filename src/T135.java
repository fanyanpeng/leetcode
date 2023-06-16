import java.util.ArrayList;
import java.util.List;

public class T135 {
    public static void main(String[] args){
        Solution135 solution=new Solution135();

        int[] candy=new int[]{2,1,3,2,1};
        System.out.println(solution.candy(candy));

    }
}

class Solution135 {

    int[] ratings;
    int[] candies;
    public int candy(int[] ratings) {
        this.ratings=ratings;
        this.candies=new int[ratings.length];
        int sum=0;
        for(int i=0;i< ratings.length;i++){
            sum+=getCandy(i);
        }
        return sum;
    }

    int getCandy(int pos){
        if(candies[pos]!=0){
            return candies[pos];
        }
        int candy = 1;


        if(pos-1>=0 && ratings[pos-1]<ratings[pos]){
            candy = Math.max(candy, getCandy(pos-1)+1);
        }
        if(pos+1< ratings.length && ratings[pos+1]<ratings[pos]){
            candy = Math.max(candy, getCandy(pos+1)+1);
        }
        candies[pos] = candy;
        return candy;
    }

    public int candy1(int[] ratings) {
        int[] arr=new int[ratings.length];
        arr[0]=1;
        for(int i=1;i< arr.length;i++){
            if(ratings[i]>ratings[i-1]){
                arr[i]=arr[i-1]+1;
            }
            else {
                arr[i]=1;
            }
        }

        for(int i= ratings.length-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]){
                arr[i]=Math.max(arr[i+1]+1,arr[i]);
            }
        }
        int sum=0;
        for(int i=0;i< ratings.length;i++){
            sum+=arr[i];
        }

        return sum;
    }
}