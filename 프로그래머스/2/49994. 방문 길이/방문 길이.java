import java.util.*;

class Solution {
    public int solution(String dirs) {
        int answer = 0;
        
        //출발지점
        int r = 5;
        int c = 5;      
        
        //위아래양옆
        boolean[][][] isvisited = new boolean[4][11][11];
            
        //명령어 확인
        for(int i=0; i<dirs.length(); i++){
            
            if(dirs.charAt(i)=='U' && 0<=r-1) {
                if(!isvisited[0][r][c] && !isvisited[1][r-1][c]) answer++; 
                isvisited[0][r][c]=true;
                
                r--;
            }
            else if(dirs.charAt(i)=='D' && r+1<11) {                
                if(!isvisited[1][r][c] && !isvisited[0][r+1][c]) answer++;
                isvisited[1][r][c]=true;
                
                r++;
            } 
            else if(dirs.charAt(i)=='R' && c+1<11) {                
                if(!isvisited[2][r][c] && !isvisited[3][r][c+1]) answer++; 
                isvisited[2][r][c]=true;
                
                c++;
            }
            else if(dirs.charAt(i)=='L' && 0<=c-1) {                 
                if(!isvisited[3][r][c] && !isvisited[2][r][c-1]) answer++;
                isvisited[3][r][c]=true;
                
                c--;
            }

        }
        
        return answer;
    }
}