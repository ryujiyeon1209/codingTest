import java.util.*;

class Solution {
    
    int MOD = 20170805;
   
    public int solution(int m, int n, int[][] cityMap) {
        int answer = 0;

        //현재 dp[i][j]까지 올 수 있는 최대 경로의 수 (0이라면 아래, 1이라면 오른쪽)
        int[][][] dp = new int[2][m][n];               
        
        //현재 isvisited[i][j]가 가질 수 있는 방향
        boolean[][][] isvisited = new boolean[2][m][n];   
        
        dp[0][0][0]=1;
        
        //처음 시작은 아래, 오른쪽 둘 다 이동 가능하다
        isvisited[0][0][0]=true;    
        isvisited[1][0][0]=true;
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                
                //1이면 자동차 통행이 금지다
                if(cityMap[i][j]==1) continue;

                //위의 좌표 값이 0이라면, 현재 좌표로 이동하는 것이 가능하다
                if(0<=i-1 && cityMap[i-1][j]==0) {
                    isvisited[0][i][j]=true;
                    dp[0][i][j]=(dp[0][i-1][j]+dp[1][i-1][j])%MOD;
                }
                
                //왼쪽 좌표 값이 0이라면, 현재 좌표로 이동하는 것이 가능하다
                if(0<=j-1 && cityMap[i][j-1]==0) {
                    dp[1][i][j]=(dp[0][i][j-1]%MOD+dp[1][i][j-1])%MOD;
                }
                
                //위의 좌표 값이 2일때, 아래로 내려오는 것이 가능한지 확인
                if(0<=i-1 && cityMap[i-1][j]==2) {
                    dp[0][i][j]=(dp[0][i-1][j]%MOD);
                }
                
                //왼쪽 좌표 값이 2일때, 오른쪽으로 이동하는 것이 가능한지 확인
                if(0<=j-1 && cityMap[i][j-1]==2) {
                    dp[1][i][j]=(dp[1][i][j-1]%MOD);
                }
            }
        }

        answer = (dp[0][m-1][n-1] + dp[1][m-1][n-1])%MOD;
        return answer;
    }
    
//     System.out.println("i : " +i+ ", j : " +j+ " > ");
}