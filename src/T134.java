

public class T134 {
    public static void main(String[] args){
        Solution134 solution=new Solution134();
        int[] gas=new int[]{3,55};
        int[] cost=new int[]{4,55};
        System.out.println(solution.canCompleteCircuit1(gas,cost));

    }
}

class Solution134 {


    public int canCompleteCircuit1(int[] gas, int[] cost) {
        int n = gas.length;
        int accumulateGas = 0;
        int[] gain = new int[n];
        int left = -1;
        int right = 0;
        for(int i=0;i<n;i++){
            gain[i]=gas[i]-cost[i];
        }
        while (right<2*n && left<n){
            while (left==-1 && right<2*n && gain[right%n]<0){
                right++;
            }
            while(accumulateGas + gain[right%n] >= 0){
                accumulateGas += gain[right%n];
                if(left==-1){
                    left = right;
                }
                right++;
                if(right-left==n){
                    return left;
                }
            }
            while (accumulateGas+gain[right%n]<0 && left>=0 && left<n){
                accumulateGas-=gain[left++];
                if(left == right){
                    left=-1;
                    break;
                }
            }
        }
        return -1;
    }


    public int canCompleteCircuit(int[] gas, int[] cost) {


        int n = gas.length;

        int accumulateGas = 0;
        int[] gain = new int[n];

        int left = -1;
        int right = 0;
        for(int i=0;i<n;i++){
            gain[i]=gas[i]-cost[i];
            if(gain[i]>=0 &&left == -1){
                left=i;
            }
        }
        if(left==-1){
            return -1;
        }
        accumulateGas+=gain[left];
        int setOutTimes = 1;
        if(n==1){
            return left;
        }
        right=(left+1)%n;
        while (left<n){
            while (accumulateGas + gain[right] >= 0){
                accumulateGas+=gain[right];
                right=(right+1)%n;
                setOutTimes++;
                if(setOutTimes == n){
                    return left;
                }
            }
            while (accumulateGas + gain[right] <0 &&left<n){
                accumulateGas-=gain[left];
                left++;
                setOutTimes--;
                if(left==right){
                    for(int i=left;i<n;i++){
                        if(gain[i]>=0){
                            left = i;
                            accumulateGas=gain[left];
                            right=(left+1)%n;
                            setOutTimes=1;
                            break;
                        }
                    }
                }
            }
        }
        return -1;
    }

}