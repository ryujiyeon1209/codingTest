import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        //철수와 동생이 가지게 될 토핑 종류와 개수
        Map<Integer, Integer> map1 = new HashMap();
        Map<Integer, Integer> map2 = new HashMap();
        
        //map1
        map1.put(topping[0], 1);
        
        //map2
        for(int i=1; i<topping.length; i++){
            map2.put(topping[i], map2.getOrDefault(topping[i], 0)+1);
        }
        
        //완전탐색
        for(int i=1; i<topping.length; i++){
            
            //map1에 토핑 주기
            map1.put(topping[i], map1.getOrDefault(topping[i], 0)+1);
            
            //map2에게서 토핑 뺏기
            if(map2.get(topping[i])==1) map2.remove(topping[i]);
            else map2.put(topping[i], map2.get(topping[i])-1);
            
            //만약 토핑의 개수가 같다면
            if(map1.size()==map2.size()) answer++;
        }
        
        return answer;
    }
}