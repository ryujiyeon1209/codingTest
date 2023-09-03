import java.util.*;

class Solution {
    public int solution(int n, int a, int b) {
        int answer = 1;
        
        while(true){
            
            int min = Math.min(a,b);
            int max = Math.max(a,b);

            if(max-min==1 && max%2==0) break;

            answer++;
            a= (int) Math.ceil(a/2.0);
            b= (int) Math.ceil(b/2.0);
            
            //System.out.println("answer : " +answer +", a : " +a+ ", b: " +b);
        }

        return answer;
    }
}