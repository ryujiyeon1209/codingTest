import java.util.*;
import java.util.Scanner;

public class Main {
	
	static int n;
	static List<String>[] list;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//인접리스트 크기
		n = sc.nextInt();
	
		//인접리스트 생성 및 값 입력받기
		list = new List[n];
		for(int i=0; i<n; i++) {
			list[i]=new ArrayList();
		}
		
		//리스트 값 입력받기
		for(int i=0; i<n; i++) {
			for(int j=0; j<3; j++) {
				list[i].add(sc.next());
			}
		}

		//메서드 실행과 출력
		preDFS("A");
		System.out.println();
		
		midDFS("A");
		System.out.println();
		
		backDFS("A");
	}
	
	//전위순회 메서드
	public static void preDFS(String str) {
		
		//종료 조건 > .이면 넘어간다
		if(str.equals(".")) return;
		
		//전위 조건은 자신이 먼저 반환된다
		System.out.print(str);
		
		//재귀 조건 > 입력받은 값이 부모 노드가 되는 리스트로 이동 
		for(int i=0; i<n; i++) {
			if(list[i].get(0).equals(str)) {
				
				//자식노드로 이동하기
				for(int j=1; j<3; j++){
					preDFS(list[i].get(j));
				}
			}
		}
	}
	
	//중위순회 메서드
	public static void midDFS(String str) {
		
		//종료 조건 > .이면 넘어간다
		if(str.equals(".")) { return; }
		
		//재귀 조건 > 입력받은 값이 부모 노드가 되는 리스트로 이동 
		for(int i=0; i<n; i++) {
			if(list[i].get(0).equals(str)) {

				//자식노드로 이동하기
				for(int j=1; j<3; j++){
					if(j==2) {
						//중위 조건은 자신이 자식노드 사이에 반환된다
						System.out.print(str);						
					}
					midDFS(list[i].get(j));
				}					
			}
		}
	}
		
	
	//후위순회 메서드
	public static void backDFS(String str) {
		
		//종료 조건 > .이면 넘어간다
		if(str.equals(".")) { return; }
		
		//재귀 조건 > 입력받은 값이 부모 노드가 되는 리스트로 이동 
		for(int i=0; i<n; i++) {
			if(list[i].get(0).equals(str)) {

				//자식노드로 이동하기
				for(int j=1; j<3; j++){
					backDFS(list[i].get(j));
				}	
				
				//후위 조건은 자신이 마지막에 반환된다
				System.out.print(str);
			}
		}
	}
	
	
}
