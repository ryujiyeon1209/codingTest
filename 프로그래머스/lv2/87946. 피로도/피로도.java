import java.util.*;

class Solution {
    
    static int answer;
    static int[] choose;
    static boolean[] isvisited;
    
    public int solution(int k, int[][] dungeons) {
        
        answer = 0;
        choose = new int[dungeons.length];
        isvisited = new boolean[dungeons.length];
        
        permutation(0, k, dungeons);
        return answer;
    }
    
    public static void permutation(int idx, int k, int[][] dungeons){
        
        if(idx>=choose.length){
            
            int count=0;
            int tmpK=k;
                
            for(int i=0; i<choose.length; i++){
                if(dungeons[choose[i]][0]<=tmpK){
                    count++;
                    tmpK-=dungeons[choose[i]][1];
                }    
            }
            
            answer = Math.max(answer, count); 
            return;
        }
        
        
        for(int i=0; i<choose.length; i++){
            if(isvisited[i]) continue;
            
            isvisited[i]=true;
            choose[i]=idx;
            permutation(idx+1, k, dungeons);
            
            isvisited[i]=false;
        }
    }
}