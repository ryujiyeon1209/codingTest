import java.util.*;

class Solution {
    public int solution(String dartResult) {
        
        char[] result = dartResult.toCharArray();
        
        int score = 0;
        Stack<Integer> stack = new Stack();
        
        for(int i=0; i<result.length; i++){
            //숫자일 경우
            if(Character.isDigit(result[i])) {
                if( result[i]-'0'!=0) score = result[i] - '0';
                else score*=10;
            }
            
            else {
                //S, D, T 경우
                if(result[i]=='S') stack.add((int) Math.pow(score, 1)); 
                else if(result[i]=='D') stack.add((int) Math.pow(score, 2)); 
                else if(result[i]=='T') stack.add((int) Math.pow(score, 3)); 
                score = 0;
                
                //* 경우
                if(result[i]=='*') {
                    int tmp1 = 0; int tmp2 = 0;
                    
                    if(!stack.isEmpty()) tmp1 = stack.pop()*2;
                    if(!stack.isEmpty()) tmp2 = stack.pop()*2;
                    
                    if(tmp2!=0) stack.add(tmp2);
                    if(tmp1!=0) stack.add(tmp1);
                }
                
                //# 경우
                else if(result[i]=='#'){
                    int tmp = 0;
                    if(!stack.isEmpty()) tmp = stack.pop();
                    stack.add(tmp*-1);
                }
            }
        }
        
        int answer = 0;
        while(!stack.isEmpty()){
            answer+=stack.pop();    
        }
        
        return answer;
    }
}