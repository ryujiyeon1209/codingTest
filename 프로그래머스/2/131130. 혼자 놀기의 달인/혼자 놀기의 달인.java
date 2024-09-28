import java.util.*;

class Solution {
    public int solution(int[] cards) {
        int answer = 0;
        
        //인덱스부터 시작해서 연 상자의 개수
        int[] count = new int[cards.length];
        
        //열어본 박스인지 확인
        boolean[] isopen = new boolean[cards.length];
        
        for(int i=0; i<cards.length; i++){
            int idx = i;   
            
            while(!isopen[idx]) {
                count[i]++;
                isopen[idx]=true;
                
                idx=cards[idx]-1;
                
            }
        }

        
        //내림차순 정렬
        Arrays.sort(count);
        
        answer = count[cards.length-1]*count[cards.length-2];
        return answer;
    }
}