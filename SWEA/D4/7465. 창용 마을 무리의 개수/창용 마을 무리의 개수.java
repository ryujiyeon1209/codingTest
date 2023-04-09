
import java.util.Scanner;
import java.util.*;

public class Solution {
	
	static int[] parent;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=0; t<T; t++) {

			int n = sc.nextInt();	//사람 명수
			int m = sc.nextInt();	//관계 수
			
			
			//대표자를 나타날 배열 만들기
			parent=new int[n+1];
			for(int i=0; i<parent.length; i++) {
				parent[i]=i;
			}
			
			//관계 입력받기
			for(int i=0; i<m; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				
				//대표가 같다면 넘어가기 > 같지 않아면 한 그룹으로 묶어주기
				if(find(x)==find(y)) continue;
				union(x,y);	
			}
			
			//최종 대표자로 업데이트 하기
			for(int i=0; i<parent.length; i++) {
				parent[i]=find(parent[i]);
			}
			
			//그룹이 몇개 있나 확인하기
			Set<Integer> set = new HashSet();
			for(int i=1; i<parent.length; i++) {
				set.add(parent[i]);
			}
			
			//출력
			System.out.printf("#%d %d\n", (t+1), set.size());
		}
		
	}
	
	public static int find(int x) {
		if(parent[x]!=x) return parent[x]=find(parent[x]);
		else return x;
	}
	
	public static void union(int x, int y) {
		int dx = find(x);
		int dy = find(y);
	
		if(dx<dy) parent[dy]=dx;
		else parent[dx]=dy;
	}
}
