import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> list = new ArrayList();
        
        //today 날짜수 구하기
        int cur = changeDay(today);
        
        //유효기간 저장하기
        Map<String, Integer> map = new HashMap();
        for(int i=0; i<terms.length; i++){
            String[] term = terms[i].split(" ");
            
            String type = term[0];
            int possible = Integer.parseInt(term[1])*28;
            
            map.put(type, possible);
        }
        
        //파기해야 하는 문서인지 확인하기
        for(int i=0; i<privacies.length; i++){
            String[] info = privacies[i].split(" ");         
            
            int day = changeDay(info[0]);
            if(day+map.get(info[1])<=cur) {
                list.add(i+1);
            }
        }
        
        //list를 array로 바꾸기
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
    
    
    //1일부터 day까지의 날짜 수 계산하기
    public int changeDay(String changeDay){
        String[] days = changeDay.split("[.]");
        
        int year = Integer.parseInt(days[0]);
        int month = Integer.parseInt(days[1]);
        int day = Integer.parseInt(days[2]);
        
        return (year*12*28)+(month*28)+day;
    }
}