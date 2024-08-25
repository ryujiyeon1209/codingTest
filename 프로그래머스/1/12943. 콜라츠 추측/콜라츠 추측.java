import java.util.*;

class Solution {
    public int solution(int num) {
        int answer = 0;
        
        long nums = num;
        while(nums!=1) {
            answer++;
            
            if(nums%2==0) nums/=2;
            else nums = (nums*3)+1;
       
            if(500<=answer) {
                answer=-1;
                break;
            }
        }

        return answer;
    }
}