import java.util.*;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		//터널로 들어간 자동차 개수
		int n = sc.nextInt();
		
		//배열 생성 및 값 넣어주기 (터널 입구에서 본 차)
		Queue<String> entrance = new LinkedList();
		for(int i=0; i<n; i++) {
			entrance.offer(sc.next());
		}

		//큐 생성 및 값 넣어주기 (터널 출구에서 본 차)
		Queue<String> exit = new LinkedList();
		for(int i=0; i<n; i++) {
			exit.offer(sc.next());
		}
        
		int count=0;	//추월 횟수

		//큐가 공백이 될 때까지 반복문 진행
		while(!exit.isEmpty()) {
			String car = exit.peek();
			
			
			//입구의 순서와 출구의 순서가 같다면,
			if(entrance.peek().equals(car)) { entrance.poll(); exit.poll();}
			
			//입구의 순서와 출구의 순서가 다르다면
			else {
				if(exit.contains(entrance.peek())) { count++; exit.poll(); }
				else { entrance.poll(); }
			} 
		}
		
		//출력
		System.out.println(count);

	}
}
