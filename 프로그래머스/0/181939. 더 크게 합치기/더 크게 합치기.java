class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        
        String stra = a+""+b;
        String strb = b+""+a;
        
        if(Integer.parseInt(stra)>=Integer.parseInt(strb)) {
            answer = Integer.parseInt(stra);
        } else {
            answer = Integer.parseInt(strb);
        }
        
        return answer;
    }
}