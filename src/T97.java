import java.util.HashMap;

public class T97 {
    public static void main(String[] args){
        Solution97 solution=new Solution97();
//"\"bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa\"\n" +
//        "\"babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab\"\n" +
//        "\"babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab\""
        System.out.println(solution.isInterleave("bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa",
                "babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab",
                "babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab"));

    }
}

class Solution97 {




    /**
     * 思路2：先从两边选取前缀相同的，然后下一步必须另外一边，最后刚好完成就算做成功。
     * 超时解法
     * 添加缓存之后81mm通过。
     * @author   fanyanpeng
     * @date 2022/10/24 21:41
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    public boolean isInterleave2(String s1, String s2, String s3){
        if(s1.length()+s2.length()!=s3.length()){
            return false;
        }

        return new_dfs(s1,s2,s3,0,0,0,0);
    }


    HashMap<String,Boolean> stored =new HashMap<>();
    boolean new_dfs(String s1,String s2,String s3,int i1,int i2,int i3,int last){
        String key = i1+"."+i2+"."+i3+"."+last;
        if(stored.containsKey(key)){
            return stored.get(key);
        }
        if(i3==s3.length()){
            return true;
        }
        if(last == 0 || last == 1){ //上一次选取了s1
            for(int i=1;i<=s2.length()-i2;i++){
                if(s2.substring(i2, i2 + i).equals(s3.substring(i3, i3 + i))){
                    if(new_dfs(s1, s2, s3, i1, i2+i, i3+i, 2)){
                        return true;
                    }
                } else {
                    break;
                }
            }
        }
        if(last == 0 || last == 2){ //上一次选取了s2
            for(int i=1;i<=s1.length()-i1;i++){
                if(s1.substring(i1, i1 + i).equals(s3.substring(i3, i3 + i))){
                    if(new_dfs(s1, s2, s3, i1+i, i2, i3+i, 1)){
                        return true;
                    }
                } else {
                    break;
                }
            }
        }

        stored.put(key,false);
        return false;
    }




















    /**
     * 思路一： 直接逻辑，三个指针，只有当三个指针都到各自的长度，才返回正确。
     * 错误的，交错一定是相差一个部分，然后每个部分交错排列。
     * 其实是正确的，交错s1，s2中一定有一个多一个少。
     * 运行时间6ms。
     * @author   fanyanpeng
     * @date 2022/10/24 21:20
     * @param s1
     * @param s2
     * @param s3
     * @return boolean
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length()!=s3.length()){
            return false;
        }

        return dfs(s1,s2,s3,0,0,0);
    }

    boolean dfs(String s1,String s2,String s3,int i1,int i2,int i3){
        if(i3==s3.length()){
            return true;
        }
        String key = i1+"."+i2;
        if(stored.containsKey(key)){
            return stored.get(key);
        }

        char c1 =i1==s1.length()?'0':s1.charAt(i1);
        char c2 =i2==s2.length()?'0':s2.charAt(i2);
        char c3 =s3.charAt(i3);

        if(c3 == c1){
            if(dfs(s1, s2, s3, i1+1, i2, i3+1)){
                return true;
            }
        }
        if(c3 == c2){
            if(dfs(s1, s2, s3, i1, i2+1, i3+1)){
                return true;
            }
        }
        stored.put(key,false);
        return false;
    }
}