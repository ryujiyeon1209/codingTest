import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        //프로세스 queue
        Queue<Integer> process = new LinkedList();
        for(int i=0; i<priorities.length; i++){
            process.add(priorities[i]);
        }
        
        //우선순위 queue
        PriorityQueue<Integer> priority = new PriorityQueue(Collections.reverseOrder());
        for(int i=0; i<priorities.length; i++){
            priority.add(priorities[i]);
        }
        
        //우선순위 확인 queue
        Queue<Integer> num = new LinkedList();
        for(int i=0; i<priorities.length; i++){
            num.add(i);
        }
        
        
        while(true) {
            int p = process.poll();
            int n = num.poll();
            
            //우선순위가 맞다면
            if(p==priority.peek()) {
                //순서가 궁금한 프로세스라면
                if(n==location) {
                    answer=priorities.length-process.size();
                    break;
                }
                //아니라면
                else {
                    priority.poll();
                }
            }
            
            //우선순위가 맞지 않다면
            else if(p!=priority.peek()) {
                process.add(p);
                num.add(n);
            }
        }
        
        return answer;
    }
}