import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//정답 변수
		int answer = 0;
		
		//멜로디의 수
		int n = sc.nextInt();
		
		//프렛의 수
		int num = sc.nextInt();
		
		//줄과 프렛 정보를 담을 리스트 배열
		List<Integer>[] list = new ArrayList[7];
		for(int i=0; i<list.length; i++) {
			list[i] = new ArrayList<Integer>();
		}

		for(int i=0; i<n; i++) {
			int melody = sc.nextInt();
			int fret = sc.nextInt();
			
			//만약 플렛에 손이 없다면 추가
			if(!list[melody].contains(fret)) {
				list[melody].add(fret);
				answer++;
			}
			
			Collections.sort(list[melody], Collections.reverseOrder());

			while(true) {
					
				//최대 번호가 아니라면, 현재 플렛 보다 큰 플렛 삭제
				int maxFret = list[melody].get(0);
				
				if(fret<maxFret) {
					answer++;
					list[melody].remove(0);
				}
				
				//현재 플렛이 가장 큰 수라면 반복문 종료
				else break;
			}
		}
			
		//출력
		System.out.println(answer);
		
	}
}
