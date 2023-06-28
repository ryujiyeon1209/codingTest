import java.util.*;
import java.util.Scanner;

public class Main {	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//배열 크기
		int n = sc.nextInt();
		
		//이동 횟수
		int m = sc.nextInt();
	
		//2차원 배열 생성 및 값 입력받기
		int[][] map = new int[n+1][n+1];
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<n+1; j++) {
				map[i][j]=sc.nextInt();
			}
		}

		//탐색 배열
		int[] r = {0, -1, -1, -1, 0, 1, 1, 1};
		int[] c = {-1, -1, 0, 1, 1, 1, 0, -1};

		
		//구름 생성 초기화
		List<Integer> cloud = new ArrayList();
		cloud.add(n);	cloud.add(1);
		cloud.add(n);	cloud.add(2);
		cloud.add(n-1);	cloud.add(1);
		cloud.add(n-1);	cloud.add(2);
		
		
		
		for(int i=0; i<m; i++) {
			int d = sc.nextInt()-1;	//방향
			int s = sc.nextInt();	//거리

			//1. d방향으로 s칸 이동한다
			for(int p=0; p<cloud.size(); p+=2) {				
				cloud.set(p, cloud.get(p)+(r[d]*s));
				cloud.set(p+1, cloud.get(p+1)+(c[d]*s));			
			}

			//범위 넘어가는 것 조정
			for(int k=0; k<cloud.size(); k++) {
				while(cloud.get(k)<=0) { cloud.set(k, cloud.get(k)+n);}
				while(n<cloud.get(k)) { cloud.set(k, cloud.get(k)-n);}
			}
			
			//구름 좌표 확인 배열
			boolean[][] isvisited = new boolean[n+1][n+1];
			for(int k=0; k<cloud.size(); k+=2) {
				isvisited[cloud.get(k)][cloud.get(k+1)]=true;
			}
			
			//구름 좌표 복새해놓기
			List<Integer> cloud2 = new ArrayList(cloud);
					
			//2. 구름이 있는 칸의 바구니에 저장된 물이 1 증가한다.
			for(int k=0; k<cloud.size(); k+=2) {
				map[cloud.get(k)][cloud.get(k+1)]++;
			}

			//3. 구름이 모두 사라진다
			
			//4. 물복사버그 마법을 실행한다
			for(int k=0; k<cloud.size(); k+=2) {
				for(int p=1; p<8; p+=2) {
					int ddr = cloud.get(k)+r[p];
					int ddc = cloud.get(k+1)+c[p];
					
					if(!(0<ddr && ddr<=n && 0<ddc && ddc<=n)) continue;
					if(map[ddr][ddc]>0) map[cloud.get(k)][cloud.get(k+1)]++;
				}				
			}

			//5. 물의 양이 2 이상이면 물이 2 감소한다 > 3번의 구름 제외
			cloud.clear();

			for(int p=0; p<n+1; p++) {
				for(int k=0; k<n+1; k++) {
				
					if(isvisited[p][k]) continue;
					
					if(map[p][k]>=2) {
						map[p][k]-=2;
						cloud.add(p);
						cloud.add(k);
					}
				}
			}
		}
		
		
		//값 더하기
		int result=0;
		for(int p=1; p<n+1; p++) {
			for(int k=1; k<n+1; k++) {
				result+=map[p][k];
			}
		}
        
        //출력
		System.out.println(result);
		
	}
}
