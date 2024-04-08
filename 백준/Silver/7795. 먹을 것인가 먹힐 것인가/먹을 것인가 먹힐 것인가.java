import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
        //testcase 입력받기
		int test = sc.nextInt();
		
		for(int t=0; t<test; t++) {
			int n = sc.nextInt();    //a그룹 물고기 개수
			int m = sc.nextInt();    //b그룹 물고기 개수
			
			int[] arr = new int[n];
			for(int i=0; i<arr.length; i++) {
				arr[i] = sc.nextInt();
			}
			
			int[] check = new int[m];
			for(int i=0; i<check.length; i++) {
				check[i] = sc.nextInt();
			}
			
            //이분탐색을 위한 정렬
			Arrays.sort(arr);
			
            //잡아먹을 수 있는 물고기 합
			int answer = 0;
            
            //이분탐색
			for(int i=0; i<check.length; i++) {
				int size = check[i];
				
				int min = 0;
				int max = arr.length-1;
				int mid = arr.length/2;
				
				int result = Integer.MAX_VALUE;
				
                while(min<=max) {
					mid = (min+max)/2;
					
                    //mid의 물고기 크기로는 size의 물고기를 먹을 수 없을 때
					if(arr[mid]<=size) min = mid+1;    
                    
                    //mid의 물고기 크기로 size의 물고기를 먹을 수 있을 때
					else if(size<arr[mid]) {
						max = mid-1;
						result = Math.min(mid, result);
					}
				}

                //먹은 물고기의 합 더하기
				if(result!=Integer.MAX_VALUE) answer+=(arr.length-result);
			}
		
            //출력
			System.out.println(answer);
		}
	}
}
