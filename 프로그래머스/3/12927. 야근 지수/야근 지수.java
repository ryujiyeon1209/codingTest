import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        //정렬
        Arrays.sort(works);
        
        //작업량이 가장 많은 것부터 야근하기
        PriorityQueue<Integer> queue = new PriorityQueue(Collections.reverseOrder());
        for(int i=works.length-1; 0<=i; i--){
            queue.add(works[i]);
        }

        //크기가 1일 때
        while(1==works.length && 0<n) {
            queue.add(queue.poll()-1);
            n--; 
        }
        
        //크기가 1보다 클 때
        while(1<works.length && 0<n) {
            
            int amount = queue.poll();

            while(0<n && queue.peek()<=amount) {      
                amount--;
                n--; 
            }
            
            queue.add(amount);
        }

        
        //야근 지수 계산하기
        while(!queue.isEmpty()) {
            int num = queue.poll();
            if(num<0) num=0;

            answer+=(num*num);
        }
        
        return answer;
    }
}