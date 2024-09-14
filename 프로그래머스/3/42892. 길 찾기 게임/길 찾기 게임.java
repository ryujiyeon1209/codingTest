import java.util.*;

class Solution {
    
    static int idx;
    static int[][] graph;
    static int[][] answer;
    
    public int[][] solution(int[][] nodeinfo) {
        answer = new int[2][nodeinfo.length];
        
        //값마다 좌표 저장
        Map<Integer, int[]> map = new HashMap();
        for(int i=0; i<nodeinfo.length; i++){
           map.put((i+1), nodeinfo[i]);
        }
        
        //y값이 높은 순서로 정렬
        List<Integer> keyset = new ArrayList(map.keySet());
        Collections.sort(keyset, new Comparator<Integer>(){
           public int compare(Integer o1, Integer o2) {
               if(map.get(o1)[1]==map.get(o2)[1]) return map.get(o1)[0]-map.get(o2)[0];
               else return map.get(o2)[1]-map.get(o1)[1];
           } 
        });
        
        //그래프
        graph = new int[nodeinfo.length+1][2];
        int start=keyset.get(0);
        graph[0][0]=start;
        
        for(int i=1; i<keyset.size(); i++){        
            DFS(nodeinfo, keyset.get(i), start);
        }
        
        //전위순회
        idx=0;
        preDFS(start);
        
        idx=0;
        aftDFS(0);
        
        return answer;
    }
    
    //인접행렬 그래프 만들기
    public static void DFS(int[][] nodeinfo, int idx, int parent) {
    
         //부모의 왼쪽 노드에 값이 있을 경우
        if(nodeinfo[idx-1][0]<nodeinfo[parent-1][0] && graph[parent][0]!=0) {
            DFS(nodeinfo, idx, graph[parent][0]);
        }
        
        //부모의 왼쪽 노드일 경우
        else if(nodeinfo[idx-1][0]<nodeinfo[parent-1][0]) {
            graph[parent][0]=idx;
            return;
        }       
           
        
        //부모의 오른쪽 노드에 값이 있을 경우
        else if(nodeinfo[parent-1][0]<nodeinfo[idx-1][0] && graph[parent][1]!=0) {
            DFS(nodeinfo, idx, graph[parent][1]);
        }
        
        //부모의 오른쪽 노드일 경우
        else if(nodeinfo[parent-1][0]<nodeinfo[idx-1][0]) {
            graph[parent][1]=idx;
            return;
        }
    }
    
    //전위순회
    public static void preDFS(int value) {
       
        answer[0][idx++]=value;
        
        if(graph[value][0]==0 && graph[value][1]==0) return;
        
        for(int i=0; i<graph[value].length; i++){
            if(graph[value][i]==0) continue;
            preDFS(graph[value][i]);
        } 
    }
    
    //후위순회
    public static void aftDFS(int value) {
        
        if(graph[value][0]==0 && graph[value][1]==0) return;
        
        for(int i=0; i<graph[value].length; i++){
            if(graph[value][i]==0) continue;
            aftDFS(graph[value][i]);
            
            answer[1][idx++]=graph[value][i];
        } 
    }
}