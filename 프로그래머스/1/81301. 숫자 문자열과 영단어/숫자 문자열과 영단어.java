import java.util.*;

class Solution {
    public int solution(String s) {
        String answer = "";
        
        Map<String, Integer> map = new HashMap();
        map.put("zero", 0);       map.put("five", 5);    
        map.put("one", 1);        map.put("six", 6);    
        map.put("two", 2);        map.put("seven", 7);    
        map.put("three", 3);      map.put("eight", 8);    
        map.put("four", 4);       map.put("nine", 9);    

        String num = "";
        char[] charArr = s.toCharArray();
        
        for(int i=0; i<charArr.length; i++){
            //숫자일 경우
            if(Character.isDigit(charArr[i])) {
                
                if(!num.equals("")) answer+=map.get(num);
                num = "";
                
                answer+=charArr[i];
            }
            
            //문자일 경우
            else {
                if(map.get(num)!=null) {
                    answer+=map.get(num);
                    num = "";
                }
                
                num+=charArr[i];
            }
        }
        
        //마지막 문자가 존재한다면
        if(0<num.length()) answer+=map.get(num);
        
        return Integer.parseInt(answer);
    }
}