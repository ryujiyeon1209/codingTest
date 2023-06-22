import java.util.*;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//가로수 개수 입력받기
		int n = sc.nextInt();
		
		//배열 생성 및 값 입력받기
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i]=sc.nextInt();
		}
		
		//배열 생성 및 값 차이 저장하기
		int[] distance = new int[n-1];
		for(int i=0; i<n-1; i++) {
			distance[i]=arr[i+1]-arr[i];
		}
		
		//정렬
		Arrays.toString(distance);
		
		//가장 첫 최대공약수 구하기
		int tmp = gcd(distance[0], distance[1]);
		
		//최소 최대공약수 구하기
		int min=tmp;
		for(int i=2; i<distance.length-1; i++) {
			int num = gcd(tmp, distance[2]);
			if(num<min) min=tmp;
		}
		
		//최대공약수와 차이 더하기
		int result=0;
		for(int i=0; i<distance.length; i++) {
			result+=(distance[i]/min)-1;
		}
		
		//출력
		System.out.println(result);
	}
	
	
	
	//최대공약수 매서드
	public static int gcd(int x, int y) {
		if(x%y==0) return y;
		else return gcd(y, x%y);
	}
}
