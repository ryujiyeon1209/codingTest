import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//레벨의 개수
		int n = sc.nextInt();
		
		//배열 생성 및 값 입력받기
		int[] level = new int[n];
		for(int i=0; i<n; i++) {
			level[i]=sc.nextInt();
		}
		
		//배열 끝부터 앞이 더 작으면 count에 값 더하기
		int count=0;
		for(int i=level.length-1; i>0; i--) {	
			if(level[i-1]>=level[i]) {
				count+=level[i-1]-(level[i]-1);
				level[i-1]=level[i]-1;
			}
		}
		
		//출력
		System.out.println(count);
	}
}
