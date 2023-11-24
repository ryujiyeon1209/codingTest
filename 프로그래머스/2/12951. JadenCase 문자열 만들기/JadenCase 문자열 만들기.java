import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        Queue<Character> queue = new LinkedList();
        
        char[] chList = s.toCharArray();
        for(int i=0; i<chList.length; i++){
            queue.add(chList[i]);
        }
        
        boolean flag=true;
        while(!queue.isEmpty()){
            char ch = queue.poll();
            
            if(ch==' ') {
                flag=true;
                answer+=ch;
                continue;
            }
            
            ch = toChanage(ch, flag);
            flag=false;
            
            answer+=ch;
        }
        
        return answer;
    }
    
    
    public Character toChanage(char ch, boolean flag){
        if(0<=ch && ch<=9) return ch;
        
        Character s = ' ';
        if(flag) s = Character.toUpperCase(ch);
        else s = Character.toLowerCase(ch);
        
        System.out.println("s : " + s);
        
        return s;
    }
}