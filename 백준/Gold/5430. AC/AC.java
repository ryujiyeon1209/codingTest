import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int test = Integer.parseInt(br.readLine());
		
		for(int t=0; t<test; t++) {
			
			//명령어 문자 배열로 변경하기
			char[] charArr = br.readLine().toCharArray();
			
			int n = Integer.parseInt(br.readLine());
			
			//정수 배열 입력받기
			String str = br.readLine();
			str = str.substring(1, str.length()-1);
			String[] numArr = str.split(",");
			
			
			//Dequeue사용
			Deque<String> deque = new ArrayDeque<>();
			for(int i=0; i<numArr.length; i++) {
				if(!numArr[i].equals("")) deque.add(numArr[i]);
			}
			
			boolean isfirst = true;
			boolean flag = true;
			
			for(int i=0; i<charArr.length; i++) {
				
				//R > 반전하기
				if(charArr[i]=='R') {
					isfirst = !isfirst;
				}
				
				//D > 삭제하기
				else if(charArr[i]=='D' && deque.size()!=0) {
					if(isfirst) deque.poll();
					else deque.pollLast();
				}
				
				//D > error
				else if(charArr[i]=='D' && deque.size()==0) {
					flag = false;
					break;
				}
			}
			
			
			//StringBuilder 사용
			StringBuilder sb = new StringBuilder();
			while(!deque.isEmpty()) {
				if(isfirst) sb.append(deque.poll());
				else sb.append(deque.pollLast());
				
				if(!deque.isEmpty()) sb.append(",");
			}
			
			//출력
			if(flag) bw.write("[" +sb.toString()+ "]" + "\n");		
			else bw.write("error" + "\n");
		}
		
		bw.flush();
		bw.close();
	}
}
