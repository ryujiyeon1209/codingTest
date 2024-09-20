import java.util.*;

class Solution {
    
    static List<Integer>[] graph;
    static boolean[] isvisited;
    static int[] dis;
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        

        //인접리스트 생성
        graph = new List[n+1];
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList();
        }
        
        for(int i=0; i<roads.length; i++){
            int start = roads[i][0];
            int end = roads[i][1];
            
            graph[start].add(end);
            graph[end].add(start);
        }
        
        
        //거리 저장 배열
        dis = new int[n+1];
        for(int i=0; i<dis.length; i++){
            if(i==destination) continue;
            else dis[i]=-1;
        }
        
        //방문 체크 배열
        isvisited = new boolean[n+1];
        isvisited[destination]=true;
        
        //DFS 실행
        BFS(destination);
        
        //정답 배열에 옮기기
        int[] answer = new int[sources.length];
        
        List<Integer> list = new ArrayList();
        for(int i=0; i<sources.length; i++){
            list.add(dis[sources[i]]);
        }
        
        for(int i=0; i<answer.length; i++){
            answer[i]=list.get(i);
        }
        
        return answer;
    }
    
    //BFS
    public static void BFS(int idx) {
        
        Queue<Integer> queue = new LinkedList();
        queue.add(idx);
        
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            
            for(int i=0; i<graph[cur].size(); i++){
                int next = graph[cur].get(i);
                
                if(isvisited[next]) continue;
                
                isvisited[next]=true;
                dis[next]=dis[cur]+1;
                queue.add(next);
            }
        }
    }
    
}