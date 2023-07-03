import java.util.*;
import java.util.Scanner;

public class Main {
	
	static int n, min;
	static int[] arr, people;
	static boolean[] isvisited;
	static List<Integer>[] list;
	static List<Integer> areaA, areaB;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		//조합을 위한 배열
		arr = new int[n+1];
		for(int i=0; i<arr.length; i++) {
			arr[i]=i;
		}
		
		areaA = new ArrayList();		//A구역
		areaB = new ArrayList();		//A구역
		isvisited = new boolean[n+1];	//방문 체크 배열
		
		
		//인구 수 배열 입력받기
		people = new int[n+1];
		for(int i=1; i<n+1; i++) {
			people[i]=sc.nextInt();
		}
	
		//인접 리스트 생성
		list = new List[n+1];
		for(int i=0; i<n+1; i++) {
			list[i]=new ArrayList();
		}
		
		//인접한 도시 입력받기
		for(int i=1; i<n+1; i++) {
			int num = sc.nextInt();	//인접한 도시 개수
			
			for(int j=0; j<num; j++) {
				int city= sc.nextInt();	//인접한 도시
				list[i].add(city);
			}
		}

		min = Integer.MAX_VALUE;
		Solution(0);
		
		//출력
		if(min==Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(min);
	}
	
	
	//조합
	public static void Solution(int idx) {
		
		if(idx>n) {
		
			//선택한 지역 list에 추가
			areaA.clear();
			areaB.clear();
			
			for(int i=1; i<n+1; i++) {
				if(isvisited[i]) areaA.add(i);
				else areaB.add(i);
			}
			
			if((areaA.size()==n) || areaA.size()==0) return;
			
			boolean checkA = BFS(areaA.get(0), "A");	
			boolean checkB = BFS(areaB.get(0), "B");
			
			//구역 인구 차이 계산하기
			int countA=0; int countB=0;
			if(checkA && checkB) {
				for(int i=1; i<isvisited.length; i++) {
					if(isvisited[i])countA+=people[i];
					else countB+=people[i];
				}
				
				if(Math.abs(countA-countB)<min) min = Math.abs(countA-countB);
			}
			return;
		}
		
		if(!isvisited[idx]) {
			
			isvisited[idx]=true;
			Solution(idx+1);
			
			isvisited[idx]=false;
			Solution(idx+1);
		}
	}
	
	
	//BFS
	public static boolean BFS(int idx, String area) {
		
		Queue<Integer> queue = new LinkedList();
		queue.add(idx);
		
		Set<Integer> isConnection = new HashSet();
		isConnection.add(idx);
		
		while(!queue.isEmpty()) {
			
			int city = queue.poll();	//현재 도시
			
			for(int i=0; i<list[city].size(); i++) {
				
				int connection = list[city].get(i);
				

				if(isConnection.contains(connection)) continue;
				
				if(area.equals("A") && (areaA.contains(connection))) {	//A구역으로 선택한 도시라면,
					isConnection.add(connection);
					queue.add(connection);
				}
				
				else if(area.equals("B") && (areaB.contains(connection))) {
					isConnection.add(connection);
					queue.add(connection);
				}
			}
		}
		
		if(area.endsWith("A")) return areaA.size()==isConnection.size();
		else return areaB.size()==isConnection.size();
		
	}
}
