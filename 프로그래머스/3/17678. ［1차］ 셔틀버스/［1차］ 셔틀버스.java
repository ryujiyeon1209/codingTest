import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        
        //시간 정보 queue에 저장
        PriorityQueue<String> queue = new PriorityQueue();
        for(int i=0; i<timetable.length; i++){
            queue.add(timetable[i]);
        }
        
        
        //버스 출발 시간
        String cur = "09:00";
        for(int i=1; i<=n; i++){
            
            //현재 버스시간 계산
            cur = timecheck(cur, i-1, t);
            
            //막차이면서, 콘이 다른 사람보다 더 빠르게 와야 하는 경우
            if(i==n && m<=queue.size()) {  
                
                Stack<String> stack = new Stack();
                
                int max = m;
                String people = queue.peek(); 
                
                while(check(cur, people)) {
                    stack.add(queue.poll());
                    max--;
                    
                    if(queue.isEmpty()) break;
                    else if(max<=0) break;
                    
                    people = queue.peek();
                }
                
                if(stack.size()<m) return cur;
                
                String last = stack.pop();
                return bussafe(last);
            }
            
            //막차이면서, 남아 있는 사람들이 적을 때
            else if(i==n && queue.size()<m) {
                return cur;
            }
            
            //막차가 아니라면 그냥 보내기
            else if(i!=n && m<=queue.size()) {
                int max = m;
                String people = queue.peek(); 
                
                while(check(cur, people)) {
                    queue.poll();
                    max--;
                    
                    if(queue.isEmpty()) break;
                    else if(max<=0) break;
                    
                    people = queue.peek();
                }
            }
            
            //막차가 아니면서, 사람도 적을 때
            else if(i!=n && queue.size()<m) {
                continue;
            }
        }
        
        return answer;
    }
    
    
    //버스보다 먼저와있는지 확인
    public static boolean check(String bus, String people){
        
        String[] bustime = bus.split(":");
        String[] peopletime = people.split(":");

             
        if(Integer.parseInt(peopletime[0])==Integer.parseInt(bustime[0])) 
            return Integer.parseInt(peopletime[1])<=Integer.parseInt(bustime[1]);
        else return Integer.parseInt(peopletime[0])<Integer.parseInt(bustime[0]);
    }
    
    //현재 시간 구하기
    public static String timecheck(String time, int n, int t) {
        String[] bustime = time.split(":");
        
        int cur = (Integer.parseInt(bustime[0])*60)+Integer.parseInt(bustime[1]);
        
        if(n==0) t=0;
        
        int hour = (cur+t)/60;
        int minute = (cur+t)%60;
        
        
        return String.format("%02d:%02d", hour, minute);
    }
    
    //1분 빠르게 도착하기
    public static String bussafe(String time) {
        String[] last = time.split(":");
        
        int corn = (Integer.parseInt(last[0])*60)+Integer.parseInt(last[1])-1;
     
        int hour = (corn)/60;
        int minute = (corn)%60;
        
        return String.format("%02d:%02d", hour, minute);
    }
}