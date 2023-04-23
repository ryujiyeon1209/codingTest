import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//스트링빌더생성
		StringBuilder sb = new StringBuilder();
		
		//숫자의 개수 입력받기
		int n = sc.nextInt();
		
		//가장 큰 숫자 입력받기
		int max = sc.nextInt();
	
		//2차원 배열 리스트 만들기
		List<int[]> list = new LinkedList();
	
		//리스트에 이미 있는지 확인하기 위한 리스트 만들기
		List<Integer> check = new LinkedList();
		
		//숫자 입력받기
		for(int i=0; i<n; i++){
			int num = sc.nextInt();

			//이미 숫자가 존재할 때
			if(check.contains(num)) {
				int idx = check.indexOf(num);
				list.get(idx)[1]=list.get(idx)[1]+1;
			}
			
			//숫자가 처음 나올 때
			else {
				list.add(new int[] {num, 1, i});
				check.add(num);
			}
		}
		
		//우선순위 큐 생성(1. 숫자의 개수를 내림차순 2. 처음 입력받은 순서 오름차순)
		PriorityQueue<int[]> queue = new PriorityQueue(new Comparator<int[]>() {
			@Override
			public int compare(int[]o1, int[] o2) {
				if(o1[1]==o2[1]) return o1[2]-o2[2];
				else return o2[1]-o1[1];
			}	
		});
		
		//큐에 배열 넣기
		for(int i=0; i<list.size(); i++) {
			queue.add(list.get(i));
		}
		
		//큐에서 배열 빼기
		for(int i=0; i<list.size(); i++) {
			int[] curr = queue.poll();
			
			//숫자의 개수만큼 스트링 빌더에 넣기
			for(int j=0; j<curr[1]; j++) {
				sb.append(curr[0] + " ");
			}
		}
		
		//출력
		System.out.println(sb.toString());
		
	}
}
