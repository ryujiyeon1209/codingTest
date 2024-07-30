import java.util.*;

class Solution {
    
    static int[] parent;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        //부모 노드 배열
        parent = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
        }
        
        //연결하기
        for(int i=0; i<computers.length; i++){
            for(int j=0; j<computers.length; j++){
                if(i==j) continue;
                if(computers[i][j]==1) union(i, j);
            }
        }
        
        //정리
        for(int i=0; i<parent.length; i++){
            parent[i] = find(i);
        }        
        
        //중복 네트워크 삭제
        Set<Integer> set = new HashSet();
        for(int i=0; i<parent.length; i++){
            set.add(parent[i]);
        }          
        
        return set.size();
    }
    
    //유니온
    public static void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        
        if(px<=py) parent[py] = px;
        else parent[px]=py;
    }
    
    //파인드
    public static int find(int x) {
        if(parent[x]==x) return x;
        else return parent[x]=find(parent[x]);
    }
}