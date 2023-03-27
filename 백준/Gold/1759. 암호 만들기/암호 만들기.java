import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int l, c;
	static char[] arr, choose;
	static boolean[] isvisited;
	static StringBuilder sb;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		l = sc.nextInt();	//뽑아야 하는 알파벳의 개수
		c = sc.nextInt();	//알파벳의 개수
		
		arr = new char[c];
		for(int i=0; i<arr.length; i++) {
			arr[i]= sc.next().charAt(0);
		}
		
		Arrays.sort(arr);	//사전순으로 출력 위해 		
		
		choose = new char[l];	//고른 알파벳들 배열
		
		sb = new StringBuilder();
		
		combination(0,0);
		System.out.println(sb.toString());
	}
	
	//서로 다른 n개 중에 m개를 고르는 것 > 순서 영향X > 조합
	public static void combination(int select, int current) {
		
		if(select == l) {	//알파벳을 모두 골랐다면,
			
			boolean flag = true;
			int x = 0;	int y = 0;	//자음과 모음 확인 변수
			
			String str = "";	//알파벳을 하나의 문자열로 만든다
			for(int i=0; i<choose.length; i++) {
				
				//자음 모음 확인
				if(choose[i]=='a' || choose[i]=='e' || choose[i]=='i' || choose[i]=='o' || choose[i]=='u') {
					x++;	//모음
				} else {
					y++;	//자음
				}
				
				//모음이 c-2이거나 자음이 c-1이상이 넘으면, 최소
				if(l-2<x || l-1<y) flag = false;
			}
			
			if(flag) {
				for(int i=0; i<choose.length; i++) {
					sb.append(choose[i]);
				}
				sb.append("\n");
			}
			
			return;
		}
		
		
		if(current==c) return;	//탐색을 모두 마쳤다면,
		
		//지금 알파벳을 고르고, 다음 알페밧으로 넘어가기
		choose[select] = arr[current];
		combination(select+1, current+1);
		
		//지금 알파벳을 취소하고, 다음 알파벳으로 넘어가기
		choose[select] = 0;
		combination(select, current+1);
	}
}
