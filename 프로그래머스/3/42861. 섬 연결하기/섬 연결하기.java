import java.util.*;

class Solution {
    
    static int[] parent;
    
    public int solution(int n, int[][] costs) {
        
        int answer = 0;
        
        //비용 오름차순 정렬
        Arrays.sort(costs, new Comparator<int[]>(){
           public int compare(int[] o1, int[] o2) {
               if(o1[2]==o2[2]) return o1[0]-o2[0];
               return o1[2]-o2[2];
           } 
        });
        
        //루트노드 설정
        parent = new int[n];
        for(int i=0; i<parent.length; i++){
            parent[i]=i;
        }
        
        //다리 연결하기
        for(int i=0; i<costs.length; i++){
            int x = costs[i][0];
            int y = costs[i][1];
            
            if(find(x)!=find(y)) {
                union(x, y);
                answer+=costs[i][2];
            }
            
            find(0);
            
            if(check()) break;
        }
        
        return answer;
    }
    
    //유니온
    public static void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        
        if(px<py) parent[py]=px;
        else parent[px]=py;
    }
    
    //파인드
    public static int find(int x) {
        if(parent[x]==x) return x;
        else return parent[x]=find(parent[x]);
    }
    
    //모든 다리가 연결되어 있는지 확인
    public static boolean check(){
        boolean flag = true;
        for(int j=0; j<parent.length-1; j++){
            if(parent[j]!=parent[j+1]) {
                flag = false;
                break;
            }
        }
        
        return flag;
    }
    
}