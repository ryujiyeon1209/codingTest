import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[8];
		
		for(int i=0; i<8; i++) {
			arr[i] = sc.nextInt();
		}
		
		boolean ascending  = true;
		boolean descending = true;
		for(int i=1; i<8; i++) {
			if(!(arr[0]==1 && arr[i-1]+1==arr[i])) ascending = false; 
			if(!(arr[0]==8 && arr[i-1]-1==arr[i])) descending = false;
		}
		
		if(ascending) System.out.println("ascending");
		else if(descending) System.out.println("descending");
		else System.out.println("mixed");
		
	}
}
