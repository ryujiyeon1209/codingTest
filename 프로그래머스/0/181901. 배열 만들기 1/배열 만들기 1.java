import java.util.*;

class Solution {
    public int[] solution(int n, int k) {
        
        int num = k;
        int i = 1;
        List<Integer> list = new ArrayList();
        while(num<=n) {
            list.add(num);
            
            i++;
            num=k*i;
        }
        
        int[] answer = list.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}