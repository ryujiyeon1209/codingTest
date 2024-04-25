class Solution {
    public String solution(int n) {
        
        String answer = "";
        for(int i=0; i<n; i+=2){
            if(i==n-1) answer+="수";
            else answer+="수박";
        }
        
        return answer;
    }
}