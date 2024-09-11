import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        Map<String, Integer> map = new HashMap();
        for(int i=0; i<want.length; i++){
            map.put(want[i], number[i]);
        }
        
        //슬라이딩 윈도우
        int count=10;
        for(int i=0; i<10; i++){
            if(map.containsKey(discount[i])) {
                if(0<=map.get(discount[i])-1) count--;
                map.put(discount[i], map.get(discount[i])-1);
            }
        }
        
        if(count==0) answer++;
        for(int i=10; i<discount.length; i++){
            
            if(map.containsKey(discount[i-10])) {
                if(0<map.get(discount[i-10])+1) count++;
                map.put(discount[i-10], map.get(discount[i-10])+1);
            }
            
            if(map.containsKey(discount[i])) {
                if(0<=map.get(discount[i])-1) count--;
                map.put(discount[i], map.get(discount[i])-1);
            }
            
            if(count==0) answer++;
        }
        
        return answer;
    }
}