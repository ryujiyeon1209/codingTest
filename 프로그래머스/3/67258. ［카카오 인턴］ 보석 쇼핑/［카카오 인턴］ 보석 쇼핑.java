import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = {};
        
        //보석 종류 구하기
        Map<String, Integer> total = new HashMap();
        for(int i=0; i<gems.length; i++){
            total.put(gems[i], total.getOrDefault(gems[i], 0)+1);
        }
        
        //현재 가지고 있는 보석 종류
        Map<String, Integer> map = new HashMap();
        for(int i=0; i<total.size(); i++){
            map.put(gems[i], map.getOrDefault(gems[i], 0)+1);
        }
        
        //모든 보석의 종류를 살 수 있다면,
        if(map.size()==total.size()) {
            answer = new int[] {1, map.size()};
            return answer;
        }
        
        //투포인터
        int start = 0;
        int end = total.size();
        int result = Integer.MAX_VALUE;
        
        while(true) {

            //end의 보석 추가하기
            if(end<gems.length) {
                map.put(gems[end], map.getOrDefault(gems[end], 0)+1);        
                end++;
            }
            
            //모든 보석의 종류를 살 수 있다면,
            if(map.size()==total.size()) {
                
                //start 보석이 중복이라면 삭제
                while(0<(map.get(gems[start])-1)){
                    map.put(gems[start], map.get(gems[start])-1);
                    start++;
                }
                
                //거리 측정하기
                int tmp = (gems.length<=end) ? gems.length-1 : end-1; 
                
                if(tmp-start<result) {
                    result = tmp-start;
                    
                    answer = new int[] {start+1, tmp+1};
                }
            }  
            
            //끝내기
            if(gems.length<=end && (map.get(gems[start])-1)<=0){
                break;
            }
        }
        
        return answer;
    }
}