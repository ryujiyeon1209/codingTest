import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        
        //현재 대기하고 있는 트럭
        Queue<Integer> wait = new LinkedList();
        for(int i=0; i<truck_weights.length; i++){
            wait.add(truck_weights[i]);
        }
        
        //다리를 건너고 있는 트럭
        Queue<Integer> bridge = new LinkedList();
        
        //시간 계산
        Queue<Integer> time = new LinkedList();
        
        int cweight = weight;
        int ctime = 0;
        int tcount = 0;
        
        while(true) {
            
            //모든 트럭이 다리를 다 지났는지 확인하기
            if(truck_weights.length<=tcount) break;
            
            ctime++;
            
            //트럭이 다리를 지났는지 확인하기
            if(!time.isEmpty() && bridge_length<=ctime-time.peek()) {
                cweight+=bridge.peek();
                bridge.poll();
                time.poll();
                tcount++;
            }
            
            //다리가 트럭 무게를 견딜 수 있다면,
            if(!wait.isEmpty() && 0<=cweight-wait.peek()) {
                cweight-=wait.peek();
                bridge.add(wait.poll());
                time.add(ctime);
            }
        }
        
        
        return ctime;
    }
}