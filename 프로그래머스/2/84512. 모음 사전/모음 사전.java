import java.util.*;

class Solution {
    public int solution(String word) {
        
        String[] str = {"A", "E", "I", "O", "U"};
        
        PriorityQueue<String> queue = new PriorityQueue<>();
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<str.length; i++){
            String str1 = str[i];
            queue.add(str1);
            
            for(int j=0; j<str.length; j++){
                String str2 = str1+str[j];
                queue.add(str2);
                
                for(int k=0; k<str.length; k++){
                    String str3 = str2+str[k];
                    queue.add(str3);
                    
                    for(int l=0; l<str.length; l++){
                        String str4 = str3+str[l];
                        queue.add(str4);
                        
                        for(int p=0; p<str.length; p++){
                            String str5 = str4+str[p];
                            queue.add(str5);
                        }
                    }
                }
            }
        }
        
        int answer = 0;
        while(!queue.isEmpty()) {
            answer++;
            if(word.equals(queue.poll())) break;
        }
        
        return answer;
    }
}