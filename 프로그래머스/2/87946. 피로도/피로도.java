import java.util.*;

class Solution {
    
    static int max;
    static int[] select;
    static boolean[] isvisited;
    
    public int solution(int k, int[][] dungeons) {

        select = new int[dungeons.length];
        isvisited = new boolean[dungeons.length];
        
        max = 0;
        permutation(k, 0, dungeons);
        
        return max;
    }
    
    //순열
    public static void permutation(int k, int idx, int[][] dungeons) {
        if(select.length<=idx) {
            int potion = k;
            int count = 0;
            
            for(int i=0; i<select.length; i++){
                int num = select[i];
                
                int need = dungeons[num][0];
                int use = dungeons[num][1];
                
                if(need<=potion) {
                    potion-=use;
                    count++;
                }
                
                else break;
            }
            
            max = Math.max(max, count);
            return;
        }
        
        for(int i=0; i<isvisited.length; i++){
            if(isvisited[i]) continue;
            
            isvisited[i]=true;
            select[idx]=i;
            permutation(k, idx+1, dungeons);
            
            isvisited[i]=false;
        }
    }
}