import java.util.*;
import java.util.Scanner;

public class Main {
	
	static boolean flag;
	static int result;
	static int[] r, c;
	static char[][] board;
	static Queue<int[]> queue; 
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//뿌요 배열
		char[] puyo = new char[] {'R', 'G', 'B', 'P', 'R'};
		
		//사방탐색 배열
		r = new int[]{0, 1, 0, -1};
		c = new int[]{1, 0, -1, 0};
		
		//배열 생성 및 값 입력받기
		board = new char[12][6];
		for(int i=0; i<12; i++) {
			String str = sc.next();
			for(int j=0; j<6; j++) {
				board[i][j]=str.charAt(j);
			}
		}
		
		result=0;
		
		do {
			
			//0번 열부터 밑으로 내려가면서 .이면 넘어가고 뿌요면 BFS시작!
			flag = false;
			for(int j=0; j<6; j++) {
				for(int i=0; i<12; i++) {
					if(board[i][j]=='.') continue;	
					BFS(new int[] {i, j});				
				}			
			}
			
            //한 번의 탐색이 끝나고, 아래로 떨어트린 후 flag가 true라면 reuslt를 +1해주자
			down();
			if(flag) result++;	
		} while(flag==true);
		
		System.out.println(result);
	}
	
    //뿌요로 인해 연쇄가 발생하는지 확인하는 메서드
	public static void BFS(int[] location) {	
		//큐 생성
		queue = new LinkedList();
		
		//방문 처리 배열
		boolean[][] isvisited = new boolean[12][6];
		
		//큐에 값 넣기
		queue.offer(location);
		isvisited[location[0]][location[1]]=true;
		
		int count=1;
		
		while(!queue.isEmpty()) {
			
			int[] curr = queue.poll();
			
			int i = curr[0];	//행
			int j = curr[1];	//열
			char color = board[i][j];	//색깔
			
			
			//사방탐색 시작
			for(int k=0; k<4; k++) {
				
				int dr = i+r[k];
				int dc = j+c[k];
				//조건 확인하기, 인덱스 범위 체크
				
				if(!(0<=dr && dr<12 && 0<=dc && dc<6)) continue;
				if(isvisited[dr][dc]) continue;
				
				//조건이 맞다면, 색깔이 같은지 확인하기
				if(board[dr][dc]==color) {
					queue.offer(new int[] {dr, dc});	//큐에 넣기
//					System.out.println("dr : " +dr+ ", dc :" +dc);
					isvisited[dr][dc]=true;				//방문처리 하고
					count++;							//같은 색깔 개수 세기
				}
			}		
		}
		
		//큐가 빈 공백이 되면, count를 보고 연쇄 상황인지 판단하자!
		if(count>=4) {
			
			flag = true;
			
			//반복문을 돌면서 좌표가 방문처리 되었으면 .으로 바꿔주기
			for(int j=0; j<6; j++) {
				for(int i=0; i<12; i++) {
					if(isvisited[i][j]) board[i][j]='.';
				}
			}
		}
	}
	
    //아래로 떨어트리는 메서드
	public static void down() {
		Stack<Character> stack = new Stack();
		
		//.이 아니면 stack에 넣기
		for(int j=0; j<6; j++) {
			for(int i=0; i<12; i++) {
				if(board[i][j]!='.') stack.push(board[i][j]);
			}

			//stack에서 빼면서 아래서부터 채워주기
			int idx =11;
			while(!stack.isEmpty()) {
				char color = stack.pop();
				board[idx--][j]=color;
			}
			
			//다 채웠으면, 나머지는 .로 채워주기
			for(int i=idx; i>=0; i--) {
				board[i][j]='.';
			}
		}
	}	//down 끝 
}
