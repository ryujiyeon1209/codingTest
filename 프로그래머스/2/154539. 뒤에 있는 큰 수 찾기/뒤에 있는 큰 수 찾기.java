import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);
        
        //stack에는 값이 아닌 idx를 저장
        Stack<Integer> stack = new Stack();
        stack.add(0);
        
        for(int i=1; i<numbers.length; i++){
            
            //stack에 저장된 idx와 number의 idx의 값을 비교
            while(!stack.isEmpty() && numbers[stack.peek()]<numbers[i]) {
                answer[stack.pop()] = numbers[i];
            } 
            
            stack.push(i);
        }
        
        return answer;
    }
}