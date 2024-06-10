import java.util.*;

public class Main {
	
	static int n, player, result, answer;
	static int[] choose;
	static boolean[] isvisited;
	static int[][] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		arr = new int[n][9];
		for(int i=0; i<n; i++) {
			for(int j=0; j<9; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		choose = new int[9];
		
		isvisited = new boolean[9];
		isvisited[3] = true;
		
		answer = 0;
		permutation(1);
		
		System.out.println(answer);
	}
	
	//순열
	public static void permutation(int idx) {
		
		if(choose.length<=idx) {		
			result = 0;			//현재 점수
			player = -1;		//선수 인덱스
			for(int i=0; i<n; i++) {
				play(i);
			}

			answer = Math.max(result, answer);
			return;
		}
		
		for(int i=0; i<choose.length; i++) {
			if(isvisited[i]) continue;
			else if(i==3) continue;
			
			isvisited[i] = true;
			choose[i] = idx;
			
			permutation(idx+1);
			
			isvisited[i] = false;
		}
	}
	
	
	//득점 계산하기
	public static void play(int inning) {

		int out = 0;				//아웃 횟수
		int[] cur = new int[5];    //자리에 선수가 있는지
		
		while(out<3) {
			
			//다음 선수
			player = (player+1)%9;
			
			int score = arr[inning][choose[player]];
			cur[0]++;
			
			if(score==1) {
				for(int i=cur.length-2; 0<=i; i--) { 
					if(cur[i]==1) { cur[i+1]++; cur[i]--; }   
				}
			}
			
			else if(score==2) {
				for(int i=cur.length-2; 0<=i; i--) {
					if(cur[i]==1) {
						if(4<i+2) cur[4]++;
						else cur[i+2]++;
						cur[i]--;
					} 
				}
			}
			
			else if(score==3) {
				for(int i=cur.length-2; 0<=i; i--) {
					if(cur[i]==1) {
						if(4<i+3) cur[4]++;
						else cur[i+3]++;
						cur[i]--;
					} 
				}
			}
			
			else if(score==4) {
				for(int i=cur.length-2; 0<=i; i--) {
					if(cur[i]==1) {
						cur[i]--;
						cur[4]++;
					}
				}
			}
						
			else if(score==0) {
				cur[0]--;
				out++;
			}
			
			
			//홈에 들어간다면
			if(0<cur[4]) { result+=cur[4]; cur[4]=0; }
		}	
	}
}
