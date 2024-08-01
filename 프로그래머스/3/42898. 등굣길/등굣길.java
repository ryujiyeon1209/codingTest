import java.util.*;

class Solution {
    
    static int answer;
    static int[][] map, dp;
    
    public int solution(int m, int n, int[][] puddles) {
        
        map = new int[n][m];
        for(int i=0; i<puddles.length; i++){
            map[puddles[i][1]-1][puddles[i][0]-1] = -1;
        }
        
        answer = 0;
        
        //dp
        dp = new int[n][m];
        dp[0][0]=1;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                //물 웅덩이
                if(map[i][j]==-1) continue;  
                
                //위에서 아래로
                if(0<=i-1) dp[i][j]=(dp[i][j]+dp[i-1][j])% 1000000007;    
                
                //왼쪽에서 오른쪽으로
                if(0<=j-1) dp[i][j]=(dp[i][j]+dp[i][j-1])% 1000000007;
                
            }
        }
        
        return dp[n-1][m-1];
    }
    
}