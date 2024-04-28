import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        
        Arrays.sort(d);
        
        int answer = 0;
        for(int i=0; i<d.length; i++){
            if(0<=budget-d[i]) {
                budget-=d[i];
                answer++;
            }
            
            else break;
        }
        
        
        return answer;
    }
}