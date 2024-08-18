import java.util.*;

class Solution {
    int solution(int[][] land) {
        int answer = 0;
        
        int n = land.length;
        
        //dp 계산
        int[][] dp = new int[n+1][4];
        for(int i=1; i<dp.length; i++){
            dp[i][0] = land[i-1][0]
                +Math.max(Math.max(dp[i-1][1], dp[i-1][2]), dp[i-1][3]);
            dp[i][1] = land[i-1][1]
                +Math.max(Math.max(dp[i-1][0], dp[i-1][2]), dp[i-1][3]);
            dp[i][2] = land[i-1][2]
                +Math.max(Math.max(dp[i-1][0], dp[i-1][1]), dp[i-1][3]);
            dp[i][3] = land[i-1][3]
                +Math.max(Math.max(dp[i-1][0], dp[i-1][1]), dp[i-1][2]);
        }
        
        //최대값 찾기
        for(int i=0; i<4; i++){
            answer = Math.max(answer, dp[n][i]);
        }
        
        return answer;
    }
}