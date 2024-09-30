import java.util.*;

class Solution {
    
    static String answer;
    
    public String solution(String p) {
        answer = "";
        
        //처음 입력부터 올바른 괄호 문자열일 경우
        if(check(p)) return p;
        
        //괄호 변환
        return DFS(p);
    }
    
    public static String DFS(String p) {
        if(p.equals("")) return "";
        
        //u, v로 나누기
        char[] charr = p.toCharArray();
        
        String u = "";
        String v = "";
        
        int left = 0;
        int right = 0;
        int idx = 0;
        
        for(int i=0; i<charr.length; i++){
            if(charr[i]=='(') left++;
            else right++;

            u+=charr[i];
            
            if(left==right) {
                v = p.substring(i + 1);
                break;
            }
        }
        

        System.out.println("u : " +u+ ", v : " +v);
        
        //u가 올바른 괄호라면
        if(check(u)) {
            
            return u+DFS(v);
        }
        
        //u가 올바르지 않은 괄호라면
        else {
           StringBuilder sb = new StringBuilder();
            
            sb.append("(");
            sb.append(DFS(v));
            sb.append(")");
            sb.append(change(u));
      
            return sb.toString();
        }
    }
    
    //올바른 괄호인지 확인 메서드
    public static boolean check(String p) {
     
        Stack<Character> stack = new Stack();
        
        char[] charr = p.toCharArray();
        for(int i=0; i<charr.length; i++){
            if(stack.isEmpty()  && charr[i]=='(') stack.add('(');
            else if(charr[i]=='(') stack.add('(');
            else if(!stack.isEmpty()  && charr[i]==')') stack.pop();
            else if(charr[i]==')') return false;
        }
        
        if(!stack.isEmpty()) return false;
        
        return true;
    }
    
    
    //괄호 바꾸기
    public static String change(String u) {
        StringBuilder sb = new StringBuilder();

        for(int i=1; i<u.length()-1; i++){
            if(u.charAt(i)=='(') sb.append(")");
            else sb.append("(");
        }
        
        return sb.toString();
    }
}