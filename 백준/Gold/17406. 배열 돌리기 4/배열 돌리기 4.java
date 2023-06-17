import java.util.*;

public class Main {
	
	static int n, m, k, min;
	static int[][] arr, tmp;
	static List<Integer>[] list, choose;
	static boolean[] isvisited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		k = sc.nextInt();
		
		//배열 생성 및 값 입력받기
		arr = new int[n+1][m+1];
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<m+1; j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		
		//임시 배열 복사
		tmp = new int[n+1][m+1];
		for(int i=0; i<n+1; i++) {
			tmp[i]=arr[i].clone();
		}
		
		//회전 리스트 배열 생성
		list = new ArrayList[k];
		choose = new ArrayList[k];
		
		for(int i=0; i<k; i++) {
			list[i]=new ArrayList();

			list[i].add(sc.nextInt());	//기준 r
			list[i].add(sc.nextInt());	//기준 c
			list[i].add(sc.nextInt());	//범위 s
		}
		
		//방문 체크 배열
		isvisited = new boolean[k];
		
		min=Integer.MAX_VALUE;
		permutation(0);
		
		//출력
		System.out.println(min);
	}
	
	
	//순열
	public static void permutation(int idx) {
		
		if(idx>=k) {
			for(int i=0; i<k; i++) {
				Solution(choose[i].get(0), choose[i].get(1), choose[i].get(2));
			}
			
			//최소값 구하기
			for(int i=1; i<n+1; i++) {
				int sum=0;
				for(int j=1; j<m+1; j++) {
					sum+=arr[i][j];
				}
				min=Math.min(min, sum);
			}

			//다시 tmp값을 arr로 복사
			for(int i=0; i<n+1; i++) {
				arr[i]=tmp[i].clone();
			}
			return;
		}
		
        
		for(int i=0; i<k; i++) {
			if(isvisited[i]) continue;
			
			isvisited[i]=true;
			choose[idx]=list[i];
			permutation(idx+1);
			
			isvisited[i]=false;
			
		}
	} 
	
	
	//배열 옮기기
	public static void Solution(int r, int c, int s) {
		
		//큐 생성 
		Queue<Integer> queue = new LinkedList();

		int startR = r-s;
		int startC = c-s;
		int endR = r+s;
		int endC = c+s;
		
		while(startR<endR) {

			//왼쪽에서 오른쪽
			for(int j=startC; j<=endC; j++) {
				if(queue.isEmpty()) queue.add(arr[startR][j]);
				else {
					queue.add(arr[startR][j]);
					arr[startR][j]=queue.poll();
				}
			}
			
			//위에서 아래로
			for(int j=startR+1; j<=endR; j++) {
				if(queue.isEmpty()) queue.add(arr[j][endC]);
				else {
					queue.add(arr[j][endC]);
					arr[j][endC]=queue.poll();
				}
			}
			
			//오른쪽에서 왼쪽으로
			for(int j=endC-1; j>=startC; j--) {
				if(queue.isEmpty()) queue.add(arr[endR][j]);
				else {
					queue.add(arr[endR][j]);
					arr[endR][j]=queue.poll();
				}
			}
			
			//아래서 위로
			for(int j=endR-1; j>=startR; j--) {
				if(queue.isEmpty()) queue.add(arr[j][startC]);
				else {
					queue.add(arr[j][startC]);
					arr[j][startC]=queue.poll();
				}
            }
			
			startR++;
			startC++;
			endR--;
			endC--;
		}
	}
}
