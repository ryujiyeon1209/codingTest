class Solution {
    public String solution(String my_string, String alp) {
        String answer = "";
        
        for(char ch : my_string.toCharArray()) {
            if(String.valueOf(ch).equals(alp)) ch-=32;
            answer+=ch;
        }
        
        return answer;
    }
}