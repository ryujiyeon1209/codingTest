import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        Stack<Integer> stack = new Stack();
        for(int i=0; i<prices.length; i++){
            
            //전과 비교했을 때 현재 가격이 더 낮다면, 
            while (!stack.isEmpty() && prices[i]<prices[stack.peek()]) {
                answer[stack.peek()] = i-stack.pop();
            }
            
            //낮거나 그 외
            stack.push(i);
        }
        
        int max = 0;
        if(!stack.isEmpty()) max = stack.pop(); 
        while(!stack.isEmpty()) {
            answer[stack.peek()] = max-stack.pop();
        }
        
        return answer;
    }
}  