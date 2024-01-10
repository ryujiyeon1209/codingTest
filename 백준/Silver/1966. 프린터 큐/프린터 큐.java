import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int test = sc.nextInt();
		for(int t=0; t<test; t++) {
			int n = sc.nextInt();
			int idx = sc.nextInt();
			
			//순서를 담을 배열
			int[] arr = new int[n];
			
			//중요도 정렬할 배열
			List<Integer> list = new ArrayList(); 
			
			//큐에 순서와 중요도 삽입하기
			Queue<int[]> queue = new LinkedList();
			for(int i=0; i<n; i++) {
				int imp = sc.nextInt();
				
				queue.offer(new int[] {i, imp});
				list.add(imp);
			}
			
			//내림차순 정렬
			Collections.sort(list, new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					return o2-o1;
				}
			});
			
			//중요도 확인하고, 프린트하기
			int count=0;
			while(!queue.isEmpty()) {
				int[] curr = queue.poll();
				
				if(curr[1]==list.get(0)) {
					list.remove(0);
					arr[curr[0]] = count++;
				}
				else {
					queue.offer(curr);
				}
			}
			
			//출력
			System.out.println(arr[idx]+1);
		}
	}
}
