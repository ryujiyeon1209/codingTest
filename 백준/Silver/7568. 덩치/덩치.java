import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[][] physical = new int[n][2];
		for(int i=0; i<n; i++) {
			physical[i][0]=sc.nextInt();	//몸무게 입력받기
			physical[i][1]=sc.nextInt();	//키 입력받기
		}
		
		//등수 배열
		int[] rank = new int[n];
		
		//그냥 하나 하나 비교하기
		for(int i=0; i<n; i++) {
			
			int count=0;
			for(int j=0; j<n; j++) {
				if(physical[i][0]<physical[j][0] && physical[i][1]<physical[j][1]) {
					count++;
				}
			}
			
			//count+1한 값을 rank 배열에 넣기
			rank[i]=count+1;
		}
		
		//출력
		for(int i=0; i<rank.length; i++) {
			System.out.print(rank[i] + " ");
		}
		
	}
}
