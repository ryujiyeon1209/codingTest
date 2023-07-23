import java.io.*;
import java.util.*;


public class Main {
	
	static int[] arr, result;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
				
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		arr = new int[n+1];
		for(int i=1; i<arr.length; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		//결과 배열 및 메서드 실행
		result = new int[n+1];
		for(int i=1; i<arr.length; i++) {
			if(i-1==0 || (arr[i-1]>arr[i])) result[i]=i-1;
			else DFS(i, i-1);
		}
		
		//출력
		for(int i=1; i<result.length; i++) {
			System.out.print(result[i] + " ");			
		}
	}
	
	
	//DFS
	public static void DFS(int idx, int comIdx) {
		
		//현재 탑보다 비교하는 탑의 길이가 더 클 경우, 결과 배열에 비교 탑 인덱스 저장
		if(comIdx==0 || (arr[comIdx]>arr[idx])) {
			result[idx]=comIdx;	
			return;
		}
		
		//현재 탑보다 비교하는 탑의 길이가 더 작을 경우, 비교하는 탑의 레이저가 도착하는 탑으로 이동
		else {
			DFS(idx, result[comIdx]);
		} 
	}
}
