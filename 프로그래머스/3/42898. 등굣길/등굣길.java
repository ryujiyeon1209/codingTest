import java.util.*;

class Solution {
    
    static int mod = 1000000007;
    
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        
        //물 웅덩이 좌표 저장
        int[][] dp = new int[n][m];
        for(int i=0; i<puddles.length; i++){
            int c = puddles[i][0]-1;
            int r = puddles[i][1]-1;
            
            dp[r][c]=-1;
        }
        
        //dp
        dp[0][0]=1;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                
                //물 웅덩이를 지나갈 수 없다
                if(dp[i][j]==-1) continue;
                
                //위에서 현재 좌표로 오는 경로 수 
                if(0<=i-1 && dp[i-1][j]!=-1) dp[i][j]+=(dp[i-1][j]%mod);
                
                //왼쪽에서 현재 좌표로 오는 경로의 수
                if(0<=j-1 && dp[i][j-1]!=-1) dp[i][j]+=(dp[i][j-1]%mod);
                
                dp[i][j]%=mod;
            }
        }
        
        answer = dp[n-1][m-1];
        return answer;
    }
}