import java.util.*;

class Solution {
    
    static int n, m;
    static boolean[][] isvisited;
    static int[] r, c;
    
    public int solution(int[][] maps) {
        
        n = maps.length;
        m = maps[0].length;
        r = new int[] {-1, 0, 1, 0};
        c = new int[] {0, 1, 0, -1};
        isvisited = new boolean[n][m];
       
    
        int answer = BFS(maps);
        return answer;
    }
    
    public static int BFS(int[][] maps){
        Queue<int[]> queue = new LinkedList();
        queue.add(new int[] {0, 0, 1});
        isvisited[0][0]=true;
        
        int min = Integer.MAX_VALUE;
        while(!queue.isEmpty()){
            
            int[] curr = queue.poll();
            int i = curr[0];
            int j = curr[1];
            int depth = curr[2];
            
            if(i==n-1 && j==m-1) min = Math.min(depth, min);
            
            for(int k=0; k<4; k++){
                int dr = i+r[k];
                int dc = j+c[k];
                
                if(!(0<=dr && dr<n && 0<=dc && dc<m)) continue;
                if(maps[dr][dc]==0) continue;
                if(isvisited[dr][dc]) continue;
                
                
                isvisited[dr][dc]=true;
                queue.add(new int[] {dr, dc, depth+1});
            }
        }
        
        return min==Integer.MAX_VALUE ? -1 : min;
        
    }
}