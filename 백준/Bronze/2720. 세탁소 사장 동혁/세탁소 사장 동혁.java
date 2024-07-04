import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        
        int test = sc.nextInt();
        
        StringBuilder sb = new StringBuilder();
        for(int t=0; t<test; t++){
            int c = sc.nextInt();
            
            int[] arr = new int[4];
            
            while(0<c) {            	
                if(25<=c) {
                	arr[0]+=(c/25);
                    c%=25;
                }
                
                else if(10<=c && c<25) {
                	arr[1]+=(c/10);
                    c%=10;
                }
                
                else if(5<=c && c<10) {
                	arr[2]+=(c/5);
                	c%=5;                   
                }
                
                else {
                	arr[3]+=(c/1);
                    c%=1;                  
                }  
            }
            
            for(int i=0; i<arr.length; i++){
                sb.append(arr[i] + " ");
            }
            
            sb.append("\n");
        }
        
        System.out.println(sb.toString());
    }
}