import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//국가의 수
		int n = sc.nextInt();	
		
		//알고 싶은 국가 번호와 점수
		int k = sc.nextInt();	
		int score = 0;
		
		//2차원 배열 생성
		int[][] arr = new int[n][5];
		for(int i=0; i<n; i++) {
			arr[i][0] = sc.nextInt();	//국가 번호
			arr[i][1] = sc.nextInt();	//금메달 개수
			arr[i][2] = sc.nextInt();	//은메달 개수
			arr[i][3] = sc.nextInt();	//동메달 개수
			arr[i][4]=((arr[i][1]*3) + (arr[i][2]*2) + (arr[i][3]*1));	//점수
			
			if(arr[i][0]==k) score=arr[i][4];	//알고싶은 나라의 점수
		}
		
		//정렬
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o2[4]-o1[4];
			}
		});
		
		//순위 찾기
		int result=0;
		for(int i=0; i<n; i++) {
			if(arr[i][0]!=k && arr[i][4]>score) result++;
		}
		
		
		//출력
		System.out.println(result+1);
	}
}
