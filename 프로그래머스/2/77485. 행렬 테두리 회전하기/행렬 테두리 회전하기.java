import java.util.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        
        int num=1;
        int[][] map = new int[rows][columns];
        for(int i=0; i<map.length; i++){
            for(int j=0; j<map[i].length; j++){
                map[i][j]=num++;
            }
        }
        
        int[][] copy = new int[rows][columns];
        for(int i=0; i<copy.length; i++){
            for(int j=0; j<copy[i].length; j++){
                copy[i][j]=map[i][j];
            }
        }
      
        
        for(int t=0; t<queries.length; t++){
        
            int min= Integer.MAX_VALUE;
            
            int[] query = queries[t];
            int sr = query[0]-1;
            int sc = query[1]-1;
            int er = query[2]-1;
            int ec = query[3]-1;
            
            for(int i=sc+1; i<=ec; i++){
                map[sr][i]=copy[sr][i-1];
                min = Math.min(map[sr][i], min);
            }
            
            for(int i=sr+1; i<=er; i++){
                map[i][ec]=copy[i-1][ec];
                min = Math.min( map[i][ec], min);
            }
            
            for(int i=ec-1; i>=sc; i--){
                map[er][i]=copy[er][i+1];
                min = Math.min(map[er][i], min);
            }
            
            for(int i=er-1; i>=sr; i--){
                map[i][sc]=copy[i+1][sc];
                min = Math.min(map[i][sc], min);
            }

            
            for(int i=0; i<copy.length; i++){
                for(int j=0; j<copy[i].length; j++){
                    copy[i][j]=map[i][j];
                }
            }
            
            answer[t]=min;
        }
        
        return answer;
    }
}