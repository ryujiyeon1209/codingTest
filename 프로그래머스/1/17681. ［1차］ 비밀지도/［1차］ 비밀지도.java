import java.util.*;

class Solution {
    
    static int[][] map;
    
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        map = new int[n][n];
        
        //arr1, arr2 2진수로 변경
        for(int i=0; i<arr1.length; i++){
           binary(i, arr1[i]);
        }
        
        for(int i=0; i<arr2.length; i++){
           binary(i, arr2[i]);
        }
        
        //출력 모양으로 변경
        for(int i=0; i<n; i++){
            
            String result = "";
            for(int j=0; j<n; j++){
                if(map[i][j]==1) result+="#";
                else result+=" ";
            }
            
            answer[i] = result;
        }
        
        
        return answer;
    }
    
    
    //2진수로 변경
    public static void binary (int i, int num){
        
        int idx = map.length-1;
        while(0<num){
            if(num%2==1) map[i][idx] = 1;
    
            num/=2;   
            idx--;
        }
    }   
}