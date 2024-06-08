import java.util.*;

public class Main {
	
	static int n;
	static int[] r, c;
	static int[][] map;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		map = new int[n][n];
		
		r = new int[] {1, 0, -1, 0};
		c = new int[] {0, -1, 0, 1};
		
		//인접 리스트
		List[] friend = new List[(n*n)+1];
		for(int i=0; i<friend.length; i++) {
			friend[i] = new ArrayList();
		}
		
		//좋아하는 학생 번호 입력받기
		for(int t=0; t<n*n; t++) {
			
			int num = sc.nextInt();
			
			for(int i=0; i<4; i++) {
				friend[num].add(sc.nextInt());
			}
		
			//조건 1 : 좋아하는 친구가 많은 자리인지 확인
			List<int[]> result = check1(friend[num]);
			if(result.size()==1) {
				map[result.get(0)[0]][result.get(0)[1]] = num;
				continue;
			}
			
			//조건 2 : 인접한 자리가 비어있는지 확인
			List<int[]> result2 = check2(result);
			if(result2.size()==1) {
				map[result2.get(0)[0]][result2.get(0)[1]] = num;
				continue;
			}
			
			//조건 3 : 행열이 작은 자리인지 확인
			int[] result3 = check3(result2);
			map[result3[0]][result3[1]] = num;
		}

		
		//만족도 확인
		int answer = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {

				int num = map[i][j];
				
				int count = 0;
				for(int k=0; k<4; k++) {
					int dr = i+r[k];
					int dc = j+c[k];
					
					if(!(0<=dr && dr<n && 0<=dc && dc<n)) continue;
					if(friend[num].contains(map[dr][dc])) count++;					
				}
				
				if(count==1) answer+=1;
				else if(count==2) answer+=10;
				else if(count==3) answer+=100;
				else if(count==4) answer+=1000;
			}
		}
		
		//출력
		System.out.println(answer);
	}
	
	
	//조건 1
	public static List<int[]> check1(List<Integer> friend) {

		int[][] tmp = new int[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				tmp[i][j]=-1;
			}
		}
		
		int max = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j]!=0) continue;
				
				tmp[i][j]=0;
				for(int k=0; k<4; k++) {
					int dr = i+r[k];
					int dc = j+c[k];
					
					if(!(0<=dr && dr<n && 0<=dc && dc<n)) continue;
					if(friend.contains(map[dr][dc])) tmp[i][j]++;
					
				}
				
				max = Math.max(max, tmp[i][j]);
			}
		}
		
		List<int[]> list = new ArrayList();
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(tmp[i][j]==max) list.add(new int[] {i, j});
			}
		}

		return list;
	}
	
	//조건 2
	public static List<int[]> check2(List<int[]> candi) {
		
		int[][] tmp = new int[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				tmp[i][j]=-1;
			}
		}
		
		int max = 0;
		for(int t=0; t<candi.size(); t++) {
			int[] seat = candi.get(t);
			
			int i = seat[0];
			int j = seat[1];
			tmp[i][j]=0;
			
			for(int k=0; k<4; k++) {
				int dr = i+r[k];
				int dc = j+c[k];
				
				if(!(0<=dr && dr<n && 0<=dc && dc<n)) continue;
				if(map[dr][dc]==0) tmp[i][j]++;
			}
			
			max = Math.max(max, tmp[i][j]);
		}
		
		List<int[]> list = new ArrayList();
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(tmp[i][j]==max) list.add(new int[] {i, j});
			}
		}
		
		return list;
	}
	
	//조건 3
	public static int[] check3(List<int[]> candi) {
		
		int r = Integer.MAX_VALUE;
		int c = Integer.MAX_VALUE;
		
		for(int t=0; t<candi.size(); t++) {
			int[] seat = candi.get(t);
			
			int i = seat[0];
			int j = seat[1];
			
			if(i<r) {
				r = i;
				c = j;
			}
			
			else if(i==r && j<c) {
				r = i;
				c = j;
			}
		}
		
		return new int[] {r, c};
	}
}
