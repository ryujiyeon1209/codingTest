import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        
        //정답배열
        int[] answer = new int[commands.length];
        
        for(int i=0; i<commands.length; i++){
            int start = commands[i][0];
            int end = commands[i][1];
            int choose = commands[i][2];
            
            int[] tmp = new int[end-start+1];
            int idx=0;
            for(int j=start-1; j<end; j++){
                tmp[idx++]=array[j];
            }
            
            Arrays.sort(tmp);
            answer[i] = tmp[choose-1];
        }
        
        
        return answer;
    }
}