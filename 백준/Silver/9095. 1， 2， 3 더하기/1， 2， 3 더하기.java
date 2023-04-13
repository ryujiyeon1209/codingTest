import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//입력
		int T = sc.nextInt();
		
		// n은 11보다 작기 때문에 즉  n<11 이므로 하나 더 큰 배열 생성
		int[] arr = new int[11];
		
		//점화식을 찾아야함 -> 그러기 위해 규칙을 찾아야함
		//1 : 1가지 -> 1
		//2 : 2가지 -> 1,1 / 2
		//3 : 4가지 -> 1,1,1 / 1,2 / 2,1 / 3
		//4 : 7가지 -> 1,1,1,1 / 1,1,2 / 1,2,1 / 2,1,1 / 1,3 / 3,1 / 2,2
		//5 : 13가지 -> 1,1,1,1,1 / 1,1,1,2 / 1,1,2,1 / 1,2,1,1 / 2,1,1,1 / 1,1,3 /
		//            1,3,1 / 3,1,1 / 1,2,2 / 2,1,2 / 2,2,1 / 2,3 / 3,2
		
		//규칙 : 7 = 4 + 2 + 1
		//	   13 = 7 + 3 + 2

		//구하고자하는 값의 앞에꺼 3개를 구해야하기 때문에 ~3까지는 점화식에 해당(?)되지 않음 / 이걸 초기값이라 하나 ?
		arr[0] = 0;
		arr[1] = 1;
		arr[2] = 2;
		arr[3] = 4;
		
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();
			//그러므로 4 ~ N까지
			for(int i=4; i<=N; i++) {
				//구할 값 = 전 항 + 전전 항 + 전전전 항
				arr[i] = arr[i-1] + arr[i-2] + arr[i-3];
			}
			System.out.println(arr[N]);
			
		}
	}
}