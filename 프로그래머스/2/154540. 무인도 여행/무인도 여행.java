import java.util.*;

class Solution {
    
    static int n, m;
    static int[] r, c;
    static char[][] map;
    static boolean[][] isvisited;
    static PriorityQueue<Integer> squeue;
    
    public int[] solution(String[] maps) {

        n = maps.length;
        m = maps[0].length();
        
        r = new int[] {1, -1, 0, 0};
        c = new int[] {0, 0, 1, -1};
    
        map = new char[n][m];
        for(int i=0; i<maps.length; i++){
            map[i] = maps[i].toCharArray();
        }
        
        isvisited = new boolean[n][m];
        squeue = new PriorityQueue();
        
        for(int i=0; i<map.length; i++){
            for(int j=0; j<map[i].length; j++){
                if(map[i][j]!='X' && !isvisited[i][j]) {
                    BFS(i, j);
                }
            }
        }
        
        if(squeue.isEmpty()) return new int[] {-1};
        
        int idx = 0;
        int[] answer = new int[squeue.size()];
        while(!squeue.isEmpty()){
            answer[idx++]=squeue.poll();
        }
        
        return answer;
    }
    
    
    public static void BFS(int sr, int sc){
        Queue<int[]> queue = new LinkedList();
        
        isvisited[sr][sc]=true;
        queue.add(new int[] {sr, sc, map[sr][sc]});
        
        int sum = 0;
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            
            int i = cur[0];
            int j = cur[1];
            int value = cur[2]-'0';
            
            sum+=value;
           
            for(int k=0; k<4; k++){
                int dr = i+r[k];
                int dc = j+c[k];
                
                if(!(0<=dr && dr<n && 0<=dc && dc<m)) continue;
                if(map[dr][dc]=='X') continue;
                if(isvisited[dr][dc]) continue;
                
                isvisited[dr][dc]=true;
                queue.add(new int[] {dr, dc, map[dr][dc]});
            }
        }
        
        squeue.add(sum);
    }
}