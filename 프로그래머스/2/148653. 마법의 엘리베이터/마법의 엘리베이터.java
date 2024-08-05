class Solution {
    public int solution(int storey) {
        int answer = 0;

        while(0<storey) {
            
            int num = storey%10;
            storey/=10;
            
            if(num<5) {
                answer+=num;
            }
            else if(5<num) {
                answer+=(10-num);
                storey++;
            }
            else if(storey%10<5) {
                answer+=5;
            }
            else if(5<=storey%10) {
                answer+=5;
                storey++;
            }      
        }
        
        return answer;
    }
}