import java.util.*;

class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        
        List<Integer> list = new ArrayList();
        for(int i=0; i<intStrs.length; i++){
            int num = Integer.parseInt(intStrs[i].substring(s, s+l));
            if(k<num) list.add(num);
        }
        
        int[] answer = list.stream().mapToInt(i->i).toArray();
        return answer;
    }
}