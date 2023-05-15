import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//트럭의 개수 입력받기
		int n = sc.nextInt();
		
		//다리의 길이
		int distance = sc.nextInt();
		
		//다리의 최대하중
		int maxWeight = sc.nextInt();
		
		//트럭의 무게 큐
		Queue<Integer> truck = new LinkedList();
		for(int i=0; i<n; i++) {
			truck.add(sc.nextInt());
		}

		//현재 도로가 가지고 있는 트럭무게
		int roadweight=0;
		Queue<Integer> road  = new LinkedList();		
		for(int i=0; i<distance; i++){
			road.add(0);
		}
		
		int time=0;
		while(!truck.isEmpty()) {
			
			time++;
			roadweight-=road.poll();
			
			int curr = truck.peek();
			
			//현재 트럭이 도로에 가도 된다면,
			if(curr+roadweight<=maxWeight) {
				roadweight+=curr;
				truck.poll();
				road.add(curr);
			}
			
			//현재 트럭이 다리에 어디쯤 와있는 계산하기 위해
			else {
				road.add(0);
			}
		}

		//while문이 마지막 트럭이 들어가자마자 종료되므로 다리 길이만큼 더해준다
		time+=road.size();
		
		//출력
		System.out.println(time);
		
	}
}
