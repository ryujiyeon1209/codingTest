import java.util.*;

class Solution {
    public int[] solution(String myString) {
        String[] split = myString.split("x", myString.length());
        
        int[] answer = new int[split.length];
        
        for(int i=0; i<split.length; i++){
            answer[i] = split[i].length();
        }
        
        return answer;
    }
}