import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	
	static String ciba;
	static int d, w, k, min;
	static int[] arr, choose;
	static int[][] flim;
	static boolean[] isvisited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=0; t<T; t++) {
			
			d = sc.nextInt();	//보호필름 두께
			w = sc.nextInt();	//보호필름 너비
			k = sc.nextInt();	//합격 기준
			
			//보호필름 배열 생성 및 값 입력받기 > A는 0, B는 1
			flim = new int[d][w];	
			for(int i=0; i<d; i++) {
				for(int j=0; j<w; j++) {
					flim[i][j]=sc.nextInt();	
				}
			}
			
			//약품 처리 종류 배열 > 0: 약품처리X , 1: A약품, 2: B약품 
			arr = new int[] {0, 1, 2};
			choose = new int[d];
			
			//정답변수
			min = Integer.MAX_VALUE;
			
			permutation(0);
			
			
			//출력
			System.out.printf("#%d %d\n", (t+1), min);
			
			
		}
	
	}
	
	//약품 A를 넣을 건지, B를 넣을 건지, 넣지 않을 건지 구하는 메서드 > 중복순열
	public static void permutation(int idx) {
		
		if(idx==d) {
			
			//약품 넣는 횟수가 여태까지 구한 최소값보다 많다면, 굳이 할 필요 없다.
			int count=0;
			for(int i=0; i<choose.length; i++) {
				if(choose[i]!=0) count++;
			}
			
			if(count>=min) return;
			
			//필름배열 복사본 만들기
			int[][] tmpFlim = new int[d][w]; 
			for(int i=0; i<flim.length; i++) {
				tmpFlim[i] = flim[i].clone();
			}
			
			//반복문을 돌면서 약품을 넣어주기
			for(int i=0; i<choose.length; i++) {
				
				//약품 처리를 하지 않을 때,
				if(choose[i]==0) continue; 
				
				//A약품 처리 할 때, 모든 열을 A(0)로 바꾸기
				else if(choose[i]==1) {
					Arrays.fill(tmpFlim[i], 0);
				}
				
				//B약품 처리 할 때, 모든 열을 B(1)로 바꾸기
				else if(choose[i]==2) {
					Arrays.fill(tmpFlim[i], 1);
				}
			}
			
			//제한 시간 초과를 막기위해 count가 min보다 크다면, 어짜피 성능을 통과해도 정답이 되지 못하니까 그냥 재귀 멈추기
//			System.out.println("count : "  +count);
			if(count>=min) return; 
			
			
			String ciba = qualityTest(tmpFlim);
			
			//성능에 통과하면, 몇 번 교체했는지 횟수 세기
			if(ciba.equals("YES")) {
				min = Math.min(count, min);
			}
			
			return;
		}
		
		//중복순열 배열 만들기 > 반복문 종료조건 : 내가 고를 자료의 개수만큼 반복문 돌기!
		//중복순열은 값을 중복으로 골라야 하기 때문에 isvisited가 필요X
		for(int i=0; i<arr.length; i++) {
			choose[idx]=arr[i];
			permutation(idx+1);
		}
	}
	
	
	//약품처리 후, 성능 검사를 통과하는지 확인하는 메서드
	public static String qualityTest(int[][] copyFlim) {
		
		int countPass=0;
		for(int j=0; j<w; j++) {		//열
			
			int countA=0; int countB=0;
			for(int i=0; i<d; i++) {	//행
				
				if(copyFlim[i][j]==0) {	//0이 k가 되는지 확인
					countA++;
					countB=0;
					
					if(countA==k) {
						countPass++;
						break;
					}
				} else if(copyFlim[i][j]==1) {	//1이 k가 되는지 확인
					countB++;
					countA=0;
					
					if(countB==k) {
						countPass++;
						break;
					}
				}
			}
			
			if(countPass!=j+1) return"NO";
		}
		return "YES";
	}
}
