import java.util.*;

class Solution {
    public int solution(int temperature, int t1, int t2, int a, int b, int[] onboard) {
        
        //온도를 0-50 사이로 만들기
        t1+=10;
        t2+=10;
        temperature+=10;
        
        //현재 시간 i에 현재 온도 j가 되기까지의 최소 값 저장 배열 
        int[][] dp = new int[onboard.length][51];
        
        //최대 전력값으로 초기화
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[i].length; j++){
                dp[i][j]=100*dp.length;
            }
        }
        
        //0초에 실외온도의 전력 최소값은 0이다
        dp[0][temperature]=0;
        
        //dp
        for(int i=0; i<dp.length-1; i++){
            for(int j=0; j<dp[i].length; j++){
                
                //현재 손님이 왔는데, 현재 온도가 적정온도 구간이 아니라면 넘어가기
                if(onboard[i]==1 && (j<t1 || t2<j)) continue;
                
                //에어컨을 끌 경우 최소값 저장
                if(j<temperature) dp[i+1][j+1]=Math.min(dp[i][j], dp[i+1][j+1]);        
                else if(temperature<j) dp[i+1][j-1]=Math.min(dp[i][j], dp[i+1][j-1]);
                else dp[i+1][j]=Math.min(dp[i][j], dp[i+1][j]);
            
                //에어컨을 켜서 온도를 변경할 경우 최소값 저장
                if(j+1<dp[i].length) dp[i+1][j+1]=Math.min(dp[i][j]+a, dp[i+1][j+1]);  
                if(0<=j-1) dp[i+1][j-1]=Math.min(dp[i][j]+a, dp[i+1][j-1]);             
                
                //에어컨을 켜서 온도를 유지할 경우 최소값 저장
                dp[i+1][j] = Math.min(dp[i][j]+b, dp[i+1][j]); 
            }
        }
        
        //최소값 찾기
        int answer = Integer.MAX_VALUE;
        for(int i=0; i<dp[0].length; i++){
            if(onboard[onboard.length-1]==1 &&  (i<t1 || t2<i)) continue;
            else answer = Math.min(answer, dp[onboard.length-1][i]);
        }

        return answer;
    }
}