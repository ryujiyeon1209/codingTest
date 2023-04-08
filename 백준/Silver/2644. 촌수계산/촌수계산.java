import java.util.*;
import java.util.Scanner;

public class Main {
    
    static int n, p1, p2, result, degree;
    static boolean[] isvisited;
    static List<Integer>[] list;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();	//총 사람의 수
        
        p1=sc.nextInt();	//촌수 계산해야 할 사람1	
        p2=sc.nextInt();	//촌수 계산해야 할 사람2

        //인접 그래프 생성 및 초기화
        list = new ArrayList[n+1];
        for(int i=0; i<list.length; i++) {
        	list[i]=new ArrayList<Integer>();
        }
        
        
        //그래프 생성 및 관계 표시하기
        int f = sc.nextInt();
        for(int i=0; i<f; i++) {
        	int parent = sc.nextInt();
        	int child = sc.nextInt();
        	
        	list[child].add(parent);
        	list[parent].add(child);
        }
        
        //방문체크배열
        isvisited = new boolean[n+1];
        
        result=-1;        	
        
        //부모자식 관계인지 확인하기
        if(list[p1].contains(p2)) { result = 1;}
        else { DFS(p1, p2, 0); }
        
        //출력
        System.out.println(result);
    }
    

    public static void DFS(int start, int end, int degree) {


    	//우리가 찾는 사람이었다면, 재귀 멈추기
    	if(start==end) { result=degree; return;}
    	
    	//한 번 방문했던 곳이면, 재귀 멈추기
    	if(isvisited[start]) return;	
    	
    	//방문한 적 없다면 방문처리
    	isvisited[start]=true;
    	
    	//부모와 연결되어 있는 자식들의 자식들을 탐색하기
    	for(int i=0; i<list[start].size(); i++) {   
    		DFS(list[start].get(i), end, degree+1);
    	}
    }
    
}