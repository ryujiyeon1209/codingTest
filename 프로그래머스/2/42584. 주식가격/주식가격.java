import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        
        int[] answer = new int[prices.length];
        
        //가격 확인
        Stack<Integer> stack = new Stack();
        for(int i=0; i<prices.length; i++){
            while(!stack.isEmpty() && prices[i]<prices[stack.peek()]) {               //가격이 떨어졌을 경우        
                answer[stack.peek()] = i-stack.pop();        
            }
            
            stack.add(i);
        }
        
        //시간 확인
        while(!stack.isEmpty()) {
            int idx = stack.pop();
            answer[idx] = prices.length-idx-1;
        }     
        
        return answer;
    }
}