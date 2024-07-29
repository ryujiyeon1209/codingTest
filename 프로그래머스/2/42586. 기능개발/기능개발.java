import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        //각각의 작업이 며칠이 걸리는지 구하기
        Queue<Integer> days = new LinkedList();
        for(int i=0; i<progresses.length; i++){
            days.add((int)Math.ceil((100.0-progresses[i])/speeds[i]));
        }
        
        //작업 진도 비교하기
        Queue<Integer> queue = new LinkedList();
        int count = 1;
        int cur = days.poll();
        
        while(!days.isEmpty()){

            if(days.peek()<=cur) {
                count++;
                days.poll();
            }
            else if(cur<days.peek()) {
                queue.add(count);
                count=1;
                cur=days.poll();
            }
        }
        
        //마지막 남은 작업
        queue.add(count);
        
        //배열에 저장
        int idx=0;
        int[] answer = new int[queue.size()];
        
        while(!queue.isEmpty()){
            answer[idx]=queue.poll();
            idx++;
        }
        
        return answer;
    }
}