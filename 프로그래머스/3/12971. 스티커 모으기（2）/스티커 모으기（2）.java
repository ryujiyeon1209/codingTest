import java.util.*;

class Solution {
    public int solution(int sticker[]) {

        //첫번째 스티커를 선택할 경우
        int[][] dp = new int[4][sticker.length];
        dp[0][0] = sticker[0];
        dp[2][0] = sticker[0];
        dp[3][0] = sticker[0];
        
        //dp
        for(int i=1; i<sticker.length-1; i++){
            dp[0][i] = dp[1][i-1]+sticker[i];               //현재 스티커 선택(O)
            dp[1][i] = dp[3][i-1];                         //현재 스티커 선택하지 않음(X)
            if(0<=i-3) dp[2][i] = dp[3][i-3]+sticker[i];   //현재 스티커 선택(XXO)
            
            dp[3][i] = Math.max(Math.max(dp[0][i], dp[1][i]), dp[2][i]);
        }
        
        //최대값 찾기
        int answer = 0;
        for(int i=0; i<dp[3].length; i++){
            answer = Math.max(answer, dp[3][i]);
        }
        
        //첫번째 스티커를 선택하지 않았을 경우
        dp = new int[4][sticker.length];
        
        //dp
        for(int i=1; i<sticker.length; i++){
            dp[0][i] = dp[1][i-1]+sticker[i];               //현재 스티커 선택(O)
            dp[1][i] = dp[3][i-1];                         //현재 스티커 선택하지 않음(X)
            if(0<=i-3) dp[2][i] = dp[3][i-3]+sticker[i];   //현재 스티커 선택(XXO)
            
            dp[3][i] = Math.max(Math.max(dp[0][i], dp[1][i]), dp[2][i]);
        }
        
        //최대값 찾기
        for(int i=0; i<dp[3].length; i++){
            answer = Math.max(answer, dp[3][i]);
        }
        return answer;
    }
}

// for(int i=0; i<dp.length; i++){
//     System.out.println(Arrays.toString(dp[i]));
// }