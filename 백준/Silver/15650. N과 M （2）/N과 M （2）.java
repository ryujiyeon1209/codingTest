import java.util.Scanner;

public class Main {
	
	static int n;
	static int m;
	static int[] arr;
	static int[] choose;
	//중복없이, 사전 순서대로, m개 고르기 > 조합
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();	//기준 숫자
		m = sc.nextInt();	//숫자 중 고르는 개수
		
		arr = new int[n];		//내가 고를 숫자들이 있는 배열
		for(int i=0; i<arr.length; i++) { arr[i]=i+1; }
		
		choose = new int[m];	//내가 고른 숫자들이 있는 배열
		
		Combination(0, 0);
	}
	
	public static void Combination(int select, int current) {
		
		//m개 골랐으면, 재귀 멈추기
		if(select==m) {
			for(int i=0; i<choose.length; i++) {
				System.out.print(choose[i] + " ");
			}
			System.out.println();
			return;
		}
		
		//arr배열 탐색 끝났으면, 재귀 멈추기
		if(current==n) return;
		
		//현재 숫자 선택하고 다음으로 넘어가기
		choose[select] = arr[current];
		Combination(select+1, current+1);
		
		choose[select] = 0;
		Combination(select, current+1);

	}
}
