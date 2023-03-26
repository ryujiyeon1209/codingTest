
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	
	static int n, limit;
	static int[] score, cal;
	static boolean[] isvisited;
	static int totalscore, totalcal, max;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=0; t<T ; t++) {		
			
			n = sc.nextInt();		//재료의 개수
			limit = sc.nextInt();	//제한 칼로리
			
			score = new int[n];	//재료에 대한 점수
			cal = new int[n];	//재료의 칼로리
			
			for(int i=0; i<n; i++) {
				score[i]=sc.nextInt();
				cal[i]=sc.nextInt();
			}
			
			isvisited = new boolean[n];	//재료 선택 확인 배열
			
			max=0;	//제한칼로리 이하면서, 맛에 대한 점수가 가장 높은 조합의 점수
			
			subsequence(0);
			System.out.printf("#%d %d\n", (t+1), max);
		}
	}
	
	//재료 n개 중 0~n개 고르기 > 순서 영향X > 부분집합   
	public static void subsequence(int idx) {
		
		if(idx==n) {	//끝까지 탐색했다면
			
			totalcal=0;	//반복문을 돌면서 재료를 선택했다면, 칼로리를 계산하자
			for(int i=0; i<isvisited.length; i++) {
				if(isvisited[i]) { totalcal+=cal[i]; }
			}
			
			totalscore=0;
			if(totalcal<=limit) {	//칼로리가 제한칼로리 이하라면, 맛에 대한 점수를 계산하자
				for(int i=0; i<isvisited.length; i++) {
					if(isvisited[i]) { totalscore+=score[i]; }
				}
			}
			
			max=Math.max(totalscore, max);
			return;
		}
		
		if(!isvisited[idx]) {
			
			//이 재료를 선택하고 다음 재료로 넘어가자
			isvisited[idx]=true;
			subsequence(idx+1);
			
			//이 재료를 취소하고 다음 재료로 넘어가자
			isvisited[idx]=false;
			subsequence(idx+1);
		}
	}
}
