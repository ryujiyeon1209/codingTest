import java.util.*;

class Solution {
    
    static int[] parent;
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        for(int t=0; t<wires.length; t++){
            
            //부모 배열
            parent = new int[n+1];
            for(int i=1; i<parent.length; i++){
                parent[i]=i;
            }
            
            //선 연결하기
            for(int i=0; i<wires.length; i++){
                if(i==t) continue;
                
                int x = wires[i][0];
                int y = wires[i][1];
                
                union(x, y);
            }
            
            //부모 확인하기
            for(int i=0; i<parent.length; i++){
                parent[i]=find(i);
            }
            
            //송전탑 크기 차이 구하기
            Map<Integer, Integer> map = new HashMap();
            for(int i=1; i<parent.length; i++){
                map.put(parent[i], map.getOrDefault(parent[i], 0)+1);
            }
            
            int count = 0;
            
            List<Integer> list = new ArrayList(map.values());
            if(2<=list.size()) count=Math.abs(list.get(0)-list.get(1));
            
            answer = Math.min(answer, count) ;
        }
        
        
        return answer;
    }
    
    //선 연결하기
    public static void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        
        if(px<=py) parent[py]=px;
        else parent[px]=py;
    }
    
    //부모 확인하기
    public static int find(int x) {
        if(parent[x]==x) return x;
        else return parent[x]=find(parent[x]);
    }

}