import java.util.*;

class Solution {
    
    static int[] parent;
    
    public int solution(int n, int[][] computers) {
        
        //부모 배열 생성 및 초기화
        parent = new int[n];
        for(int i=0; i<parent.length; i++){
            parent[i] = i;
        }
        
        //유니온 파인드
        for(int i=0; i<computers.length; i++){
            for(int j=0; j<computers[i].length; j++){
                if(computers[i][j]==1) {
                    union(i, j);
                }
            }
        }
        
        //부모가 같지만, 적용이 안됐을 경우를 대비하여
        for(int i=0; i<parent.length; i++){
            parent[i] = find(i);
        }
        
        //중복제거
        Set<Integer> set = new HashSet();
        for(int i=0; i<parent.length; i++){
            set.add(parent[i]); 
        }
        
        int answer = set.size();
        return answer;
    }
    
    //부모 같게 만들기
    public static void union(int x, int y){
        int px = find(x);
        int py = find(y);

        if(px<=py) parent[py] = px; //y의 최대 부모py의 값을 px로 바꾸기
        else parent[px] = py;       //x의 최대 부모px의 값을 py로 바꾸기
    }
    
    //부모 찾기
    public static int find(int x) {
        if(parent[x]==x) return x;
        return parent[x] = find(parent[x]);    //재귀를 통해 계속 부모노드 바꿔줌
    }
}