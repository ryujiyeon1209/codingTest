class Solution {
    public int solution(int[][] triangle) {

        int[][] dp = new int[triangle.length][triangle.length];
        
        dp[0][0] = triangle[0][0];
        
        for(int i=1; i<triangle.length; i++){
            for(int j=0; j<triangle.length; j++){
                if(i<j) continue;
                
                dp[i][j]=triangle[i][j];
                
                if(0<=j-1) dp[i][j] += Math.max(dp[i-1][j-1], dp[i-1][j]);
                else dp[i][j] += dp[i-1][j];
            }
        }
        
        int max = 0;
        for(int i=0; i<dp.length; i++){
            if(max<dp[dp.length-1][i]) max=dp[dp.length-1][i];
        }
        
        return max;
    }
}