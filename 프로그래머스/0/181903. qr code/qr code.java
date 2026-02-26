import java.util.*;

class Solution {
    public String solution(int q, int r, String code) {
        String answer = "";
        
        int idx = r;
        while(idx<code.length()) {
            answer+=code.substring(idx, idx+1);
            
            idx+=q;
        }
        
        return answer;
    }
}