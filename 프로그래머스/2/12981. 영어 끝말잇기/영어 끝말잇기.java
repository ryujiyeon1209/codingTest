import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        int lose=-1;
        
        Map<String, Integer> map = new HashMap();
        map.put(words[0], 1);
        
        for(int i=1; i<words.length; i++){
            char pre = words[i-1].charAt(words[i-1].length()-1);
            char cur = words[i].charAt(0);
            
            if(pre!=cur || map.containsKey(words[i])) {
                lose=i;
                break;
            }
            
            map.put(words[i], map.getOrDefault(words[i], 0) +1);
        }

        if(lose==-1) answer = new int[] {0, 0};
        else answer = new int[] {(lose%n)+1, (lose/n)+1};
        
        return answer;
    }
}