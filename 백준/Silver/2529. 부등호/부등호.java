import java.util.*;
import java.util.Scanner;

public class Main {
	
	static String[] arr;
	static boolean[] isvisited;
	static int[] num, select;
	static String max, min;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		//부등호 개수 입력받기
		int n = sc.nextInt();
		
		//부등호 저장할 배열
		arr = new String[n];
		for(int i=0; i<arr.length; i++) {
			arr[i] = sc.next();
		}
		
		num = new int[] {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
		isvisited = new boolean[num.length];	//방문체크 배열
		select = new int[n+1];					//9개중 고른 숫자를 담을 배열
		
		max = "0"; min = "9876543210";
		permutation(0);
		
		//출력
		System.out.println(max +"\n"+ min);
	}
	
	
	//순열
	public static void permutation(int idx) {
		
		if(select.length<=idx) {
			
			//부등호가 맞는지 확인
			boolean flag = true;
			for(int i=0; i<arr.length; i++) {
				String type = arr[i];
				
				if(type.equals("<") && select[i]>=select[i+1]) { 
					flag = false; 
					break; 
				} else if(type.equals(">") && select[i]<=select[i+1]) {
					flag = false;
					break;
				}
			}
			
			//부등호가 맞다면,
			if(flag) {
				
				String str = "";
				for(int i=0; i<select.length; i++) {
					str+=select[i];
				}
				
				//최대 최소값 비교
				if(Long.parseLong(str)<Long.parseLong(min)) {
					min = str;
				}
				if(Long.parseLong(max)<Long.parseLong(str)) {
					max = str;
				}
			}
			
			return;
		}
		
		
		for(int i=0; i<num.length; i++) {
			if(isvisited[i]) continue;
			
			isvisited[i] = true;
			
			select[idx] = num[i];
			permutation(idx+1);
			
			isvisited[i] = false;
		}
	}
}
