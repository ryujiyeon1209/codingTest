import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        Stack<Integer> stack = new Stack();
        
        //인형뽑기 게임
        for(int k=0; k<moves.length; k++){
            
            //인형 뽑기
            int i = moves[k]-1;
            for(int j=0; j<board.length; j++){
                if(board[j][i]==0) continue;
                
                stack.add(board[j][i]);
                board[j][i]=0;
                break;
            }
            
            //같은 인형인지 확인
            int last = 0;
            if(!stack.isEmpty()) {
                last = stack.pop();
                
                if(!stack.isEmpty() && last==stack.peek()) { 
                    stack.pop(); 
                    answer+=2; 
                }
                else stack.add(last);
            } 
            
        }
        
        return answer;
    }
}