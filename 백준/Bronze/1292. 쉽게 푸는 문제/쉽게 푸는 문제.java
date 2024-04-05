import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int answer = 0;
		
		int start = sc.nextInt();
		int end = sc.nextInt();
		
		int count = 0;		//문제 난이도
		int idx = 0;		//현재 난이도의 끝지점
		
		//시작 시점의 난이도 구하기
		while(idx<start) {	
			count++;
			idx+=(count);
		}
		
		//처음 난이도의 끝 인데스보다 종료 인덱스가 더 앞에 있을 때
		if(end<idx) {
			for(int i=start; i<=end; i++) {
				answer+=count;
			}
		}
		
		//난이도를 계속 올리며, 수열을 더해야할 때
		else {
			while(idx<=end) {
				int tmp = answer;
				for(int i=start; i<=idx; i++) {
					answer+=count;
				}

				if(idx==end) break;
				
				count++;			//난이도 올리고
				start=idx+1;		//시작점 바꾸고
				if(idx+count<end) idx+=(count);	//끝지점 바꾸기
				else idx=end;
				
			}
		}


		//출력
		System.out.println(answer);
		
	}
}
