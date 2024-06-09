import java.util.Scanner;

public class Main {
	
	static int n, k, left, right;
	static int[] map;
	static boolean[] robot;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		k = sc.nextInt();
		
		map = new int[2*n];
		for(int i=0; i<2*n; i++) {
			map[i]=sc.nextInt();
		}
		
		robot= new boolean[n];
		
		left=0;
		right=n;
		
		int count=0;
		while(k>0) {
			count++;
			
			moveBelt();
			moveRobot();
			newRobot();	
		}
		
		//출력
		System.out.println(count);
	}
	
	
	//벨트와 로봇을 함께 한칸 회전
	public static void moveBelt() {
		
		left--;
		right--;
		
		if(left<0) left=2*n-1;
		if(right<0) right=2*n-1;
		
		for(int i=n-2; i>=0; i--) {
			if(robot[i]) {
				robot[i]=false;
				if(i+1<n-1) robot[i+1]=true;
			}
		}
	}
	
	
	//로봇 이동시키기
	public static void moveRobot() {
		
		for(int i=n-2; i>=0; i--) {
			if(robot[i]) {
				int next = left+i+1;
				if(next>=2*n) next-=2*n;
				
				if(!robot[i+1] && map[next]>0) {
					robot[i]=false;
					if(i+1<n-1) robot[i+1]=true;	//n-1이면 로봇을 내리게 된다
					
					map[next]--;
					if(map[next]==0) k--;
				}
			}
		}
	}
	
	
	//새로운 로봇 올리기
	public static void newRobot() {
		
		//올리는 벨트에 로봇이 없고, 내구성이 0보다 크다면,
		if(!robot[0] && map[left]>0) {	
			robot[0]=true;
			map[left]--;
			
			//내구성이 0이 되면
			if(map[left]==0) k--;	
		}
	}
}
