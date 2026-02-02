import java.util.*;

class Solution {
    public String[] solution(String my_string) {
        String[] string = my_string.split(" ");
        
        List<String> list = new ArrayList();
        for(String str : string) {
            if(str.equals("")) continue;
            else list.add(str);
        }
        
        String[] answer = new String[list.size()];
        list.toArray(answer);
        
        return answer;
    }
}