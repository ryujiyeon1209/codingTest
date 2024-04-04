import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        
        String[] type = {"R", "T", "C", "F", "J", "M", "A", "N"};
        int[] score = {0, 3, 2, 1, 0, 1, 2, 3};
        
        //점수 매기기
        Map<String, Integer> map = new HashMap();
        for(int i=0; i<survey.length; i++){
            String[] cur = survey[i].split("");
            
            if(choices[i]<=3) map.put(cur[0], map.getOrDefault(cur[0], 0)+score[choices[i]]);
            else if(5<=choices[i]) map.put(cur[1], map.getOrDefault(cur[1], 0)+score[choices[i]]);
        }
        
        //type을 비교해서 성격유형 만들기
        for(int i=0; i<type.length; i+=2){
            int count1 = (map.containsKey(type[i])) ? map.get(type[i]) : 0;
            int count2 = (map.containsKey(type[i+1])) ? map.get(type[i+1]) : 0;
            
            if(count1==count2) answer+=type[i];
            else if(count1<count2) answer+=type[i+1];
            else answer+=type[i];
        }
        
        
        return answer;
    }
}