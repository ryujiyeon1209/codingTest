import java.util.*;

class Solution {
    public String solution(String s) {
        
        //공백제거 및 String배열로 변환
        String[] strarr = s.split(" ");
        
        //String배열을 int배열로 전환
        int[] arr = new int[strarr.length];
        for(int i=0; i<arr.length; i++){
            arr[i] = Integer.parseInt(strarr[i]);
        }
        
        //오름차순 정렬
        Arrays.sort(arr);
        
        //정답 형식으로 변환 
        String answer = arr[0] +" "+ arr[arr.length-1];
        
        return answer;
    }
}