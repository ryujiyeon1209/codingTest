import java.util.*;

class Solution {
    public int solution(int n, int a, int b) {
        int answer = 0;

        Queue<Integer> queue = new LinkedList();
        for(int i=0; i<=n; i++){
            queue.add(i);
        }

        //참가자 확인하기
        while(true) {
            
            //한바퀴 다 돌면
            if(queue.peek()==0) {   
                answer++;
                queue.add(queue.poll());
            }
            
            //현재 참자가
            int A = queue.poll();
            int B = queue.poll();
            
            if((A==a || A==b) && (B==a || B==b)) break; //a와 b 둘 다 참가할 때
            else if(A==a || A==b) queue.add(A);         //a만 참가할 때
            else if((B==a || B==b)) queue.add(B);       //b만 참가할 때
            else queue.add(A);                          //a와 b 둘 다 아닐 때
        }
        
        return answer;
    }
}