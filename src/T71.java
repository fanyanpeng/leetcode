import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntFunction;

public class T71 {
    public static void main(String[] args){
        Solution71 solution=new Solution71();

        System.out.println(solution.simplifyPath("/../../a"));

    }
}

class Solution71 {
    public String simplifyPath(String path) {
        String[] ans =new String[1000];
        int pos=-1;
        //分段、筛选、成为数组
        String[] vals= Arrays.stream(path.split("/")).filter(s->s.length()>0).toArray(String[]::new);

        for(String val:vals){
            switch (val){
                    //当前路径
                case ".":
                    break;

                    //上一级路径
                case "..":
                    if(pos!=-1){
                        pos--;
                    }
                    break;

                    //其他路径
                default:
                    ans[++pos]=val;
                    break;
            }
        }
        return getPath(ans,pos);
    }

    //将string数组和偏移量转化为输出值
    private String getPath(String[] vals,int pos){
        //现在偏移量，返回根路径
        if(pos==-1){
            return "/";
        }
        StringBuilder ans= new StringBuilder();
        for(int i=0;i<=pos;i++){
            ans.append("/").append(vals[i]);
        }
        return ans.toString();
    }
}