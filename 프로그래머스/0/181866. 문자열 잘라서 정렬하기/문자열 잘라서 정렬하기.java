import java.util.*;

class Solution {
    public String[] solution(String myString) {
        String[] arr = myString.split("x");
        
        List<String> list = new ArrayList();
        for(int i=0; i<arr.length; i++){
            if(!"".equals(arr[i])) {
                list.add(arr[i]);
            }
        }
        
        Collections.sort(list);
        
        String[] answer = list.toArray(new String[list.size()]);
        
        return answer;
    }
}