import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] zeroArr = new int[41];	//0 개수 배열
		int[] oneArr = new int[41];		//1 개수 배열
		
		zeroArr[0]=1;	
		zeroArr[1]=0;
		oneArr[0]=0; 	
		oneArr[1]=1;
		
		for(int i=2; i<41; i++) {
			zeroArr[i]=zeroArr[i-1]+zeroArr[i-2];
			oneArr[i]=oneArr[i-1]+oneArr[i-2];
		}
		
		
		int n = sc.nextInt();
		for(int i=0; i<n; i++) {
			int idx = sc.nextInt();
			
			System.out.println(zeroArr[idx] +" "+ oneArr[idx]);
		}
		
	}
}
