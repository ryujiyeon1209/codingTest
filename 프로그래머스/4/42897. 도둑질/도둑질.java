import java.util.*;

class Solution {
    public long solution(int[] money) {
        long answer = 0;
        
        //첫번째 집 선택
        long[][] dp = new long[4][money.length];
        dp[0][0] = money[0];
        dp[3][0] = money[0];
        
        for(int i=1; i<money.length-1; i++){
            dp[0][i] = dp[1][i-1]+money[i];                 //전의 집X + 현재 집 O
            dp[1][i] = dp[3][i-1];                          //전의 집에서 최대값 + 현재 집 X
            if(0<=i-3) dp[2][i] = dp[3][i-3]+money[i];      //i-3 집에서 최대값 + 현재 집 O
            
            dp[3][i] = Math.max(Math.max(dp[0][i], dp[1][i]), dp[2][i]);    //현재 집까지 탐색했을 때 최대값
        }
        
        
        //최대값 찾기
        for(int i=0; i<dp[3].length; i++){
            answer = Math.max(answer, dp[3][i]);
        }
        
        //첫 번째 집 선택X
        dp = new long[4][money.length];     
        for(int i=1; i<money.length; i++){
            dp[0][i] = dp[1][i-1]+money[i];                 //전의 집X + 현재 집 O
            dp[1][i] = dp[3][i-1];                          //전의 집에서 최대값 + 현재 집 X
            if(0<=i-3) dp[2][i] = dp[3][i-3]+money[i];      //i-3 집에서 최대값 + 현재 집 O
            
            dp[3][i] = Math.max(Math.max(dp[0][i], dp[1][i]), dp[2][i]);    //현재 집까지 탐색했을 때 최대값
        }
        System.out.println();
        
        //최대값 찾기
        for(int i=0; i<dp[3].length; i++){
            answer = Math.max(answer, dp[3][i]);
        }

        return answer;
    }
}

// System.out.println(Arrays.toString(dp[i]));