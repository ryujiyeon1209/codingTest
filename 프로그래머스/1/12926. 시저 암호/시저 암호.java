import java.util.*;

class Solution {
    public String solution(String s, int n) {
        String answer = "";
        
        //알파벳 저장
        char[] alphabet = new char[52];
        for(int i=0; i<alphabet.length; i++){
            if(i<26) alphabet[i] = (char) (65 + i);
            else alphabet[i] = (char) (71 + i);
        }
        
        Map<Character, Integer> map = new HashMap();
        for(int i=0; i<alphabet.length; i++){
            map.put(alphabet[i], i);
        }
        
        
        //문자열 밀기
        char[] chArr = s.toCharArray();
        for(int i=0; i<chArr.length; i++){
            
            //대문자
            if('a'<=chArr[i] && chArr[i]<='z') {
                int idx = map.get(chArr[i]);
                answer+=alphabet[26+((idx+n)%26)];
            }
            
            //소문자
            else if('A'<=chArr[i] && chArr[i]<='Z') {
                int idx = map.get(chArr[i]);
                answer+=alphabet[(idx+n)%26];
            }
            
            //공백
            else answer+=chArr[i];
        }
        
        return answer;
    }
}