import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        
        int[] answer = {};
        
        //탈락하는 사람 번호
        int person = 0;
        
        //탈락한 차례
        int time = 0;
    
        Set<String> set = new HashSet();
        set.add(words[0]);
        
        int count=1;
        for(int i=1; i<words.length; i++){
            count++;
            
            char[] ch1 = words[i-1].toCharArray();
            char[] ch2 = words[i].toCharArray();
            
            set.add(words[i]);
            
            if(ch1[ch1.length-1]!=ch2[0] || set.size()!=count){
                person= (count%n==0) ? n : count%n;
                time= (int) Math.ceil(count/(n*1.0));
                break;
            } 
        }
        
        answer = new int[] {person, time};
        
        return answer;
    }
}