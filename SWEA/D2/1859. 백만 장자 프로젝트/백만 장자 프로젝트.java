import java.util.Scanner;
 
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         
        int T = sc.nextInt();
         
        for(int t=0; t<T; t++) {
             
            //상품 개수
            int n= sc.nextInt();
             
            //배열 생성 및 입력
            int[] arr=new int[n];
            for(int i=0; i<n; i++) {
                arr[i]=sc.nextInt();
            }
             
            //최대값, 시작점, 이익 변수
            int start =0;
            int max=0;
            long sum=0;
             
            //끝의 자리값이 max가 아니더라도 max를 탐색하면서, 
            //결국에는 arr.length에 도달한다
            while(max<arr.length) {
                 
                //최대값 찾기
                for(int i=start; i<arr.length; i++) {
                    if(arr[max]<arr[i]) max=i;
                }
                 
                //이익 구하기
                for(int i=start; i<max; i++) {
                    sum+=(arr[max]-arr[i]); 
                }
                 
                //뒤에 있는 또 다른 max값 탐색을 위해 start값과 max값 바꾸기
                start=max+1;
                max=max+1;
                 
            }
            //출력
            System.out.println("#" + (t+1)+ " " + sum);
        }
    }
}