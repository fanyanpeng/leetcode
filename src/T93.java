import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T93 {
    public static void main(String[] args){
        Solution93 solution=new Solution93();

        List<String> ans = solution.restoreIpAddresses("101023");
        System.out.println(Arrays.toString(ans.toArray()));

    }
}

class Solution93 {

    List<String> ans=new ArrayList<>();
    String s;
    int targetCount =4;
    int byteLength =3;
    /**
     * 复原 IP 地址
     * 数字极其有限，所以使用回溯算法。
     * 存在非数字；取出1位或者2位或者3位，若最终能刚好取完且每一次都满足一下情况，则输出：位数大于2时以0开头；
     * 若剩下位数不可能满足条件就中断：还需要n位，但是剩下位数小于n；还需要n位，但是剩下位数大于3*n，直接返回。
     * @author   fanyanpeng
     * @date 2022/10/23 0:06
     * @param s
     * @return List<String>
     */
    public List<String> restoreIpAddresses(String s) {
        this.s=s;
        for(char c : s.toCharArray()){
            if(c<'0' || c>'9'){
                return ans;
            }
        }
        dfs(0,0,"");
        return ans;

    }

    void dfs(int currentPos,int currentCount,String ip){

        if(currentCount == targetCount && currentPos ==s.length()){
            ans.add(ip);
            return;
        }

        if(currentCount>=targetCount){
            return;
        }

        int neededCount = targetCount -currentCount;
        int leftLength =  s.length() - currentPos;
        if(neededCount>leftLength || neededCount*3<leftLength){
            return;
        }

        for(int i=1;i<=Math.min(byteLength,leftLength);i++){
            String oneByte = s.substring(currentPos,currentPos+i);
            if(i>1 && oneByte.startsWith("0")  ||  Integer.parseInt(oneByte)>255){
                return;
            }
            String newIp = String.valueOf(ip);
            newIp+=oneByte+(currentCount+1<targetCount?".":"");
            dfs(currentPos+i,currentCount+1,newIp);
        }
    }

}