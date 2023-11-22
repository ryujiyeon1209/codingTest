import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 1;
        
        char[] chList = s.toCharArray();
        Stack<Character> stack = new Stack();
        for(int i=0; i<chList.length; i++){
            if(stack.isEmpty()) stack.push(chList[i]);
            else if(!stack.isEmpty() && chList[i]==stack.peek()) stack.pop();
            else if(!stack.isEmpty() && chList[i]!=stack.peek()) stack.push(chList[i]);
        }
        
        if(!stack.isEmpty()) answer=0;
        return answer;
    }
}