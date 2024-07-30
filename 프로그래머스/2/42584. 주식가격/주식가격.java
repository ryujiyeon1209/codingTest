import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        Stack<Integer> stack = new Stack();
        for(int i=0; i<prices.length; i++){
            
            //stack이 비었다면
            if(stack.isEmpty()) stack.add(i);
            
            //다음 날에 주식이 올랐다면
            else if(prices[stack.peek()]<=prices[i]) stack.add(i);
            
            //다음 날에 주식이 떨어졌다면
            else if(prices[stack.peek()]>prices[i]) {
                while(!stack.isEmpty() && prices[stack.peek()]>prices[i]) answer[stack.peek()]= i-stack.pop();
                stack.add(i);
            }
        }
        
        int mday = 0;
        if(!stack.isEmpty()) mday=stack.peek();
        while(!stack.isEmpty()) {
            answer[stack.peek()] = mday-stack.pop();
        }
        
        
        return answer;
    }
}