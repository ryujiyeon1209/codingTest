import java.util.*;

class Solution {
    public int solution(String s) {
        
        int answer = Integer.MAX_VALUE;
        if(s.length()==1) answer = 1;       //문자열 길이가 1일 때
        
        for(int i=1; i<s.length(); i++){
            int cut = i;
            
            int count = 0;                              //똑같은 문자열의 개수
            String cutStr = s.substring(0, cut);        //비교할 문자열
            String str = "";                            //최종 문자열
            int length = 0;                             //최종 문자열 길이
            
            for(int j=0; j<=s.length()-cut; j+=cut){
                if(cutStr.equals(s.substring(j, j+cut))) {
                    count++;
                }
                
                else {
                    if(1<count) str+=(count+cutStr);
                    else str+=cutStr;
                    
                    cutStr = s.substring(j, j+cut);
                    count=1;
                }
            }
            
            //마지막 문자열 합치기
            if(1<count) str+=(count+cutStr);
            else str+=cutStr;
            
            //반복문에서 확인하지 못했던 문자열 개수 붙이기
            if(s.length()%cut==0) length = str.length();
            else length = str.length() + (s.length()%cut);
            
            answer = Math.min(answer, length);
        }
        
        
        return answer;
    }
}