import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};

        Queue<String> queue = new LinkedList();
        Set<String> set = new HashSet();
        
        String lastCh = words[0].substring(words[0].length()-1);
        set.add(words[0]);
        
        boolean flag = true;
        for(int i=1; i<words.length; i++){
            
            String startCh = words[i].substring(0, 1);
            if(!lastCh.equals(startCh)) flag = false;
            
            lastCh = words[i].substring(words[i].length()-1);
            
            int size = set.size();
            set.add(words[i]);
            if(set.size()== size) flag = false;
            

            
            if(!flag) {
                int num = ((i+1)%n==0) ? n : (i+1)%n;
                System.out.println("num : " +num + ", " +(i+1));
                if((i+1)%n==0) answer = new int[] {num, (i+1)/n};
                else answer = new int[] {num, ((i+1)/n)+1};

                break;    
            }
        }

        return answer;
    }
}