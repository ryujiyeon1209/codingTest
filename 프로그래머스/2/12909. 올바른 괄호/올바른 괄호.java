import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        char[] charr = s.toCharArray();
        
        Stack<Character> stack = new Stack();
        for(int i=0; i<charr.length; i++){
            if(charr[i]=='(') {
                stack.add('(');
            }
            else if(!stack.isEmpty() && charr[i]==')') {
                stack.pop();
            }
            else if(stack.isEmpty() && charr[i]==')') { 
                answer=false;
                break;
            }
        }
        
        if(stack.size()!=0) answer=false;
        
        return answer;
    }
}