import java.util.*;

class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        
        int[] r = new int[]{-1, 0, 1, 0};
        int[] c = new int[] {0, 1, 0, -1};
        
        for(int i=0; i<4; i++){
            int dr = h+r[i];
            int dc = w+c[i];
            
            if(!(0<=dr && dr<board.length && 0<=dc && dc<board.length)) continue;
            if(board[dr][dc].equals(board[h][w])) answer++;
        }
        
        return answer;
    }
}