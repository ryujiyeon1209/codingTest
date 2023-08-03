import java.util.*;

class Solution {
    public int solution(int[][] triangle) {     
        
        int answer = 0;
      
        for(int i=1; i<triangle.length; i++){
            for(int j=0; j<triangle[i].length; j++){
                int num=0;
                
                if(j==0) num=triangle[i-1][j];          //왼쪽 대각선 값이 없을 경우
                else if(i==j) num=triangle[i-1][j-1];   //위쪽 값이 없을 경우
                else num=Math.max(triangle[i-1][j-1], triangle[i-1][j]);    //모든 값이 있을 경우
                
                triangle[i][j]+=num;
            }
        }
        
        int n = triangle.length-1;
        for(int i=0; i<triangle[n].length; i++){
            if(answer<triangle[n][i]) answer=triangle[n][i];
        }
        
        return answer;
    }
    
    
    
}