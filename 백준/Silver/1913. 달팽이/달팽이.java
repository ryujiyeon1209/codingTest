import java.io.*;

public class Main  {	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//크기
		int n = Integer.parseInt(br.readLine());
		int[][]  map = new int[n][n];
		
		//찾고자 하는 수
		int num = Integer.parseInt(br.readLine());


		int r = n/2;
		int c = n/2;
		
		int limit=1;
		int idx = 1;
		
		String answer = "";
		
		
		while(true) {
			
			//위쪽
			for(int i=0; i<limit; i++) {
				map[r--][c] = idx++;
			}
			
			if(n*n<idx) break; //반복문 종료
			
			//오른쪽
			for(int i=0; i<limit; i++) {
				map[r][c++] = idx++;
			}
			
			limit++;
			
			//아래쪽
			for(int i=0; i<limit; i++) {
				map[r++][c] = idx++;
			}
			
			
			//왼쪽
			for(int i=0; i<limit; i++) {
				map[r][c--] = idx++;
			}
			
			limit++;			
		}
		
		//출력
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map.length; j++) {
				if(map[i][j]==num) answer+= (i+1) +" "+ (j+1); 
				sb.append(map[i][j]+" ");
			}
			if(i!=map.length-1)sb.append("\n");
		}
		
		System.out.println(sb.toString());
		System.out.println(answer);
		
	}
}
