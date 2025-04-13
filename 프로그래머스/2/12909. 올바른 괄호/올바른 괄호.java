import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        int sum = 0;
        for(int i=0; i<s.length(); i++){
            if(sum==0 && s.charAt(i)=='(') sum+=1;
            else if(sum==0 && s.charAt(i)==')') return false;
            
            else if(s.charAt(i)=='(') sum+=1;
            else if(s.charAt(i)==')') sum-=1;
        }
        
        if(sum!=0) return false;

        return answer;
    }
}