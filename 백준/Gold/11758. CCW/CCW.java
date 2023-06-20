import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//좌표 3개 입력받기
		int x1 = sc.nextInt();
		int y1 = sc.nextInt();
		
		int x2 = sc.nextInt();
		int y2 = sc.nextInt();
		
		int x3 = sc.nextInt();
		int y3 = sc.nextInt();
	
		
		//CCW 알고리즘
		int result = ((x1*y2)+(x2*y3)+(x3*y1))-((x2*y1)+(x3*y2)+(x1*y3));
		
		
		//시계 방향
		if(result<0) System.out.println(-1);
		
		//반시계 방향
		else if(result>0) System.out.println(1);
		
		//직선
		else if(result==0) System.out.println(0);;
	}
}	
