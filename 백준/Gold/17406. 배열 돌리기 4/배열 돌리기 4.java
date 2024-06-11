import java.util.*;

public class Main {
	
	static int h, w, k, answer;
	static int[] choose;
	static int[][] map, arr;
	static boolean[] isvisited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		h = sc.nextInt();	//높이
		w = sc.nextInt();	//너비
		k = sc.nextInt();	//회전 수
		
		//배열 정보 받기
		map = new int[h][w];
		for(int i=0; i<h; i++) {
			for(int j=0; j<w; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		//회전 정보 받기
		arr = new int[k][3];
		for(int i=0; i<k; i++) {
			arr[i][0] = sc.nextInt()-1;
			arr[i][1] = sc.nextInt()-1;
			arr[i][2] = sc.nextInt();
		}
		
		choose = new int[k];
		isvisited = new boolean[k];
		
		answer = Integer.MAX_VALUE;
		permutation(0);
		
		//출력
		System.out.println(answer);
	}
	
	//순열
	public static void permutation(int idx) {
		
		if(k<=idx) {
			//배열 복사
			int[][] tmp = new int[h][w];
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					tmp[i][j] = map[i][j];
				}
			}

			//회전 메서드
			for(int t=0; t<choose.length; t++) {
				int r = arr[choose[t]][0];
				int c = arr[choose[t]][1];
				int s = arr[choose[t]][2];
				
				while(0<s) {
					tmp = rotation(tmp, r, c, s);
					s--;
				}
			}
			
			//배열 a 계산
			int result = check(tmp);
			answer = Math.min(answer, result);
			return;
		}
		
		
		for(int i=0; i<choose.length; i++) {
			if(isvisited[i]) continue;
			
			isvisited[i]=true;
			choose[i] = idx;
			
			permutation(idx+1);
			isvisited[i]=false;
		}
	}
	
	//배열 돌리기
	public static int[][] rotation(int[][] tmp, int r, int c, int s) {
		Queue<Integer> queue = new LinkedList<>();
		
		int startr = r-s;
		int startc = c-s;
		
		int endr = r+s;
		int endc = c+s;
			
		int start = tmp[startr][startc];
		
		//위쪽에서 아래쪽
		for(int i=startr+1; i<=endr; i++) {
			tmp[i-1][startc] = tmp[i][startc];
		}

		//왼쪽에서 오른쪽
		for(int i=startc+1; i<=endc; i++) {
			tmp[endr][i-1] = tmp[endr][i];
		}
		
		//아래쪽에서 위쪽으로
		for(int i=endr-1; startr<=i; i--) {
			tmp[i+1][endc] = tmp[i][endc];
		}
		
		//오른쪽에서 왼쪽으로
		for(int i=endc-1; startc<=i; i--) {
			if(i==startc) tmp[startr][i+1]=start;
			else tmp[startr][i+1] = tmp[startr][i];
		}

		return tmp;
	}
	
	
	//배열 a값 구하기
	public static int check(int[][] tmp) {
		
		int min = Integer.MAX_VALUE;
		for(int i=0; i<h; i++) {
			
			int sum = 0;
			for(int j=0; j<w; j++) {
				sum+=tmp[i][j];
			}
			
			min = Math.min(min, sum);
		}
		
		return min;
	}
	
}
