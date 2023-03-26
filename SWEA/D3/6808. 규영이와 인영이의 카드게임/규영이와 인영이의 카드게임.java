
import java.util.Scanner;

public class Solution {
	
	static int[] i_arr, g_arr;
	static int g_sum, i_sum;
	static int g_win, i_win;
	static boolean[] isvisited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=0; t<T; t++) {
			
			i_arr = new int[9];	//인영이가 내는 카드
			
			g_arr = new int[9]; //규영이가 내는 카드
			for(int i=0; i<g_arr.length; i++) {
				g_arr[i]=sc.nextInt();
			}
			
			isvisited = new boolean[19];
			for(int i=0; i<g_arr.length; i++) {
				isvisited[g_arr[i]]=true;
			}
			
			g_win=0; i_win=0;
			permutation(0);
			
			System.out.printf("#%d %d %d\n", (t+1), g_win, i_win);
		}
	}
	
	//n개 중에서 m개 고르기 > 순서 영향O > 순열
	public static void permutation(int idx) {
		
		if(idx==9) {	//모든 카드를 다 골랐다면,
			
			g_sum=0; i_sum=0;	//둘이 낸 숫자를 비교해서 높은 숫자를 낸 사람이 카드의 합을 가져가기
			for(int i=0; i<g_arr.length; i++) {	
				if(g_arr[i]>i_arr[i]) g_sum+=(g_arr[i] + i_arr[i]);
				else if(g_arr[i]<i_arr[i]) i_sum+=(g_arr[i] + i_arr[i]);
			}
			
			if(g_sum>i_sum) g_win++;
			else if(g_sum<i_sum) i_win++;
			return;
		}
		
		for(int i=1; i<isvisited.length; i++) {
			
			//규영이의 카드이거나, 인영이가 이미 고른 카드라면, 넘어가기 (중요)
			if(isvisited[i]) continue;	
			
			isvisited[i]=true;
			i_arr[idx]=i;	//인영이의 카드 배열에 값 넣기
			
			permutation(idx+1);
			isvisited[i]=false;	//원상복구
		}
	}
}
