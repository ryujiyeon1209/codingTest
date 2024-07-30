import java.util.*;

class Solution {
    
    static int n, m, answer;
    static int[] r, c;
    static boolean[][] isvisited;
    
    public int solution(int[][] maps) {
        
        n = maps.length;
        m = maps[0].length;
        
        r = new int[] {-1, 0, 1, 0};
        c = new int[] {0, -1, 0, 1};
        
        isvisited = new boolean[n][m];
        
        answer = -1;
        BFS(maps);
        
        return answer;
    }
    
    //BFS
    public static void BFS(int[][] maps) {
        Queue<int[]> queue = new LinkedList();
        
        isvisited[0][0]=true;
        queue.add(new int[] {0, 0, 1});
        
        while(!queue.isEmpty()) {
            
            int[] cur= queue.poll();
            
            int i = cur[0];
            int j = cur[1];
            int depth = cur[2];
            
            if(i==n-1 && j==m-1) {
                answer = depth;
                return;
            }
            
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
    }
}