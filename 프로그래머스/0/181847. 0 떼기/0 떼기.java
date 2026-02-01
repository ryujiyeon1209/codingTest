class Solution {
    public String solution(String n_str) {
        String answer = "";
        
        int cnt = 0;
        for(char ch : n_str.toCharArray()) {
            if(ch=='0') cnt++;
            else return n_str.substring(cnt);
        }
       
        return n_str.substring(cnt);
    }
}