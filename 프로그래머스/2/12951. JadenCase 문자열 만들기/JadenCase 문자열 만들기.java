import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        String[] strarr = s.split("");
        
        Queue<String> queue = new LinkedList();
        for(int i=0; i<strarr.length; i++){
            String str = strarr[i];
            
            if(queue.isEmpty() && (str.equals(" ") || isNum(strarr[i])))
                queue.add(str);    
            
            else if(queue.isEmpty() && !isNum(strarr[i]))
                queue.add(str.toUpperCase());
            
            else if(isNum(strarr[i]))
                queue.add(str); 
            
            else if(strarr[i-1].equals(" ") && !isNum(strarr[i]))
                queue.add(str.toUpperCase());
            
            
            else if(!strarr[i-1].equals(" ") && !isNum(strarr[i]))
                queue.add(str.toLowerCase());
        
        }
        
        while(!queue.isEmpty()) {
            answer+=queue.poll();
        }
        
        return answer;                                       
    }
    
    //숫자인지 확인 메서드
    public static boolean isNum(String str) {
        if('0'<=str.charAt(0) && str.charAt(0)<='9') return true;
        else return false;
    }
}