import javax.security.auth.login.CredentialException;

public class T91 {
    public static void main(String[] args){
        Solution91 solution=new Solution91();
//"12"
//"123123213213213"
//"1234541234413512012328820"
        System.out.println(solution.numDecodings3("103458720346344262"));

    }
}

class Solution91 {



    /**
     * 统一解法
     * @author   fanyanpeng
     * @date 2022/10/21 15:54
     * @param s
     * @return int
     */
    public int numDecodings3(String s) {
        char[] chars =s.toCharArray();
        int[] ans=new int[s.length()+1];
        ans[0]=1;
        if(chars[0]=='0'){
            return 0;
        }
        for(int i=0;i<s.length();i++){
            if(chars[i]!='0'){
                ans[i+1]+=ans[i];
            }

            if(i>=1 && chars[i-1] != '0' && (chars[i-1]-'0')*10 + (chars[i]-'0') <= 26){
                ans[i+1]+=ans[i-1];
            }
        }
        return ans[ans.length-1];
    }


    public int numDecodings2(String s) {
        char[] chars =s.toCharArray();
        int[] ans=new int[s.length()];
        if(chars[0]=='0'){
            return 0;
        }
        ans[0]=1;



        if(s.length()>1){
            int two = (chars[0]-'0')*10 + (chars[1]-'0');
            if(two%10==0){
                if(two/10==1||two/10==2){
                    ans[1]=1;
                }else {
                    return 0;
                }
            }
            else if(two>26){
                ans[1]=1;
            }
            else {
                ans[1]=2;
            }
        }

        for(int i=2;i<s.length();i++){
            int one = chars[i]-'0';
            int two = (chars[i-1]-'0')*10 + (chars[i]-'0');

            if(two%10==0){
                if(two/10==1||two/10==2){
                     ans[i]=ans[i-2];
                }else {
                    return 0;
                }
            }
            else if(two>27){
                ans[i]=ans[i-1];
            }
            else if(two<10){
                ans[i]=ans[i-1];
            }
            else {
                ans[i]=ans[i-1]+ans[i-2];
            }
        }
        return ans[ans.length-1];
    }


    /**
     * 超时解法：复杂度2^n
     * @author   fanyanpeng
     * @date 2022/10/21 4:02
     * @param null
     * @return
     */
    int ans=0;
    public int numDecodings(String s) {
        char[] chars =s.toCharArray();
        dfs(0,chars);
        return ans;
    }

    void dfs(int pos,char[] chars){
        if(pos == chars.length){
            ans++;
            return;
        }
        int cur = chars[pos]-'0';
        if(cur>=1 && cur<=9){
            dfs(pos+1,chars);
        }
        if(pos< chars.length-1){
            int next = 10 * (chars[pos]-'0') +chars[pos+1]-'0';
            if(next<=26 && next>=10){
                dfs(pos+2,chars);
            }
        }
    }
}