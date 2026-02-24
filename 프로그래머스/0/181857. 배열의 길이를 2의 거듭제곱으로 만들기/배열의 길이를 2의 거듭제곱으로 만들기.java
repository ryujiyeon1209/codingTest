import java.util.*;

class Solution {
    public int[] solution(int[] arr) {

        int num = 0;
        int answerlen = arr.length;
        
        while(Math.pow(2, num) < answerlen) {
            num++; 
        }
        
        answerlen = (int) Math.pow(2, num);
       
        int[] answer = new int[answerlen];
        for(int i=0; i<arr.length; i++){
            answer[i] = arr[i];
        }
        
        return answer;
    }
}