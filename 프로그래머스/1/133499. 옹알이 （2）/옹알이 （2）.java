import java.util.*;

class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        String[] real = {"aya", "ye", "woo", "ma"};
        
        for(int i=0; i<babbling.length; i++){
            String cur = babbling[i];
            
            boolean flag = false;
            int idx = -1;
            
            while(true){
                
                flag = false;
                for(int j=0; j<real.length; j++){
                    if(cur.startsWith(real[j]) && idx!=j) {
                        flag = true;
                        idx = j;
                        cur = cur.substring(real[j].length());
                    }
                }
                
                if(!flag) break;
                if(cur.length()==0) break;
            }
            
            if(flag) answer++;
        }
        
        return answer;
    }
}