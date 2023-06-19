import java.util.Scanner;

public class Main {
	
	static int n;
	static int[][] arr;
	
	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		
		//행열의 크기
		n = sc.nextInt();
	
		//제곱의 크기
		long b = sc.nextLong();
		
		//2차원 배열 생성 및 값 입력받기
		int[][] arr = new int[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				//B가 1일 때를 대비하기 위해 %1000 계산
				arr[i][j]=sc.nextInt()%1000;	
			}
		}
		
		//매서드 실행
		int[][] result = Solution(arr, b);
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				sb.append(result[i][j] +" ");
			}
			sb.append("\n");
		}
		
		//출력
		System.out.println(sb.toString());
	}
	
	
	//행렬 계산
	public static int[][] Solution(int[][] arr, long exp) {
		
		if(exp<=1L) return arr;
		
		int[][] tmp = Solution(arr, exp/2);
		
		tmp = multiply(tmp, tmp);				//짝수
		if(exp%2!=0) tmp = multiply(arr, tmp);	//홀수
		
		return tmp;
	}
	
	
	//행렬 곱하기 계산
	public static int[][] multiply(int[][] o1, int[][] o2){
		int[][] ret = new int[n][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				for(int k=0; k<n; k++) {
					ret[i][j]+=(o1[i][k]*o2[k][j]);
					ret[i][j]%=1000;
				}
			}
		}
		
		return ret;
		
	}
}