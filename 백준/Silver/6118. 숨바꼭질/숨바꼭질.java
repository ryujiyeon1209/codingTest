import java.util.*;

public class Main{
    
	static boolean[] isvisited;
    static int[] result;
    static List[] list;
    
    public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
    	
        int n = sc.nextInt();    //헛간 개수
        int m = sc.nextInt();    //간선 개수
        
        //거리를 저장할 배열
        result = new int[n+1];   
        
        //방문 체크 배열
        isvisited = new boolean[n+1];
        
        //인접리스트 만들기
        list = new ArrayList[n+1];
        for(int i=0; i<n+1; i++){
            list[i] = new ArrayList<Integer>();
        }
        
        //연결 입력받기
        for(int i=0; i<m; i++){
            int conn1 = sc.nextInt();
            int conn2 = sc.nextInt();
        
            list[conn1].add(conn2);
            list[conn2].add(conn1);
        }
        
        BFS(new int[] {1, 0});
        
        //최대 거리 찾기
        int max=Integer.MIN_VALUE;
        for(int i=0; i<result.length; i++) {
        	if(max<result[i]) max=result[i]; 
        }
        
        //최대 거리 개수 찾기
        int count=0;
        int first=0;
        for(int i=0; i<result.length; i++) {
        	if(result[i]==max) count++;
        	if(result[i]==max && first==0) first=i;
        }
        
        //출력
        System.out.println(first + " " + max + " " + count);
    }
    
    public static void BFS(int[] location){
        
    	Queue<int[]> queue = new LinkedList();
    	
    	queue.add(location);
    	isvisited[location[0]]=true;
    	
    	while(!queue.isEmpty()) {
    		
    		//현재 좌표
    		int[] curr = queue.poll();	
    		int idx=curr[0];
    		int depth=curr[1];
    		
    		//거리 저장
    		result[idx] = depth;
    		
    		for(int i=0; i<list[idx].size(); i++) {
    			int newIdx = (int)list[idx].get(i);
 
    			if(isvisited[newIdx]) continue;		//이미 방문한 곳 패스
    			isvisited[newIdx]=true;
    			queue.add(new int[] {newIdx, depth+1});
    		}
    	}
    }
}