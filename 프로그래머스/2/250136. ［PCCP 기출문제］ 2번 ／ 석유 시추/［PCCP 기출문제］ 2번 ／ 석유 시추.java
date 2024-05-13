import java.util.*;

class Solution {
    
    static boolean[][] isvisited;
    static int[] r, c;
    static int[] count;
    
    public int solution(int[][] land) {
        
        //사방향 탐색
        r = new int[] {-1, 0, 1, 0};
        c = new int[] {0, 1, 0, -1};
    
        
        //각 열마다 가질 수 있는 석유의 양
        count = new int[land[0].length];
        
        //방문 체크
        isvisited = new boolean[land.length][land[0].length];   
        
        for(int i=0; i<land[0].length; i++){
            for(int j=0; j<land.length; j++){
                if(land[j][i]==1 && !isvisited[j][i]) {
                    BFS(land, new int[] {j, i});
                }
            }
        }
        
        //최대값 찾기
        int answer = 0;
        for(int i=0; i<count.length; i++){
            answer = Math.max(answer, count[i]);
        }
        
        return answer;
    }
    
    //BFS
    public static void BFS(int[][] land, int[] location) {
        Queue<int[]> queue = new LinkedList();
        Set<Integer> set = new HashSet();
        
        int cnt = 0;
        
        queue.add(location);
        isvisited[location[0]][location[1]] = true;
        
        while(!queue.isEmpty()) {
            
            int[] cur = queue.poll();
            int i = cur[0];
            int j = cur[1];
            
            cnt++;
            set.add(j);
            
            for(int k=0; k<4; k++){
                int dr = i+r[k];
                int dc = j+c[k];
                
                if(!(0<=dr && dr<land.length && 0<=dc && dc<land[0].length)) continue;
                if(land[dr][dc]==0) continue;
                if(isvisited[dr][dc]) continue;
                
                isvisited[dr][dc] = true;
                queue.add(new int[] {dr, dc});
                
                
            }
        }
        
        //각 열이 가질 수 있는 석유의 양 저장
        for(int num : set){
            count[num]+=cnt;
        }
        
    }
}