import java.util.*;

class Solution {
    
    static int[] parent;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        //부모 노드 저장 배열
        parent = new int[n+1];
        for(int i=0; i<parent.length; i++){
            parent[i]=i;
        }
        
        //연결하기
        for(int i=0; i<computers.length; i++){
            for(int j=i+1; j<computers[i].length; j++){
                if(computers[i][j]==1) {
                    union(i+1, j+1);
                }
            }
        }
        
        //마지막 find
        for(int i=0; i<parent.length; i++){
            parent[i] = find(i);
        }
        
        //종류 개수 세기
        Set<Integer> set = new HashSet();
        for(int i=1; i<parent.length; i++){
            set.add(parent[i]);
        }
        
        answer = set.size();
        return answer;
    }
    
    //union
    public static void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        
        if(px<=py) parent[py]=parent[px];
        else parent[px]=parent[py];
    }
    
    //find
    public static int find(int x) {
        if(x==parent[x]) return x;
        else return parent[x]=find(parent[x]);
    }
}