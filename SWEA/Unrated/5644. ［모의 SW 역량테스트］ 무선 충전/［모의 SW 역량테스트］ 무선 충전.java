import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	
	static int num, result;
	static int[] r, c, nowA, nowB, moveA, moveB;
	static int[][] map, BC;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=0; t<T; t++) {
			
			//지도 배열 생성
			map = new int[10][10];
			
			int distance = sc.nextInt();	//총 이동 거리
			num = sc.nextInt();			//BC의 개수
			
			//A, B가 이동한 방향 > 0 이동X, 1 상, 2 우, 3 하, 4 좌
			moveA = new int[distance];	
			for(int i=0; i<moveA.length; i++) {
				moveA[i]=sc.nextInt();
			}
			
//				System.out.println(Arrays.toString(moveA));
			
			moveB = new int[distance];
			for(int i=0; i<moveB.length; i++) {
				moveB[i]=sc.nextInt();
			}
//				System.out.println(Arrays.toString(moveB));
			
			//BC좌표와 충전 범위
			BC = new int[num][4];
			for(int i=0; i<num; i++) {
				for(int j=0; j<4; j++) {
					BC[i][j]=sc.nextInt();
				}
			}
			
			
			r = new int[] {0, -1, 0, 1, 0};
			c = new int[] {0, 0, 1, 0, -1};
			
			
			//좌표이동으로 더한 합
			result=0;
			
			//A와 B의 처음 좌표
			nowA = new int[2];
			nowB = new int[2];
			
			nowA[0]=1; nowA[1]=1;
			nowB[0]=10; nowB[1]=10;
			
			//처음 시작부터 충전소가 있는지 확인한다.
			int startmax = charge(1, 1, 10, 10);
			result+=startmax;
			
			
			//이제 좌표이동하자 > 델타로 이동하기
			for(int i=0; i<moveA.length; i++) {
				nowA[0]=nowA[0]+r[moveA[i]];
				nowA[1]=nowA[1]+c[moveA[i]];
				
				nowB[0]=nowB[0]+r[moveB[i]];
				nowB[1]=nowB[1]+c[moveB[i]];

				
				int max = charge(nowA[0], nowA[1], nowB[0], nowB[1]);
				result+=max;
			}
			
			//출력
			System.out.printf("#%d %d\n", (t+1), result);
		}
	}

	
	
	//매개변수로 입력받은 좌표가 BC에 들어가나 확인
	public static int getMax(int x, int y, int bcNum) {
			
		if((Math.abs(BC[bcNum][1]-x)+ Math.abs(BC[bcNum][0]-y)) <= BC[bcNum][2]) {
			return BC[bcNum][3];
		}
		else {
			return 0;
		}
	}
	
	public static int charge(int x1, int y1, int x2, int y2) {
		
		//현재 좌표의 값
		int pointA=0; int pointB=0;
		
		//최대값
		int max=0;
		for(int a=0; a<num; a++) {				
			for(int b=0; b<num; b++) {
				
				int sum=0;
				pointA=getMax(x1, y1, a);
				pointB=getMax(x2, y2, b);
			
				//A가 크게 BC를 돌면서 B가 작게 처음부터 끝까지 BC를 탐색한다.
				 if(a!=b) {	//둘의 값이 다르다는 것은 같은 충전소에 없다는 것! a는 A가 있는 충전소의 번호이고 b는 B가 있는 충전소의 번호이므로
					 sum=pointA+pointB;
				 } else {	//둘의 값이 같다는 것은 같은 충전소에 있다는 것! > 어짜피 각자 /2 해야 하니까 그냥 A값을 더해주자
					 sum=Math.max(pointA,pointB);
				 }
				 
				//좌표하나씩 마다 sum과 max 비교해서 가장 큰 값을 max에 넣기
				max = Math.max(max, sum);
		 	}
		}
		return max;
	}
}
