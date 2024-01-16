import java.util.*;

class Solution {
    
    static int n, m, answer;
    static int[] r, c;
    static char[][] map;
    static boolean[][] isvisited;
    
    
    public int solution(String[] board) {
        
        int sr = 0;
        int sc = 0;
        
        map = new char[board.length][board[0].length()];
        for(int i=0; i<board.length; i++){
            map[i] = board[i].toCharArray();
        }
        
        n = map.length;
        m = map[0].length;
        
        //시작 좌표 찾기
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j]=='R') {
                    sr = i; sc = j; 
                    break;
                }
            }
        }
        
        r = new int[] {-1, 0, 1, 0};
        c = new int[] {0, 1, 0, -1};
        isvisited = new boolean[n][m];
        
        answer = -1;
        BFS(sr, sc);

        return answer;
    }
    
    public static void BFS(int sr, int sc){
        Queue<int[]> queue = new LinkedList();
        
        isvisited[sr][sc] = true;
        queue.add(new int[] {sr, sc, 0});
        
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            
            int cr = curr[0];
            int cc = curr[1];
            int depth = curr[2];
            
            if(map[cr][cc]=='G') {
                answer = depth;
                return;
            }
            
            //4방향 탐색
            for(int k=0; k<4; k++){
                int dr = cr;
                int dc = cc;
               
                while(true) {
                    
                    dr+=r[k];
                    dc+=c[k];
                    //if(cr==0 && cc==0) System.out.println("dr : " +dr+ ", dc : " +dc);
                    
                    if(!(0<=dr && dr<n && 0<=dc && dc<m)) break;
                    if(map[dr][dc]=='D') break;
                    if(isvisited[dr][dc]) continue;
                    
                    if(0<=dr+r[k] && dr+r[k]<n && 0<=dc+c[k] && dc+c[k]<m 
                            && map[dr+r[k]][dc+c[k]]=='D'){
                        isvisited[dr][dc]=true;
                        queue.add(new int[] {dr, dc, depth+1});
                        break;     
                    }
                    if((dr+r[k]==-1 || dr+r[k]==n || dc+c[k]==-1 || dc+c[k]==m)
                           && map[dr][dc]!='D') {
                        isvisited[dr][dc]=true;
                        queue.add(new int[] {dr, dc, depth+1});
                        break; 
                    }
                }
            }
        }
    }
}