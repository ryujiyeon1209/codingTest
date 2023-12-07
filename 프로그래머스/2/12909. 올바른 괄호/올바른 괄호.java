import java.util.*;

class Solution {
    boolean solution(String s) {
        char[] chList = s.toCharArray();
        
        Stack<Character> stack = new Stack();
        for(int i=0; i<chList.length; i++){
            if(chList[i]==')' && !stack.isEmpty()) stack.pop();
            else stack.push(chList[i]);
        }
        
        if(stack.isEmpty()) return true;
        else return false;
    
    }
}