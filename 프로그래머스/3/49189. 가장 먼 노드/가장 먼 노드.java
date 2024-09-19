import java.util.*;

class Solution {
    
    static int[] result;
    static boolean[] isvisited;
    static LinkedList<Integer>[] graph;

    public int solution(int n, int[][] edge) {
        
        //인접리스트 생성하기
        graph = new LinkedList[n+1];
        for(int i=0; i<graph.length; i++){
            graph[i]= new LinkedList();
        }
        
        //인접리스트 값 저장하기
        for(int i=0; i<edge.length; i++){
            int start = edge[i][0];
            int end = edge[i][1];
            
            graph[start].add(end);
            graph[end].add(start);
        }
        
        result = new int[n+1];
        isvisited = new boolean[n+1];
        
        DFS(1);
        
        //가장 먼 노드 찾기
        int max = 0;
        for(int i=0; i<result.length; i++){
            if(max<result[i]) max=result[i];
        }
        
        int answer = 0;
        for(int i=0; i<result.length; i++){
            if(max==result[i]) answer++;
        }
        
        return answer;
    }
    
    //DFS
    public void DFS(int idx){
        
        for(int i=0; i<graph[idx].size(); i++){
            int node = graph[idx].get(i);
            
            if(node==1) continue;
     
            if(!isvisited[node]) {
                isvisited[node]=true;
                result[node] = result[idx]+1;
                DFS(node);
            }
            
            else if(isvisited[node] && result[idx]+1<result[node]) {
                result[node]=result[idx]+1;
                DFS(node);
            }
        }
    }
    
}