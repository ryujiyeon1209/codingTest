import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        Stack<Integer> stack = new Stack();
        for(int i=0; i<arr.length; i++){
            if(stack.isEmpty() || stack.peek()!=arr[i]) stack.add(arr[i]);
        }
        
        int[] answer = new int[stack.size()];
        for(int i=answer.length-1; 0<=i; i--){
            answer[i] = stack.pop();
        }
        
        return answer;
    }
}