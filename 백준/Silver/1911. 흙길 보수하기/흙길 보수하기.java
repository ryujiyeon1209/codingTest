import java.util.*;

public class Main {
	public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();		//물 웅덩이 개수
		int length = sc.nextInt();	//널판지 길이
		
		//2차원 배열
		int[][] range = new int[n][2];
		
		//물웅덩이 좌표값 받기
		for(int i=0; i<n; i++) {
			range[i][0]=sc.nextInt();
			range[i][1]=sc.nextInt();
		}
		
		//정렬
		Arrays.sort(range, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0]==o2[0]) return o1[1]-o2[1];
				return o1[0]-o2[0];
			}
		});
		
		int count=0;
		int board=0; 
		for(int i=0; i<n; i++) {
			
			int start=range[i][0];
			int end=range[i][1];
			
			//널판지 위치가 웅덩이 시작시점보다 뒤라면, 웅덩이 시작시점부터 널판지 시작
			if(board<start) board=start;
			
			//널판지 위치가 웅덩이 끝지점보다 뒤라면, 새로운 널판지 더하기
			while(board<end) {
				board+=length;
				count++;
			}
		}
		
		//출력
		System.out.println(count);
	}
}