import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        
        //요청 시간 오름차순으로 정렬
        Arrays.sort(jobs, new Comparator<int[]>(){
           public int compare(int[] o1, int[] o2) {
               return Integer.compare(o1[0], o2[0]);
           } 
        });

        PriorityQueue<int[]> queue = new PriorityQueue(new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2) {
               return Integer.compare(o1[1], o2[1]);
           } 
        });
        
        int time = 0;       //현재 시간
        int idx = 0;        //현재 시간에 요청된 작업의 인덱스
        int count = 0;      //요청이 끝난 작업 개수
        
        while(count<jobs.length) {
            
            //현재 요청이 끝나기 전에 요청이 들어온 작업 queue에 넣기
            while(idx<jobs.length && jobs[idx][0]<=time) {
                queue.add(jobs[idx++]);
            }
            
            //queue에 없다면 그냥 다음 요청 시작 시간으로 점프
            if(queue.isEmpty()) {
                time = jobs[idx][0];
            }
            
            //현재 시간에 queue에 저장된 요청이 있다면 처리
            else {
                int[] job = queue.poll();
            
                //현재시간
                time+=job[1];
                
                //끝나는 시간-요청 시간
                answer+=(time-job[0]);
                
                count++;
            }
            
           
            
            System.out.println("time : " +time+ " > answer : " +answer);
        }
        
      
        return answer/jobs.length;
    }
}