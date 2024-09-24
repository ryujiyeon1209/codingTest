import java.util.*;

class Solution {
    
    static int n, answer;
    static int[] r, c;
    static int[][] isvisited;
    
    public int solution(int[][] board) {
    
        n = board.length;
        
        r = new int[] {-1, 1, 0, 0};
        c = new int[] {0, 0, -1, 1};
        
        isvisited = new int[n][n];
        
        answer = Integer.MAX_VALUE;
        BFS(board);
        
        return answer;
    }
    
    //BFS
    public static void BFS(int[][] board){
        Queue<int[]> queue = new LinkedList();
        
        isvisited[n-1][n-1] = 0;
        queue.add(new int[] {n-1, n-1, 0, 0, 0});    
        queue.add(new int[] {n-1, n-1, 1, 0, 0});
        
        int idx = 0;
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            
            int i = cur[0];
            int j = cur[1];
            int dir = cur[2];       //방향
            int count = cur[3];     //코너 개수
            int price = cur[4];     //직선도로 값
            
            if(i==0 && j==0) {
                int result = price+(count*500);
                answer = Math.min(answer, result);
            }
            
            for(int k=0; k<4; k++){
                int dr = i+r[k];
                int dc = j+c[k];
                
                int curcount = count;  //코너인지 확인 
                if(dir==0 && (k==2||k==3)) curcount = count+1;
                else if(dir==1 && (k==0||k==1)) curcount = count+1;
                
                int curprice = (price+100)+(curcount*500);  //dr, dc 좌표까지 걸리는 총 값              
                
                if(!(0<=dr && dr<n && 0<=dc && dc<n)) continue;
                if(board[dr][dc]==1) continue;
                if(isvisited[dr][dc]!=0 && isvisited[dr][dc]<curprice) continue;
                
                int curdir = (k==0 || k==1) ? 0 : 1;                    //현재 방향
                isvisited[dr][dc]=curprice;                             //dr, dc 좌표까지 걸리는 총 값
                queue.add(new int[] {dr, dc, curdir, curcount, price+100});
                
            }
        }
    
    }
}