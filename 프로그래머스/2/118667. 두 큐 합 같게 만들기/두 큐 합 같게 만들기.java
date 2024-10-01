import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        
        long sum1 = 0;
        long sum2 = 0;
        
        //queue만들기
        Queue<Long> queue11 = new LinkedList();
        for(int i=0; i<queue1.length; i++){
            queue11.add(Long.valueOf(queue1[i]));
            sum1+=queue1[i];
        }
        
        Queue<Long> queue22 = new LinkedList();
        for(int i=0; i<queue2.length; i++){
            queue22.add(Long.valueOf(queue2[i]));
            sum2+=queue2[i];
        }
        
        //최종 합이 홀수라면 나눌 수 없다
        if((sum1+sum2)%2!=0) return -1;
        
        //중복 막기 위한 set
        Map<String, Integer> map = new HashMap();
        
        //반복문 실행
        boolean flag = false;
        int idx = -1;
        while(!queue11.isEmpty() &&  !queue22.isEmpty()) {
            
            //두 큐의 합이 같다면
            if(sum1==sum2) {
                flag=true;
                break;
            }
            
            //2번의 합이 더 크다면
            else if(sum1<sum2) { 
                answer++;
                
                long num = queue22.poll();
                
                queue11.add(num);
            
                sum1+=num;
                sum2-=num;   
                
                String str = String.valueOf(sum1) +","+ String.valueOf(sum2)
                    +"," +String.valueOf(num);
                
                if(map.containsKey(str) && map.get(str)-idx==1) break;
                else if(map.containsKey(str) ) idx = map.get(str);
                else map.put(str, answer);
            }
            
            //1번의 합이 더 크다면
            else if(sum2<sum1) {
                answer++;
                
                long num = queue11.poll();
 
                queue22.add(num);
                
                sum1-=num;
                sum2+=num;
                
                String str = String.valueOf(sum1) +","+ String.valueOf(sum2)
                    +"," +String.valueOf(num);
                
                if(map.containsKey(str) && map.get(str)-idx==1) break;
                else if(map.containsKey(str)) idx = map.get(str);
                else map.put(str, answer);
            }
        }
        
        if(flag) return answer;
        else return -1;
    }
    
}