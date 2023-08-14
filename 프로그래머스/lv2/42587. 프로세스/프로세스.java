import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        
        //우선순위를 담은 큐
        Queue<int[]> queue = new LinkedList();  
        for(int i=0; i<priorities.length; i++){
            if(i==location) {
                queue.add(new int[] {priorities[i], 1});
            } else {
                queue.add(new int[] {priorities[i], 0});
            }
        }
        
        
        //우선순위를 확인할 큐
        PriorityQueue<Integer> priQueue = new PriorityQueue(Collections.reverseOrder());
        for(int i=0; i<priorities.length; i++){
            priQueue.add(priorities[i]);
        }
        
        
        int count=0;
        while(!queue.isEmpty()){
            
            int[] curr = queue.poll();
            int num = curr[0];
            int islocation = curr[1];
            
            int priority = priQueue.poll();
            
            if(num==priority) {
                count++;
                if(islocation==1) break;
            } else {
                queue.add(curr);
                priQueue.add(priority);
            }           
        }
        
        int answer = count;
        return answer;
    }
}