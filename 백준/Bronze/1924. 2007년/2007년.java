import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] week = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
		
		int month = sc.nextInt();
		int day = sc.nextInt();
		
		//1월 1일부터 날짜 세기
		int sum = day;
		for(int i=1; i<month; i++) {
			if(i==2) sum+=28;
			else if(i==2 || i==4 ||i==6 ||i==9 ||i==11) sum+=30;
			else sum+=31;
		}
		
		
		//출력
		System.out.println(week[sum%7]);
	}
}
