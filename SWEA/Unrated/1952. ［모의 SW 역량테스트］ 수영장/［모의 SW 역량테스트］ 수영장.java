import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	
	static int min, result, day, month, threemonth, year;
	static boolean[] isvisited;
	static int[] arr, pay, purchase, choose;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=0; t<T; t++) {
			
			day = sc.nextInt();			//일일 이용권
			month = sc.nextInt();		//한달 이용권
			threemonth = sc.nextInt();	//세달 이용권
			year = sc.nextInt();		//일년 이용권
			
			arr = new int[] {0, 1, 2};
			pay = new int[] {day, month, threemonth};	//이용권 가격 배열
			
			purchase = new int[12];			//이용권 배열 표시 
			for(int i=0; i<purchase.length; i++) {
				purchase[i]=sc.nextInt();
				
			}
			
			choose = new int[12];		//이용권을 고른 배열
			
			result = Integer.MAX_VALUE;
			Solution(0);
			
			//출력
			System.out.printf("#%d %d\n", (t+1), result);
			
		}
	}
	
	//무슨 이용권으로 결제할지 결정하는 메서드
	//pay배열로 choose배열을 꽉 채우기 > 순서 영향X > 중복 가능 > 중복 순열
	public static void Solution(int idx) {
		
		if(idx==12) {
			
			int price = 0;
			for(int i=0; i<purchase.length; i++) {
				if(purchase[i]==0) continue;	//수영장을 이용하지 않을 달이라면, 넘어가기
				
				//세달 이용권일 때, 뒤의 두 달을 수영장을 다니는지 확인해 봐야한다!
				if(choose[i]==2) {
					if(i==9 || i==10 || i==11) {
						price+=pay[choose[i]];
						break;
					} else {
						price+=pay[choose[i]];
						i=i+2;
					}			
				}
				
				//한달 이용권일 때,
				if(choose[i]==1) price+=pay[choose[i]];
				
				//일일 이용권일 때,
				if(choose[i]==0) {
					price=price+(purchase[i]*pay[choose[i]]);
				}
				
				//더하고 있는 와중에 최소값보다 비싸면 되돌아가기
				if(price>=result) return;
			}
			
			//일년 이용권일 때,
			int yearPrice = year;
			
			//최소 가격 구하기
			min = Math.min(yearPrice, price);
			result =  Math.min(min, result);
			return;
		}
		
		//중복 순열 구하기 
		//반복문의 종료조건은 내가 선택할 자료의 길이(여기서는 가격의 종류)만큼 반복하는 것이다
		for(int i=0; i<3; i++) {
			choose[idx] = arr[i];
			Solution(idx+1);

		}
	}
}
