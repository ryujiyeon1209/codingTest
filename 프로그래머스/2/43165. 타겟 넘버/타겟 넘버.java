import java.util.*;

class Solution {
    
    static int answer;
    static int[] choose, arr;
    
    public int solution(int[] numbers, int target) {
    
        arr = new int[] {1, -1};
        choose = new int[numbers.length]; 
        
        answer = 0;
        DFS(0, numbers, target);
        
        return answer;
    }
    
    //순열
    public static void DFS(int idx, int[] numbers, int target) {
        
        if(choose.length<=idx) {
            int sum = 0;
            for(int i=0; i<choose.length; i++){
                sum+=(numbers[i]*choose[i]);
            }
            
            if(sum==target) answer++;
            return;
        }
        
        for(int i=0; i<arr.length; i++){
            choose[idx]=arr[i];
            DFS(idx+1, numbers, target);
        }
        
    }
}