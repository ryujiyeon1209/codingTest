import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
 
        String[][] map = new String[park.length][park[0].length()];
        for(int i=0; i<park.length; i++){
            map[i] = park[i].split("");
        }
        
        //출발 지점 찾기
        int startr = 0;
        int startc = 0;
        for(int i=0; i<map.length; i++){
            for(int j=0; j<map[0].length; j++){
                if(map[i][j].equals("S")) {
                    startr = i;
                    startc = j;
                    break;
                }
            }
        }
        
        
        int dr = startr;
        int dc = startc;
        
        int[] r = new int[] {-1, 0, 1, 0};
        int[] c = new int[] {0, 1, 0, -1};
        
        for(int i=0; i<routes.length; i++){
            String[] command = routes[i].split(" ");
            
            String dir = command[0];
            int move = Integer.parseInt(command[1]);
            
            int idx = 0;
            if(dir.equals("S")) {
                idx = 2;
            } else if(dir.equals("W")) {
                idx = 3;
            } else if(dir.equals("E")) {
                idx = 1;
            }
            
            for(int k=0; k<move; k++){
                dr+=r[idx];
                dc+=c[idx];
                
                if(!(0<=dr && dr<map.length && 0<=dc && dc<map[0].length)) {
                    dr = startr;
                    dc = startc;
                    break;
                } 
                if(map[dr][dc].equals("X")) {
                    dr = startr;
                    dc = startc;
                    break;
                }
            }
            
            startr = dr;
            startc = dc;
        }
        
        int[] answer = new int[] {dr, dc};
        return answer;
    }
}