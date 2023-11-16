class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int original = chageBinaryNum(n);
        
        for(int i=n+1; i<=1000000; i++){
            int tmp = chageBinaryNum(i);
            if(original==tmp) {
                answer = i;
                break;
            }
        }
        
        return answer;
    }
    
    public int chageBinaryNum(int n){
        int count=0;
        while(0<n){
            if(n%2==1) count++;
            n/=2;
        }
        
        return count;
        
    } 
}