import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int n, m;
	static int[] arr, choose;
	static StringBuilder sb;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();	//기준 숫자
		m = sc.nextInt();	//숫자 중 내가 고르는 개수
		
		arr = new int[n];	//내가 고를 숫자들이 있는 배열
		for(int i=0; i<arr.length; i++) {
			arr[i]= sc.nextInt();
		}
		
		Arrays.sort(arr);		//사전순으로 출력하기 위해 정렬 필요
		
		choose = new int[m];	//내가 고른 숫자들이 있는 배열
		
		sb = new StringBuilder();
		
		Solution(0,0);
		System.out.println(sb.toString());
	}
	
	//숫자 n개 중에 m개 고르는데, 순서가 있고 중복이 허용 된다 > 중복이 허용된 조합
	public static void Solution(int select, int current) {
		
		//모두 다 골랐다면,
		if(select==m) {
			for(int i=0; i<choose.length; i++) {
				sb.append(choose[i] + " ");
			}
			
			sb.append("\n");
			return;
		}
		
		//탐색이 다 끝났다면
		if(current==n) return;
		
		
		//지금 이 숫자를 선택하고, 다음에도 사용할래!
		choose[select] = arr[current];
		Solution(select+1, current);
		
		//지금 이 숫자를 선택하지 않고, 다음 숫자로 넘어갈래
		choose[select] = 0;
		Solution(select, current+1);
		
		
	}
}
