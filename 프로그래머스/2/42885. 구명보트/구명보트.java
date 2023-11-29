import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        
        int idx=0;
        for(int i=people.length-1; i>=0; i--){
            if(i<idx) break;
            
            if(people[idx]<=limit-people[i]) {
                answer++;
                idx++;
            }
            
            else answer++;
        }

        return answer;
    }
}