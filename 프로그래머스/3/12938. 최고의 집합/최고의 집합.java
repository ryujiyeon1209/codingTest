class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        
        if(s<n) return new int[] {-1};
        
        int idx=0;
        while(0<n) {
            int num = s/n;
            answer[idx++] = num;
            
            s-=num;
            n--;
        }
        
        return answer;
    }
}