import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        int count = 0;
        int count_zero = 0;
        
        //1이 아니라면 반복
        while(!s.equals("1")) {
            
            count++;
            
            int zero = 0;
            int one = 0;
            for(int i=0; i<s.length(); i++){
                if(s.charAt(i)=='0') zero++;
                else one++;
            }
            
            //1의 개수를 2짅수로 변경
            s = Integer.toBinaryString(one);
            count_zero+=zero;
            
        }
        
        //정답 배열에 저장
        answer[0] = count;
        answer[1] = count_zero;
        
        return answer;
    }
}