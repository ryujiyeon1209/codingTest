import java.util.*;

class Solution {
    public String solution(String p) {
        String answer = DFS(p);
        return answer;
    }
    
    //올바른 문자열인지 확인
    public static boolean check(String str){
        Stack<Character> stack = new Stack();
        
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)=='(') stack.add('(');
            else if(str.charAt(i)==')' && stack.isEmpty()) return false;
            else if(str.charAt(i)==')' && !stack.isEmpty()) stack.pop();   
        }
        
        if(!stack.isEmpty()) return false;
        else return true;
    }
    
    //문자열 변경
    public static String DFS(String str) {
        
        //1. 입력이 빈 문자열인 경우, 빈 문자열을 반환
        if(str.length()==0) return str;
    
        //2. 균형잡힌 괄호 문자열" u, v로 분리
        String u = "";
        String v = "";
        
        int cnt1 = 0;
        int cnt2 = 0;
        
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)=='(') cnt1++;
            else cnt2++;
            
            if(cnt1==cnt2) {
                u = str.substring(0, i+1);
                if(i<str.length()-1) v = str.substring(i+1, str.length());
                break;
            }
        }
    
        //3. u가 "올바른 괄호 문자열" 이라면, v에 대해 1단계부터 다시 수행
        if(check(u)) return u+DFS(v);
        
        //4. u가 "올바른 괄호 문자열"이 아니라면
        else {
            
            String result = "(" + DFS(v) + ")";       //4-1부터 4-3
            
            for(int i=1; i<u.length()-1; i++){          //4-4 u를 자르고 result에 붙이기
                if(u.charAt(i)=='(') result+=")";
                else result+="(";
            }
            
            return result;
        }
    }
}