import java.util.*;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//강의 개수
		int n = sc.nextInt();
		
		//배열 생성 및 값 입력받기
		int[][] arr = new int[n][2];
		for(int i=0; i<n; i++) {
			arr[i][0] = sc.nextInt();	//시작 시간
			arr[i][1] = sc.nextInt();	//끝나는 시간
		}
		
		//배열 정렬 
		//1. 시작하는 시간을 기준으로 오름차순으로
		//2. 끝나는 시간을 기준으로 오름차순으로
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0]==o2[0]) return o1[1]-o2[1];
				return o1[0]-o2[0];
			}
		});
		
		//큐 생성 및 첫 강의 끝나는 시간 넣기
		Queue<Integer> queue = new PriorityQueue();
		queue.add(arr[0][1]);
		
		for(int i=1; i<n; i++) {
			//강의 시작시간이 강의 끝나는 시간 보다 늦다면 큐에서 끝나는 시간 빼기
			if(queue.peek()<=arr[i][0]) queue.poll();

			//새롭게 끝나는 시간 큐에 넣기
			queue.add(arr[i][1]);
		}
		
		
		//출력
		System.out.println(queue.size());
	}
}
