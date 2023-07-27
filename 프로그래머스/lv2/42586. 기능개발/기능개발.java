import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        //배포까지 걸리는 시간
        for(int i=0; i<progresses.length; i++){
            progresses[i] = (int)Math.ceil((100-progresses[i])/(speeds[i]*1.0));
        }
        
        int count=0;    //배포한 작업의 개수
        List<Integer> list = new ArrayList();
        
        //배포까지 남은 시간이 기준 시간보다 적은 작업 개수 list에 넣기
        int tmp=0;
        for(int i=0; i<progresses.length; i++){
            if(progresses[i]<=progresses[count]) tmp++;
            else {
                list.add(tmp);
                count=i;
                tmp=1;
            }
        }
        
        list.add(tmp);  //마지막 요소값 list에 넣기
        
        //리스트 배열로 바꾸기
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i]=list.get(i);
        }
        
        //반환
        return answer;
    }
}