import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//배열 생성
		boolean[] arr = new boolean[10001];
		
		//수열 만들기
		for(int i=1; i<=10000; i++) {
			
			//인덱스를 문자 배열로 바꾸기 예) 인덱스 33 > 3,3
			char[] charNum = String.valueOf(i).toCharArray();
			
			//문자를 숫자로 바꾼 후 num에 더하기
			int num=i;
			for(int j=0; j<charNum.length; j++) {
				num+=(charNum[j]-'0');
			}
			
			if(num>10000) continue;
			
			//true면 생성자 있는 숫자, false면 셀프 넘버
			arr[num]=true;
		}
		
		//셀프넘버 찾기
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<arr.length; i++) {
			if(!arr[i]) sb.append(i +"\n");
		}
		
		//출력
		System.out.println(sb.toString());
		
	}
}
