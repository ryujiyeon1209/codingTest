
import java.util.Arrays;
import java.util.*;
import java.util.Scanner;

public class Solution {
	
	static int h, w, n, count, min;
	static int[] choose, r, c;
	static boolean isvisited;
	static int[][] board, tmpboard;
	static Queue<int[]> queue;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=0; t<T; t++) {
			
			n = sc.nextInt();	//구슬을 떨어트릴 수 있는 횟수
			w = sc.nextInt();	//열
			h = sc.nextInt();	//행
			
			//벽돌 배열 생성 및 값 입력받기
			board = new int[h][w];
			for(int i=0; i<h ; i++) {
				for(int j=0; j<w; j++) {
					board[i][j]=sc.nextInt();
				}
			}
			
			//구슬을 떨어트릴 자리
			choose = new int[n];
			
			//사방 탐색
			r = new int[] {0, -1, 0, 1};
			c = new int[] {1, 0, -1, 0};
			
			min = Integer.MAX_VALUE;
			permutation(0);
			
			System.out.printf("#%d %d\n", (t+1), min);
			
		}
	}
	
	//중복순열
	public static void permutation(int idx) {
		
		if(idx==n) {
			
			BFS(choose);
			
			//최소값 구하기
			if(count<min) min=count;
			return;
		}
		
		//중복 순열
		for(int i=0; i<w; i++) {
			choose[idx]=i;
			permutation(idx+1);
		}
	}
	
	//구슬 떨어트리기
	public static void BFS(int[] choose) {
		
		//board 임시배열 생성
		tmpboard= new int[h][w];
		for(int i=0; i<h; i++) {
			tmpboard[i]=board[i].clone();
		}
		
		//구슬을 떨어트리면서, 벽돌이 있는지 확인하기
		for(int tc=0; tc<choose.length; tc++) {
            
			for(int t=0; t<h; t++) {
				if(tmpboard[t][choose[tc]]==0) continue;
				
				//벽돌을 만나면 큐에 넣기
				queue = new LinkedList();
			
				queue.offer(new int[] {t, choose[tc]});
				
				while(!queue.isEmpty()) {
					
					//현재 좌표
					int[] curr= queue.poll();
					
					int i = curr[0];
					int j = curr[1];
					int num=tmpboard[i][j];
					
					//자기 자신을 0으로 바꾼다
					tmpboard[i][j]=0;
					if(num==1) continue;
					
					//값이 1이 아니라면 사방탐색 시작!
					for(int k=0; k<4; k++) {
					int dr = i;
					int dc = j;
					
					//한 방향을 벽돌 크기만큼 하기
					for(int l=0; l<num-1; l++) {
						dr = dr+r[k];
						dc = dc+c[k];
						
						//조건1. 인덱스 범위 확인하기
						if(!(0<=dr && dr<h && 0<=dc && dc<w)) continue;
						
						queue.offer(new int[] {dr, dc});
						
						}
					}
				}
		
                //밑으로 떨어트리기
				down();
				break;
			}
		}
		
		//남은 벽돌 세기
		count=0;
		for(int i=0; i<h; i++) {
			for(int j=0; j<w; j++) {
				if(tmpboard[i][j]>=1) count++;
			}
		}
	}
	
	//밑으로 떨어트리는 메서드
	public static void down() {
		Stack<Integer> stack = new Stack();
				
		//0이 아니면 stack에 넣기
		for(int j=0; j<w; j++) {			
			for(int i=0; i<h; i++) {
				if(tmpboard[i][j]!=0)stack.push(tmpboard[i][j]);
			}
			
			//하나씩 빼면서 아래쪽부터 채우기
			int idx=tmpboard.length-1;
			while(!stack.isEmpty()) {
				tmpboard[idx--][j]=stack.pop();
			}
			
			//남은 칸은 0으로 바꾸기
			for(int i=idx; i>=0; i--) {
				tmpboard[idx--][j]=0;
			}
		}
	}
}
