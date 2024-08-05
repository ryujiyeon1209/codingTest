import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//키보드 좌표 만들기
		char[][] keyboard = new char[3][10];
		keyboard[0] = new char[] {'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'};
		keyboard[1] = new char[] {'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'};
		keyboard[2] = new char[] {'z', 'x', 'c', 'v', 'b', 'n', 'm'};

		//map에 좌표 저장
		Map<Character, int[]> map = new HashMap();
		for(int i=0; i<keyboard.length; i++) {
			for(int j=0; j<keyboard[i].length; j++) {
				map.put(keyboard[i][j], new int[] {i, j});
			}
		}
		
		int test = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<test; i++) {
			char[] charr = sc.next().toCharArray();		//기준 문자
			
			int count = sc.nextInt();					//비교 문자 개수
			String[][] sortstr = new String[count][2];	//비교 문자 배열

			for(int j=0; j<count; j++) {
				String strdif = sc.next();				//비교 문자
				char[] chdif = strdif.toCharArray();
				
				int sum = 0;
				for(int k=0; k<chdif.length; k++) {		//비교하기
					if(charr[k]==chdif[k]) continue;
					
					int cr = map.get(charr[k])[0];
					int cc = map.get(charr[k])[1];
					
					int dr = map.get(chdif[k])[0];
					int dc = map.get(chdif[k])[1];
					
					sum+=(Math.abs(cr-dr)+Math.abs(cc-dc));
				}
				
				sortstr[j][0] = strdif;
				sortstr[j][1] = String.valueOf(sum);
			}
			
			//차이가 덜 나는 순으로 정렬
			Arrays.sort(sortstr, new Comparator<String[]>() {
				public int compare(String[] o1, String[] o2) {
					if(Integer.parseInt(o2[1])==Integer.parseInt(o1[1]))
						return o1[0].compareTo(o2[0]);
					return Integer.parseInt(o1[1])-Integer.parseInt(o2[1]);
				}
			});
			
			//StringBuilder에 저장
			for(int j=0; j<sortstr.length; j++) {
				sb.append(sortstr[j][0]+" "+ sortstr[j][1]+ "\n");
			}
		}
		
		
		//출력
		System.out.println(sb.toString());
	}
}
