
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
	
	static int v, e;
	static int[] p;
	static int[][] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();	//테스트케이스 개수
		
		for(int t=0; t<T; t++) {
			
			v = sc.nextInt();	//정점의 개수
			e = sc.nextInt();	//간선의 개수
			
			arr = new int[e][3];
			for(int i=0; i<e; i++) {
				
				int start = sc.nextInt();	//출발정점
				int end = sc.nextInt();		//도착정점
				int importance = sc.nextInt();	//가중치
				
				arr[i][0] = start;
				arr[i][1] = end;
				arr[i][2] = importance;
			}
			
			//간선 배열만들기(makeset) - 자기 자신을 대표로 한다
			p = new int[v+1];
			for(int i=0; i<p.length; i++){
				p[i] = i;
			}
			
			//1.정렬하기
			Arrays.sort(arr, new Comparator<int[]>(){
				public int compare(int[] o1, int[] o2) {
					return o1[2] - o2[2];
				}
			});
			
			int pick=0;	//선택한 간선의 개수
			long result=0;	//간선의 가중치의 누적합(항상 범위 확인하기)
			
			//2.짧은 간선 구하기
			for(int i=0; i<e; i++) {
				
				//조건 확인하기 - 사이클이 아닌 간선 선택하기 - 같은 집합아닌 간선 구하기
				int dx = findset(arr[i][0]);
				int dy = findset(arr[i][1]);
				if(dx!=dy) {
					
					//간선을 선택했다고 알려주기
					union(arr[i][0], arr[i][1]);
					pick++;
					result+=arr[i][2];
				}
				
				if(pick==v-1) break;
			}
			
			System.out.printf("#%d %d\n", (t+1), result);
		}
	}
	
	//대표값 찾기(findset) - 압축경로 활용하기
	public static int findset(int x) {
		if(x!=p[x]) p[x]=findset(p[x]);
		return p[x];
	}
	
	//합집합 만들기(union)
	public static void union(int x, int y) {
		
		int dx = findset(x);
		int dy = findset(y);
		
		if(dx<dy) p[dy] = dx;
		else p[dx] = dy;
	}
}
