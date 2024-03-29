import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        Stack<Integer> stack = new Stack();
        for(int i=0; i<moves.length; i++){
            int pick = moves[i]-1;
            
            for(int j=0; j<board.length; j++){
                if(board[j][pick]!=0) {                         //인형을 뽑고
                    if(stack.isEmpty() || board[j][pick]!=stack.peek()) {     //같은 인형이 아닐 경우
                        stack.add(board[j][pick]);            
                    }
                    else {                                     //같은 인형일 경우
                        stack.pop();   
                        answer+=2;
                    }   
                    
                    board[j][pick]=0;
                    break;
                }
            }
        }
        
        
        return answer;
    }
}