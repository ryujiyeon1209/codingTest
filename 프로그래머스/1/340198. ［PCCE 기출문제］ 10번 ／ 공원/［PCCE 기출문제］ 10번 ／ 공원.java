import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        int answer = -1;
        
        //dp
        int[][] dp = new int[park.length][park[0].length];
        
        for(int i=0; i<park.length; i++){
            for(int j=0; j<park[i].length; j++){
                if(!park[i][j].equals("-1")) continue;
                
                if(1<=i && 1<=j)
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1])+1;
                else 
                    dp[i][j] = 1;
            }
        }
        
        
        //가장 긴 한 변의 길이 찾기
        int max = -1;
        for(int i=1; i<park.length; i++){
            for(int j=1; j<park[i].length; j++){
                if(max<dp[i][j]) max=dp[i][j];
            }
        }
        
        //깔 수 있는 돗자리 크기 중 가장 큰 것 고르기
        Arrays.sort(mats);
        
        for(int i=mats.length-1; 0<=i; i--){
            if(mats[i]<=max) {
                answer = mats[i];
                break;
            }
        }
        
        return answer;
    }
}