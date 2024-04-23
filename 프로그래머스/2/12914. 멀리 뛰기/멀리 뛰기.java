import java.util.*;

class Solution {
    public long solution(int n) {
        
        if(n==1) return 1;
        else if(n==2) return 2;
            
        //dp
        long[] dp = new long[n+1];
        dp[1] = 1; dp[2] = 2;
        
        for(int i=3; i<dp.length; i++){
            dp[i] = (dp[i-2]+dp[i-1])%1234567;
        }
        
        long answer = dp[n];
        return answer;
    }
}