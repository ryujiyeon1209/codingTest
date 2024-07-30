import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
    
        for(int i=0; i<commands.length; i++){
            int start = commands[i][0]-1;
            int end = commands[i][1];
            int k = commands[i][2];
            
            //새로운 배열 만들기
            int[] tmp = new int[end-start];
            int idx = 0;
            for(int j=start; j<end; j++){
                tmp[idx++] = array[j];
            }
            
            //정렬
            Arrays.sort(tmp);
            
            //k번째 수 구하기
            answer[i] = tmp[k-1];
        }
        
        return answer;
    }
}