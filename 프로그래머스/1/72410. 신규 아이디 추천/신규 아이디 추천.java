import java.util.*;

class Solution {
    public String solution(String new_id) {
         String answer = "";
        
        //1단계
        new_id = new_id.toLowerCase();
        
        //2단계
        List<Character> list = new ArrayList();
        for(int i=0; i<new_id.length(); i++){
            char ch = new_id.charAt(i);
            
            if(('a' <=ch && ch<='z') || ('0'<=ch && ch<='9') || 
               ch=='-' || ch=='_' || ch=='.') list.add(ch);
        }
        
        while(true) {
            new_id = "";
            for(int i=0; i<list.size(); i++){
                new_id+=list.get(i);
            }
            
            //3단계
            Stack<Integer> stack = new Stack();
            for(int i=0; i<list.size(); i++){
                if(list.get(i)=='.') stack.add(i);
            }

            while(!stack.isEmpty()){
                int idx = stack.pop();
                if(!stack.isEmpty() && idx-1==stack.peek()) list.remove(idx);
            }

            //4단계
            if(1<=list.size() && list.get(0)=='.') list.remove(0);
            if(1<=list.size() && list.get(list.size()-1)=='.') list.remove(list.size()-1);


            //5단계
            if(list.size()==0) list.add('a');

            //6단계
            while(16<=list.size()) list.remove(list.size()-1);

            //7단계
            while(list.size()<=2) list.add(list.get(list.size()-1));
            
            //한번 더 반복해야하는지 확인
            answer = "";
            for(int i=0; i<list.size(); i++){
                answer+=list.get(i);
            }
            
            if(answer.equals(new_id)) break;
        }
        
        
        return answer;
    }
}