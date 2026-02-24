import java.util.*;

class Solution {
    public int solution(String[] strArr) {
        int answer = 0;
        
        int[] count = new int[31];
        for(int i=0; i<strArr.length; i++){
            count[strArr[i].length()]++;
        }
        
        for(int i=0; i<count.length; i++){
            if(answer<count[i]) answer=count[i];
        }
        
        return answer;
    }
}