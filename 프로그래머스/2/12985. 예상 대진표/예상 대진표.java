import java.util.*;

class Solution {
    public int solution(int n, int a, int b) {
        int answer = 1;

        while(true){
            int min = Math.min(a, b);
            if(Math.abs(a-b)==1 && min%2==1) break;
            
            a = (a%2==0) ? a/2 : (a/2)+1;
            b = (b%2==0) ? b/2 : (b/2)+1;
            answer++;
            
          
        }

        return answer;
    }
}