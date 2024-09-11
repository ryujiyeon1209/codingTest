import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList();
        
        int[] need = new int[progresses.length];
        for(int i=0; i<need.length; i++){
            need[i] = (int) Math.ceil((100-progresses[i])/(speeds[i]*1.0));
        }
        
        int count = 1;
        int day = need[0];
        for(int i=1; i<need.length+1; i++){
            if(i==need.length) {
                list.add(count);
            }
            
            else if(need[i]<=day) {
                count++;
            }
            
            else if(day<need[i]) {
                list.add(count);
                day = need[i];
                count=1;
            }
        }
        
        int[] answer = new int[list.size()];
        for(int i=0; i<answer.length; i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}