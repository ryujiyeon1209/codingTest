import java.util.*;

class Solution {
    
    static int n;
    static int[] r, c;
    static boolean[][] isvisited;
    
    public int[] solution(String[][] places) {
        
        n = 5;
        
        r = new int[] {-1, 0, 1, 0};
        c = new int[] {0, 1, 0, -1};
        
       
        
        int[] answer = new int[n];
        for(int i=0; i<n; i++){
            answer[i] = BFS(places[i] , i);    
        }
        
        return answer;
    }
    
    //BFS
    public int BFS(String[] place, int idx){
        Queue<int[]> queue = new LinkedList();
        
        
        //2차원 배열로 변경
        String[][] map = new String[n][n];
        for(int i=0; i<map.length; i++){
            map[i] = place[i].split("");
        }
        
        boolean isCorrect = true;
            
        //P좌표를 queue에 넣기
        Loop:
        for(int i=0; i<map.length; i++){
            for(int j=0; j<map[i].length; j++){
                if(map[i][j].equals("P")) {
                    isvisited = new boolean[n][n];
                    
                    queue.add(new int[] {i, j, 1});
                    isvisited[i][j]=true;
                    
                    while(!queue.isEmpty()){
                        int[] cur = queue.poll();

                        int depth = cur[2];
                        
                        for(int k=0; k<4; k++){
                            int dr = cur[0]+r[k];
                            int dc = cur[1]+c[k];

                            if(!(0<=dr && dr<n && 0<=dc && dc<n)) continue;

                            //파티션이 있는 경우
                            if(map[dr][dc].equals("X")) continue;

                            //거리두기를 지킨 경우
                            if(map[dr][dc].equals("P") && 2<depth) continue;

                            //거리두기를 지키지 않은 경우
                            if(map[dr][dc].equals("P") && depth<=2 && !isvisited[dr][dc]) {
                                isCorrect = false; 
                                break Loop;
                            } 

                            //계속 탐색하는 경우
                            if(map[dr][dc].equals("O") && !isvisited[dr][dc]){
                                queue.add(new int[] {dr, dc, depth+1});
                                isvisited[dr][dc]=true;
                            } 
                        }
                    }
                }
            }
        }

         //반환값
        if(!isCorrect) return 0;
        else return 1;
        
    }
}