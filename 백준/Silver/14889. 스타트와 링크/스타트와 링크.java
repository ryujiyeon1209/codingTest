import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int n, m;
	static int[][] arr;
	static boolean[] isvisited;
	static int[] start, link;
	static int startSum, linkSum, distance, min;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();	//배열 크기 입력받기
		m = n/2;
		
		arr= new int[n][n];	//배열 생성 및 값 입력받기
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr.length; j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		
		
		start = new int[m];	//스타트팀 선수배열
		link = new int[m];	//링크팀 선수 배열
		
		min=Integer.MAX_VALUE;
		
		Combination(0,0);
		System.out.println(min);
	}
	
	//n개 중에 m개 고르기 > 순서 영향X > 조합
	public static void Combination(int select, int current) {
		
		if(select==m) {	//start팀에 m명의 선수들을 뽑았다면, 기저조건 충족
			
			isvisited = new boolean[n];	//새로운 조합이 생길 때마다 isvisited 초기화 필요
			
			for(int i=0; i<start.length; i++) {
				isvisited[start[i]]=true;	//start팀의 선수들을 true처리 해주기
			}
			
			
			int idx=0;	//false인 사람들은 link팀에 넣어주기
			for(int i=0; i<isvisited.length; i++) {
				if(!isvisited[i]) link[idx++]=i;
			}
			
			startSum=0;	//start팀의 누적 능력치 더하기
			linkSum=0;	//link팀의 누적 능력치 더하기
			for(int i=0; i<start.length; i++) {
				for(int j=0; j<start.length; j++) {
					startSum+=arr[start[i]][start[j]];
					linkSum+=arr[link[i]][link[j]];
				}
			}
						
			//각 팀의 능력치 차이 구하기
			distance = Math.abs(startSum-linkSum);
			
			min=Math.min(distance, min);
			return;
		}
		
		if(current==n) return;	//기저조건 중요! 까먹지 말기!
		
		//현재 선수를 start팀에 넣고, 다음 선수 보러가기
		start[select]=current;
		Combination(select+1, current+1);
		
		//현재 선수를 start팀에서 빼고, 다음 선수 보러가기
		start[select]=0;
		Combination(select, current+1);
	}
}
