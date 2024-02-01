import java.util.*;
import java.time.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
         List<Integer> list = new ArrayList();
	        
	        //입차, 출차 기록을 담을 map
	        Map<String, Integer> infoMap = new HashMap();
	        
	        //총 주차시간을 담을 map
	        Map<String, Integer> timeMap = new TreeMap(new Comparator<String>() {
	            public int compare(String o1, String o2) {
	                int into1 = Integer.parseInt(o1);
	                int into2 = Integer.parseInt(o2);
	                return into1-into2;
	            }
	        });
	        
	        
	        int baseTime = fees[0];
	        int basePay = fees[1];
	        int partTime = fees[2];
	        int partPay = fees[3];
	        
	        //차 번호마다 총 주차시간을 분단위로 저장하기 
	        for(String record : records) {
	            String[] info = record.split(" ");
	            
	            int time = changeTime(info[0]);
	            String carNum = info[1]; 
	            String io = info[2];
	            
	            
	            //만약 입차하는 차량이라면,
	            if(io.equals("IN")) infoMap.put(carNum, time);
	            
	            //출차하는 차량이라면,
	            else {
	                int inTime = infoMap.get(carNum);
	                timeMap.put(carNum, timeMap.getOrDefault(carNum, 0)+(time-inTime));
	                
	                
	                infoMap.remove(carNum);
	            }
	        }
	        
	        //입차를 했지만, 출차를 하지 않은 경우
	        Set<String> set = infoMap.keySet();
	        for(String carNum : set) {
	            int lastTime = changeTime("23:59");
	            int inTime = infoMap.get(carNum);
	            
	            if(timeMap.containsKey(carNum)) timeMap.put(carNum, timeMap.get(carNum)+(lastTime-inTime));
	            else timeMap.put(carNum, lastTime-inTime);
	        }
	        
	        
	        //주차비용 계산하기
	        for(String key : timeMap.keySet()){
	            int total = timeMap.get(key);
	            
	            if(total<=baseTime) list.add(basePay);
	            else list.add(basePay+(int)(Math.ceil((total-baseTime)/(partTime*1.0))*partPay));
	        }
	        
	        //list를 배열로 변경
	        int[] answer = new int[list.size()];
	        for(int i=0; i<list.size(); i++){
	            answer[i] = list.get(i);
	        }
	        
	        return answer;
    }
    
    
    //시간을 분 단위로 변경하는 메서드
    public static int changeTime(String time){
        String[] timeArr = time.split(":");
        return  (Integer.parseInt(timeArr[0])*60) + Integer.parseInt(timeArr[1]);
    }
}