import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        //터널을 빠져나가는 위치 오름차순
        Arrays.sort(routes, new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2) {
                if(o1[1]==o2[1]) return Integer.compare(o1[0], o2[0]);
                return Integer.compare(o1[1], o2[1]);
            }
        });
        
        int idx = 0;
        int camera = 0;
        
        while(idx<routes.length) {
            
            //카메라 설치
            camera = routes[idx][1]; 
            
            //설치한 카메라 개수
            answer++;                           
            
            //설치한 카메라 위치보다 더 전에 터널에서 출발했다면,  
            while(idx<routes.length && routes[idx][0]<=camera) {      
                idx++;
            }  
        }
        
        
        
        return answer;
    }
}