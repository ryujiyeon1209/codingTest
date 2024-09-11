import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        
        Queue<String> card1 = new LinkedList();
        for(int i=0; i<cards1.length; i++){
            card1.add(cards1[i]);
        }
        
        Queue<String> card2 = new LinkedList();
        for(int i=0; i<cards2.length; i++){
            card2.add(cards2[i]);
        }
        
        int idx = 0;
        while(idx<goal.length) {
            
            boolean flag = false;
            if(!card1.isEmpty() && card1.peek().equals(goal[idx])) {
                flag = true;
                card1.poll();
                idx++;
            }
            
            if(!card2.isEmpty() && card2.peek().equals(goal[idx])) {
                flag = true;
                card2.poll();
                idx++;
            }
            
            if(!flag) {
                answer = "No";
                break;
            }
        }
        
        return answer;
    }
}