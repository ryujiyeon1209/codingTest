import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        
        //우선순위 큐 생성 및 값 넣기
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i=0; i<scoville.length; i++){
            queue.add(scoville[i]);
        }
        
        int count = 0;
        while(true){
            
            //큐에 있는 작은 값이 k보다 크면 반복문 중단
            if(queue.peek()>=K) break;  
            
            //큐에 값이 하나만 있는데 그 값이 k보다 작으면 반복문 중단
            if(queue.size()==1 && queue.peek()<K) {
                count=-1;
                break;
            }
            
            //가장 작은 스코빌 지수와 그 다음 스코빌 지수를 큐에서 꺼내기
            int min = queue.poll();
            int min2 = queue.poll();
            
            //새로운 스코빌지수 만들기
            int newScoville = min + (min2*2);
            queue.add(newScoville);
            
            count++;
        }
        
        
        return count;
    }
}