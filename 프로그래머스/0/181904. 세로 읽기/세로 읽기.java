import java.util.*;

class Solution {
    public String solution(String my_string, int m, int c) {
        String answer = "";
        
        String[] strArr = new String[my_string.length()/m];
        for(int i=0; i<strArr.length; i++){
            strArr[i] = my_string.substring(m*i, (i*m)+m);
            
            answer+=strArr[i].substring(c-1, c);
        }
        
        return answer;
    }
}