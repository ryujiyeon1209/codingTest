import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        int n = 0;
        while(n<s.length()) {
            
            Stack<Character> stack = new Stack();
            
            boolean flag =true;
            for(int i=0; i<s.length(); i++){
                char ch = s.charAt((i+n)%s.length());
                
                if(ch=='(') stack.push('(');
                else if(ch==')' && !stack.isEmpty() && stack.peek()=='(') stack.pop();
                
                else if(ch=='[') stack.push('[');
                else if(ch==']' && !stack.isEmpty() && stack.peek()=='[') stack.pop();
                
                else if(ch=='{') stack.push('{');
                else if(ch=='}' && !stack.isEmpty() && stack.peek()=='{') stack.pop();
                
                else { flag=false; break; }
                  
            }
           
            if(!stack.isEmpty()) flag=false;
            if(flag) answer++;
    
            n++;
        }
        
        return answer;
    }
}