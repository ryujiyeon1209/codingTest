import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static char[] ch;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//문자열 입력받고 배열로 바꾸기
		ch = sc.next().toCharArray();
		
		int count=0;
		for(int i=0; i<ch.length; i++) {
			if(ch[i]=='X') count++;
			else { 
				if(0<count && !Solution(i)) { System.out.println(-1);  return; }
				else count=0;
			}
		}
		
        //마지막이 X로 끝날 때
		if(ch[ch.length-1]=='X' && !Solution(ch.length)) { System.out.println(-1); return;}
		
		//출력
		for(int i=0; i<ch.length; i++) {
			System.out.print(ch[i]);
		}
	}
	
	
	public static boolean Solution(int end) {
		
		int start=-1;
		for(int i=0; i<end; i++) {
			if(ch[i]=='X') { start = i; break; }
		}

		int count=end-start;
		if(0<count && count%2!=0) return false;
		
		while(0<count) {
			
            //x의 개수가 4의 배수일 때
			if(4<=count && count/4==0) {
				for(int i=start; i<end; i++) {
					ch[i]='A';
				}
			} 
			
            //x의 개수가 4개 이상일 때
			else if(4<=count) {
				for(int i=start; i<start+4; i++) {
					ch[i]='A';
				}
				count-=4; start+=4;
			}
			
            //x의 개수가 2개 이상일 때
			else if(2<=count) {
				for(int i=start; i<start+2; i++) {
					ch[i]='B';
				}
				count-=2; start+=2;
			}		
		}
		
		return true;
		
	}
	
}
