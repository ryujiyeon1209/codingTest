import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        char[] chList = s.toCharArray();
        
        Queue<Character> queue = new LinkedList();
        for(int i=0; i<s.length(); i++){
            queue.add(chList[i]);
        }
        
        for(int i=0; i<chList.length; i++){
            boolean flag = isCorrect(queue);
            if(flag) answer++;
            
            char ch = queue.poll();
            queue.add(ch);
        }

        
        return answer;
    }
    
    public boolean isCorrect(Queue<Character> queue){
        Stack<Character> stack = new Stack();
            
        Queue<Character> tmpQueue = new LinkedList(queue);
        while(!tmpQueue.isEmpty()){
            char ch = tmpQueue.poll();
            
            if(stack.isEmpty() && !(ch=='(' || ch=='{' || ch=='[')) return false;
            else if(stack.isEmpty() && (ch=='(' || ch=='{' || ch=='[')) stack.push(ch);
                        
            else if((stack.peek()=='(' && ch==')') ||
                    (stack.peek()=='{' && ch=='}') || (stack.peek()=='[' && ch==']')) stack.pop();
            
            else if(stack.peek()=='(' && (ch=='}' || ch==']')) return false;
            else if(stack.peek()=='{' && (ch==')' || ch==']')) return false;
            else if(stack.peek()=='[' && (ch==')' || ch=='}')) return false;
            
            else if(stack.peek()=='(' && (ch== '(' || ch=='{' || ch=='[')) stack.push(ch);
            else if(stack.peek()=='{' && (ch== '(' || ch=='{' || ch=='[')) stack.push(ch);
            else if(stack.peek()=='[' && (ch== '(' || ch=='{' || ch=='[')) stack.push(ch);

        }
        
        if(0<stack.size()) return false;
        return true;
    }
    
    
}