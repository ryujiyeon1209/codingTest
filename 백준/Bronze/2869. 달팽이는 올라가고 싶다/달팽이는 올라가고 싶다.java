import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//낮, 밤, 목표 입력받기
		int day = sc.nextInt();
		int night = sc.nextInt();
		int goal = sc.nextInt();
		
		//날짜
		//달팽이는 목표까지 낮에 도달할 것이다.
		//그러므로 목표에서 낮에 움직일 수 있는 거리를 뺀다면, 낮-밤으로 며칠 걸리는지 계산할 수 있다.
		//그리고 그 다음날 낮에 목표에 도달할 것이다.
		long count =0;	
		count = (long) Math.ceil((goal-day)*1.0/(day-night));
		
		//출력
		System.out.println(count+1);
	}
}
