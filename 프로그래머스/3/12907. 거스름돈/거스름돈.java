import java.util.*;

class Solution {
    public int solution(int n, int[] money) {

        //dp
        int[] dp = new int[n+1];
        dp[0]=1;
        
        int mod =  1000000007;
        
        //dp
        //j원을 만들기 개수 = dp[j]의 값 + money[i]원을 더해서 j원이 되는 수
        //만약 3원을 만들고, 현재 값이 2원이라면, 1원 만들기 수 + 2원 해야 3원이 된다.
        for(int i=0; i<money.length; i++){
            for(int j=money[i]; j<dp.length; j++){
                dp[j]=(dp[j]+dp[j-money[i]])%mod;
            }
        }
        
        
        int answer = dp[n];
        return answer;
    }
}