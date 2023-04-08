import java.util.*;

public class Main {
	
	static int n, m, tmpm, housenum, num, result, min, sum, finalresult;
	static int[] r, c, choose;
	static int[][] city, store, house;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//도시 배열 크기 입력받기
		n = sc.nextInt();
		
		//최대 치킨 집 개수 입력받기
		m = sc.nextInt();

		//치킨집 개수
		num=0;
		
		//도시 배열 생성 및 값 입력받기
		city = new int[n][n];
		for(int i=0; i<city.length; i++) {
			for(int j=0; j<city.length; j++) {
				city[i][j]=sc.nextInt();
				
				if(city[i][j]==2) num++;
				else if(city[i][j]==1) housenum++;
			}
		}
		
		//치킨집 좌표 찾기
		store = new int[num][2];
		num=0;
		for(int i=0; i<city.length; i++) {
			for(int j=0; j<city.length; j++) {
				if(city[i][j]==2) { store[num][0]=i; store[num++][1]=j; }
			}
		}
		
		//집의 좌표 찾기
		house = new int[housenum][2];
		housenum=0;
		for(int i=0; i<city.length; i++) {
			for(int j=0; j<city.length; j++) {
				if(city[i][j]==1) { house[housenum][0]=i; house[housenum++][1]=j; }
			}
		}
		
		
		//마지막으로 어떤 치킨집의 조합이 가장 최소의 거리가 될까 측정하는 변수
		finalresult = Integer.MAX_VALUE;
		
		for(int i=m; i>=1; i--) {
			tmpm=i;
			choose = new int[tmpm];
			combination(0, 0);			
		}
		
		
		//진짜 최종 정답 출력
		System.out.println(finalresult);
		
	}

	
	//폐업시키지 않을 치킨집 구하기
	//n개 중에 m 고르기 > 중복X > 순서 영향X > 조합
	public static void  combination(int select, int current) {
		
		if(select==tmpm) {
					
			//선택한 치킨집 좌표를 담을 리스트 생성
			sum=0;

			for(int i=0; i<house.length; i++) {
				min = Integer.MAX_VALUE;
				for(int j=0; j<choose.length; j++) {
					result=(Math.abs(house[i][0]-store[choose[j]][0])+Math.abs(house[i][1]-store[choose[j]][1]));
					min = Math.min(min, result);
				}				
				
				//집에서 가까운 치킨집과의 거리를 찾았다면,
				sum+=min;
			}

			finalresult = Math.min(sum, finalresult);
			return;
		}
		
		if(current==num) return;
		
		choose[select] = current;
		combination(select+1, current+1);
		
		combination(select, current+1);
	}
}





