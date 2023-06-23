import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//배열 생성
		int[] arr = new int[1002]; 
		
		//물이 새는 곳 개수
		int n = sc.nextInt();
	
		//테이프 길이
		int length = sc.nextInt();
		
		//물 새는 곳 입력받기
		for(int i=0; i<n; i++) {
			arr[sc.nextInt()]=1;
		}
		
		//수리하기
		int tape = 0;
		int result = 0;
		for(int i=0; i<arr.length; i++) {
			//수리가 필요한 곳
			if(arr[i]==1 && 0<tape) { tape--; arr[i]=2;}
			else if(arr[i]==1 && tape<=0) { result++; tape=length-1;}  
			
			//수리가 필요 없는 곳
			else if(arr[i]==0 && tape!=length) tape--;
		}
		
		//출력
		System.out.println(result);
	
	}
}
