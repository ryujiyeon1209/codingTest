import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        
        //닉네임 저장하기
        Map<String, String> map = new HashMap();
        for(int i=0; i<record.length; i++){
            String[] info = record[i].split(" ");
            
            if(info[0].equals("Enter")) map.put(info[1], info[2]);
            else if(info[0].equals("Change")) map.put(info[1], info[2]);
        }
        
        //채팅방 기록하기
        List<String> list = new ArrayList();
        for(int i=0; i<record.length; i++){
            String[] info = record[i].split(" ");
            
            String in = "님이 들어왔습니다.";
            String out = "님이 나갔습니다.";
            
            if(info[0].equals("Enter")) list.add(map.get(info[1])+in);
            else if(info[0].equals("Leave")) list.add(map.get(info[1])+out);
            
        }
        
        //리스트 배열로 변경
        String[] answer = new String[list.size()];
        for(int i=0; i<answer.length; i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}