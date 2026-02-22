import java.util.*;

class Solution {
    public int[] solution(int[] arr, boolean[] flag) {
        
        
        List<Integer> list = new ArrayList();
        
        for(int i=0; i<flag.length; i++) {
            for(int j=0; j<arr[i]; j++) {
                if(flag[i]) {
                    list.add(arr[i]);
                    list.add(arr[i]);
                }
                if(!flag[i] && list.size()!=0) {
                    list.remove(list.size()-1);
                }
            }
        }
        
        int[] answer = list.stream().mapToInt(i->i).toArray();
        return answer;
    }
}