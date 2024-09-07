import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        //정렬
        Arrays.sort(A);
        Arrays.sort(B);
        
        int idx = 0;        
        for(int i=0; i<A.length; i++){
            //현재 A팀의 숫자
            int num = A[i]; 
            
            //이길 때까지 B팀의 높은 수 찾기
            while(idx<B.length && B[idx]<=num) {
                idx++;
            }
            
            //없으면 break, 있으면 answer++
            if(B.length<=idx) break;
            if(num<B[idx]) {
                idx++;
                answer++;
            }
        }
        
        return answer;
    }
}