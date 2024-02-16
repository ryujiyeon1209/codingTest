import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[][] map = new int[n+1][n+1];
		
		int f1 = sc.nextInt();
		int f2 = sc.nextInt(); 
		
		while(f1!=-1 && f2!=-1){
			map[f1][f2]=1;
			map[f2][f1]=1;
			
			f1 = sc.nextInt();
			f2 = sc.nextInt(); 
		};

		
        //인접행렬 탐색
		for(int i=1; i<map.length; i++) {
			for(int j=1; j<map.length; j++) {
				if(i==j) continue;
				if(map[i][j]==0) continue;
				
				for(int k=1; k<map.length; k++) {
					if(i==k) continue;
					if(map[j][k]==0) continue;
					
					if(map[i][k]==0) {
						map[i][k] = map[i][j]+map[j][k];
						map[k][i] = map[i][j]+map[j][k];
					} else if(map[i][k]!=0) {
						map[i][k] = Math.min(map[i][k], map[i][j]+map[j][k]);
						map[k][i] = Math.min(map[i][k], map[i][j]+map[j][k]);
					}
				}
			}
		}

		
        //회장 후보 찾기
		int[] result = new int[n+1];
		for(int i=1; i<map.length; i++) {

			int max = 0;
			for(int j=1; j<map.length; j++) {
				if(i!=j && max<map[i][j]) max = map[i][j];
			}
			
			result[i] = max;
		}
		
		int min = Integer.MAX_VALUE;
		for(int i=1; i<result.length; i++) {
			if(result[i]<min) min = result[i];
		}
		
        //회장 후보 list에 넣기
		List<Integer> list = new ArrayList();
		for(int i=1; i<result.length; i++) {
			if(result[i]==min) list.add(i);
		}
		
		//출력
		System.out.println(min +" "+ list.size());
		for(int i=0; i<list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
	}
}
