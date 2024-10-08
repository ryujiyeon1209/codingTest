import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        if(n==0) {
            System.out.println(0);
            return;
        }
        
        else if(n==1) {
            System.out.println(1);
            return;
        }
        
        long[] arr = new long[n+1];
        arr[0]=0;
        arr[1]=1;
        
        for(int i=2; i<arr.length; i++){
            arr[i]=arr[i-1]+arr[i-2];
        }
        
        System.out.println(arr[n]);
    }
}