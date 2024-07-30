import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        //정렬
        Arrays.sort(citations);
        
        int min = 0;
        int max = citations[citations.length-1];
        
        while(min<=max) {
            int mid = (min+max)/2;
            
            //mid번 이상된 논문 개수 세기
            int count = 0;
            for(int i=0; i<citations.length; i++){
                if(mid<=citations[i]) count++;
            }
            
            //mid와 비교하기
            if(mid<=count) {
                answer = Math.max(answer, mid);
                min++;
            }
            else {
                max--;
            }
        }
        
        return answer;
    }
}