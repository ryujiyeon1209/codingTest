
import java.util.*;
import java.util.Scanner;

public class Solution {
	
	static int[] r,c ;
	static int[][] board, arr;
	static ArrayList<int[]> removeIdx;
	static ArrayList<int[]> list;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=0; t<T; t++) {
			
			int n = sc.nextInt();	//셀의 개수
			int m = sc.nextInt();	//격리 시간
			
			board = new int[n][n];	//미생물들 담을 셀
			
			int k = sc.nextInt();	//군집의 개수
			
			list= new ArrayList();//미생물 정보 배열
			for(int i=0; i<k; i++) {
				int r = sc.nextInt();
				int c = sc.nextInt();
				int num = sc.nextInt();
				int direction = sc.nextInt();
				
				list.add(new int[] {r, c, num, direction});
			}
			
			//약품으로 처리할 셀의 좌표들
			for(int i=0; i<n; i++) {
				board[0][i]=100001;
				board[board.length-1][i]=100001;
				board[i][0]=100001;
				board[i][board.length-1]=100001;
			}
			
			
			for(int i=0; i<m; i++) {
				
				//1.방향 확인하기고 이동
				for(int j=0; j<list.size(); j++) {
					
					//현재 좌표
					int[] curr = list.get(j);
					
					if(curr[3]==1) curr[0]=curr[0]-1;			//상
					else if(curr[3]==2) curr[0]=curr[0]+1;	//하
					else if(curr[3]==3) curr[1]=curr[1]-1;	//좌
					else if(curr[3]==4) curr[1]=curr[1]+1;	//우					
				}
				
				//2.만약 이동한 장소가 약품이 칠해진 장소라면, 미생물이 절반이 죽고 이동방향은 반대 방향이 된다.
				for(int j=0; j<list.size(); j++) {
					
					int[] curr = list.get(j);
					
					if(board[curr[0]][curr[1]]==100001) {
						
						//미생물이 절반이 죽고
						curr[2]=curr[2]/2;
						
						//이동방향은 반대가 된다
						if(curr[3]%2==0) { curr[3]=curr[3]-1; }
						else curr[3]=curr[3]+1;
						
					}
				}
				
				//3.서로 같은 셀에 도착하게 된다면, 군집이 합쳐진다
				//(미생물의 수는 미생물 수의 합이며, 방향은 미생물 수가 많은 군집의 이동방향이 된다)
				int[][]tmpboard = new int[n][n]; 
				for(int j=0; j<board.length; j++) {
					tmpboard[j]=board[j].clone();
				}
				for(int j=0; j<list.size(); j++) {
					int[] curr = list.get(j);
					tmpboard[curr[0]][curr[1]]+=1; 
				}

				
				//board값이 1보다 크면 동시에 같은 좌표에 있다는 것
				for(int j=1; j<tmpboard.length-1; j++) {
					for(int l=1; l<tmpboard.length-1; l++) {
						if(tmpboard[j][l]>1) {
							
							removeIdx = new ArrayList();
							
							int dir=0;
							int maxValue=0;
							int sumValue=0;
							for(int t1=0; t1<list.size(); t1++) {
								
								
								int[] curr = list.get(t1);
								if(j==curr[0] && l==curr[1]) {
									if(maxValue<curr[2]) { maxValue = curr[2]; dir = curr[3];}	//방향
									sumValue += curr[2];
									
									//더하고 리스트에서 삭제
									removeIdx.add(curr);
								}
							}
							
							//삭제하고 미생물 최고 값으로 다시 리스트에 넣어주기
							for(int t1=0; t1<removeIdx.size(); t1++) {
								list.remove(removeIdx.get(t1));
							}
							
							list.add(new int[] {j, l, sumValue, dir});
						}
					}
				}
				
				
			}
			
			//미생물 개수 세기
			int result=0;
			for(int i=0; i<list.size(); i++) {
				int[] curr = list.get(i);
				result+=curr[2];
			}
			
			System.out.printf("#%d %d\n", (t+1), result);
			
		}
		
	}
}
