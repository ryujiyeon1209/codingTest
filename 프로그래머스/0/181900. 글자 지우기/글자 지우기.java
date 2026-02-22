import java.util.*;

class Solution {
    public String solution(String my_string, int[] indices) {
        String answer = "";
        
        Arrays.sort(indices);
        
        int idx = 0;
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<my_string.length(); i++){
            if(indices.length<=idx) sb.append(my_string.substring(i, i+1)); 
            
            else if(i!=indices[idx]) sb.append(my_string.substring(i, i+1));    
            else idx++;
        }
        
        return sb.toString();
    }
}