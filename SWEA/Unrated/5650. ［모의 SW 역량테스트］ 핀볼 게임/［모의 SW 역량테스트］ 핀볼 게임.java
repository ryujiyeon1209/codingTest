import java.util.*;
import java.util.Scanner;

public class Solution {
	
	static int result, count;
	static int[][] board;
	static List<int[]>[] wormhole;
	static Queue<int[]> queue;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=0; t<T; t++) {
			
			//배열 크기 입력받기
			int n = sc.nextInt();	
			
			//배열 생성 및 값 입력받기
			board = new int[n+2][n+2];	
			
			//겉 테두리에 5로 감싸주기 > 인덱스 범위 확인 안하기 위해
			for(int i=0; i<board.length; i++) {
				for(int j=0; j<board.length; j++) {
					if(i==0 || i== board.length-1 || j==0 || j==board.length-1) {
						board[i][j]=5;
					} else {
						board[i][j]=sc.nextInt();
					}
				}
			}
			
			//웜홀 배열 생성
			wormhole = new List[5];
			for(int i=0; i<wormhole.length; i++) {
				wormhole[i]= new ArrayList<int[]>();
			}
			
			
			//웜홀 자리 찾기
			for(int i=0; i<board.length; i++) {
				for(int j=0; j<board.length; j++) {
					if(board[i][j]==6) {
						wormhole[0].add(new int[] {i, j});
					} 
					else if(board[i][j]==7) {
						wormhole[1].add(new int[] {i, j});
					}
					else if(board[i][j]==8) {
						wormhole[2].add(new int[] {i, j});
					}
					else if(board[i][j]==9) {
						wormhole[3].add(new int[] {i, j});
					}
					else if(board[i][j]==10) {
						wormhole[4].add(new int[] {i, j});
					} 
				}
			}
			
			//처음부터 탐색하면서 빈자리면, 상하좌우로 사방향으로 탐색
			result=0;
			for(int i=1; i<board.length; i++) {
				for(int j=1; j<board.length; j++) {
					if(board[i][j]==0) {
						for(int k=11; k<15; k++) {
							BFS(new int[] {i, j, k});
							result=Math.max(result, count);
						}
					}
				}
			}
			
			System.out.printf("#%d %d\n", (t+1), result);
		}
	}
	
	public static void BFS(int[] location) {
		
		//처음 자리에 돌아오거나, 블랙홀을 만나면 게임 끝
		count=0;
		
		//큐 생성 및 큐에 출발 좌표 삽입하기
		queue = new LinkedList();
		queue.offer(location);
		
		int startR = location[0];	//출발 좌표 행
		int startC = location[1];	//출발 좌표 열
		int direction = location[2];
		
		//내가 지금 어느 방향이냐에 따라, 삼각형을 만났을 때의 방향도 달라진다.
		Outer:
		while(!queue.isEmpty()) {
			
			int[] curr = queue.poll();
			
			int i = curr[0];	//현재 좌표 행
			int j = curr[1];	//현재 좌표 열
			int dir = curr[2];	//현재 가는 방향
			
			if(dir==11) {	//오른쪽

				int tmpj=j+1;	//오른쪽으로 갈거니까 j를 ++하자
				while(board[i][tmpj]==0) {
					
					//만약 처음 자리로 오거나 블랙홀을 만나면, 그대로 게임 종료
					if((i==startR && tmpj==startC)) { break Outer;}
					else { tmpj++; }
				}

				//1번 도형을 만나면 반대방향으로 바꿔주기
				if(board[i][tmpj]==1 || board[i][tmpj]==2 || board[i][tmpj]==5){	
					count++;
					queue.offer(new int[] {i, tmpj, 12});
				}
				
				//3번 도형을 만나면, 방향을 아래쪽으로 바꿔주자
				else if(board[i][tmpj]==3) {	
					count++;
					queue.offer(new int[] {i, tmpj, 14});
				}
				
				//4번 도형을 만나면, 방향을 위쪽으로 바꿔주자
				else if(board[i][tmpj]==4) {
					count++;
					queue.offer(new int[] {i, tmpj, 13});
				}
				
				//웜홀을 만나면, wormhole메서드 실행 후 다른 웜홀 좌표를 큐에 넣기
				else if(board[i][tmpj]==6 ||  board[i][tmpj]==7 || board[i][tmpj]==8 || board[i][tmpj]==9 || board[i][tmpj]==10) {
					wormhole(new int[] {i, tmpj, 11});	
				}
				
				//블랙홀을 만나면 그대로 종료
				if(board[i][tmpj]==-1) break Outer;
				
				
			} else if(dir==12) {	//왼쪽
				
				int tmpj=j-1;	//왼쪽으로 갈거니까 j를 --하자
				while(board[i][tmpj]==0) {					
					if((i==startR && tmpj==startC)) break Outer;
					else tmpj--;
				}
				
				//3번, 4번, 5번 도형을 만나면 BFS끝
				if(board[i][tmpj]==3 || board[i][tmpj]==4 || board[i][tmpj]==5){	
					count++;
					queue.offer(new int[] {i, tmpj, 11});
				}
				
				//1번 도형을 만나면, 방향을 위쪽으로 바꿔주자
				else if(board[i][tmpj]==1) {	
					count++;
					queue.offer(new int[] {i, tmpj, 13});
				}
				
				//2번 도형을 만나면, 방향을 아래쪽으로 바꿔주자
				else if(board[i][tmpj]==2) {
					count++;
					queue.offer(new int[] {i, tmpj, 14});
				}
				
				//웜홀을 만나면, wormhole메서드 실행 후 다른 웜홀 좌표를 큐에 넣기
				else if(board[i][tmpj]==6 ||  board[i][tmpj]==7 || board[i][tmpj]==8 || board[i][tmpj]==9 || board[i][tmpj]==10) {
					wormhole(new int[] {i, tmpj, 12});
				}
				
				//블랙홀을 만나면 그대로 종료
				if(board[i][tmpj]==-1) break Outer;
				
				
			} else if(dir==13) {	//위쪽
				
				int tmpi=i-1;	//위쪽으로 갈거니까 i를 --하자
				while(board[tmpi][j]==0) {					
					if((tmpi==startR && j==startC)) break Outer;
					else tmpi--;
				}
				
				//1번, 4번, 5번 도형을 만나면 BFS끝
				if(board[tmpi][j]==1 || board[tmpi][j]==4 || board[tmpi][j]==5){	
					count++;
					queue.offer(new int[] {tmpi, j, 14});
				}
				
				//2번 도형을 만나면, 방향을 오른쪽으로 바꿔주자
				else if(board[tmpi][j]==2) {
					count++;
					queue.offer(new int[] {tmpi, j, 11});
				}
				
				//3번 도형을 만나면, 방향을 왼쪽으로 바꾸기
				else if(board[tmpi][j]==3) {
					count++;
					queue.offer(new int[] {tmpi, j, 12});
				}
				
				//웜홀을 만나면, wormhole메서드 실행 후 다른 웜홀 좌표를 큐에 넣기
				else if(board[tmpi][j]==6 ||  board[tmpi][j]==7 || board[tmpi][j]==8 || board[tmpi][j]==9 || board[tmpi][j]==10) {
					wormhole(new int[] {tmpi, j, 13});		
				}
				
				//블랙홀을 만나면 그대로 종료
				if(board[tmpi][j]==-1) break Outer;
				
			} else if(dir==14) {	//아래쪽
				
				int tmpi=i+1;	//으로 갈거니까 i를 ++하자
				while(board[tmpi][j]==0) {					
					if((tmpi==startR && j==startC)) break Outer;
					else tmpi++;
				}
				
				//2번, 3번, 5번 도형을 만나면 BFS끝
				if(board[tmpi][j]==2 || board[tmpi][j]==3 || board[tmpi][j]==5){	
					count++;
					queue.offer(new int[] {tmpi, j, 13});
				}
				
				//1번 도형을 만나면, 방향을 오른쪽으로 바꿔주자
				else if(board[tmpi][j]==1) {
					count++;
					queue.offer(new int[] {tmpi, j, 11});
				}
				
				//4번 도형을 만나면, 방향을 왼쪽으로 바꾸기
				else if(board[tmpi][j]==4) {
					count++;
					queue.offer(new int[] {tmpi, j, 12});
				}	
				
				//웜홀을 만나면, wormhole메서드 실행 후 다른 웜홀 좌표를 큐에 넣기
				else if(board[tmpi][j]==6 ||  board[tmpi][j]==7 || board[tmpi][j]==8 || board[tmpi][j]==9 || board[tmpi][j]==10) {
					wormhole(new int[] {tmpi, j, 14});	
				}
				
				//블랙홀을 만나면 그대로 종료
				if(board[tmpi][j]==-1) break Outer;
			}
		}
	}
	
	public static void wormhole(int[] location) {
		
		int i=location[0];
		int j=location[1];
		int direction = location[2];
		
		//6번 웜홀을 만나면, 다른 자리에 있는 6번 웜홀을 찾자
		if(board[i][j]==6) {
			for(int idx=0; idx<wormhole[0].size(); idx++) {
				int[] iswormhole = wormhole[0].get(idx);
				
				//자리다 다른 6번 웜홀을 찾았다면, 큐에 넣기
				if(iswormhole[0]!=i ||iswormhole[1]!=j ) {
					queue.offer(new int[] {iswormhole[0], iswormhole[1], direction});
				}
			}
		}

		//7번 웜홀을 만나면, 다른 자리에 있는 7번 웜홀을 찾자
		else if(board[i][j]==7) {
			for(int idx=0; idx<wormhole[1].size(); idx++) {
				int[] iswormhole = wormhole[1].get(idx);
				if(iswormhole[0]!=i ||iswormhole[1]!=j ) {
					queue.offer(new int[] {iswormhole[0], iswormhole[1], direction});
				}
			}
		}
		
		//8번 웜홀을 만나면, 다른 자리에 있는 8번 웜홀을 찾자
		else if(board[i][j]==8) {
			for(int idx=0; idx<wormhole[2].size(); idx++) {
				int[] iswormhole = wormhole[2].get(idx);
				if(iswormhole[0]!=i ||iswormhole[1]!=j ) {
					queue.offer(new int[] {iswormhole[0], iswormhole[1], direction});
				}
			}
		}
		
		//9번 웜홀을 만나면, 다른 자리에 있는 9번 웜홀을 찾자
		else if(board[i][j]==9) {
			for(int idx=0; idx<wormhole[3].size(); idx++) {
				int[] iswormhole = wormhole[3].get(idx);
				if(iswormhole[0]!=i ||iswormhole[1]!=j ) {
					queue.offer(new int[] {iswormhole[0], iswormhole[1], direction});
				}
			}
		}
		
		//10번 웜홀을 만나면, 다른 자리에 있는 10번 웜홀을 찾자
		else if(board[i][j]==10) {
			for(int idx=0; idx<wormhole[4].size(); idx++) {
				int[] iswormhole = wormhole[4].get(idx);
				if(iswormhole[0]!=i ||iswormhole[1]!=j ) {
					queue.offer(new int[] {iswormhole[0], iswormhole[1], direction});
				}
			}
		}
	}
}
