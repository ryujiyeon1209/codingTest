import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        
        String answer = "";
        
        //참여한 선수 map에 저장
        Map<String, Integer> map = new HashMap();
        for(int i=0; i<participant.length; i++){
            map.put(participant[i], map.getOrDefault(participant[i], 0)+1);
        }
        
        //완주한 선수 map에서 삭제하기
        for(int i=0; i<completion.length; i++){
            map.put(completion[i], map.get(completion[i])-1);            
            if(map.get(completion[i])==0) map.remove(completion[i]);
        }
        
        //map에 마지막 남은 이름 answer에 저장
        for(String name : map.keySet()) {
            answer=name;    
        }
        
        return answer;
    }
}