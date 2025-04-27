import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        int idx = 0;
        int count = 0;
        while(!s.equals("1")) {
            idx++;
            
            //1과 0의 개수 세기
            int size = 0;
            for(int i=0; i<s.length(); i++){
                if(s.charAt(i)=='1') size++;
            }
            
            count+=(s.length()-size);
            
            //2진법으로 변환
            s = change(size);
        }
        
        answer[0] = idx;
        answer[1] = count;
        
        return answer;
    }
    
    //2진법 변환 메서드
    public String change(int num) {
        
        StringBuilder sb = new StringBuilder();
        while(num!=0) {
            if(num%2==0) sb.append("0");
            else sb.append("1");
            
            num/=2;
        }
        
        return sb.reverse().toString();
    }
}