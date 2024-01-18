import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		char[] charr = str.toCharArray();
		
		List<String> list = new ArrayList();
		
		String num = "";
		for(int i=0; i<charr.length; i++) {
			if('0'<=charr[i] && charr[i]<='9') num+=charr[i];
			else {
				if(!num.equals("")) list.add(num);
				num = "";
				
				list.add(String.valueOf(charr[i]));
			}
		}
		
		list.add(num);
		
		int total = 0;
		for(int i=0; i<list.size(); i++) {
			//+를 만난 경우
			if(list.get(i).equals("+")) continue;
			
			//-를 만난 경우
			else if(list.get(i).equals("-")) {
				int sum = 0;
				int idx = i+1;
				
				while(idx<list.size() && !list.get(idx).equals("-")) {
					if(!list.get(idx).equals("+")) sum+=Integer.parseInt(list.get(idx));
					idx++;
				}
				
				total+=(sum*-1);
				i=idx-1;
			}
			
			//숫자인 경우
			else {
				total+=Integer.parseInt(list.get(i));
            }
		}
		
		//출력
		System.out.println(total);
	}
}
