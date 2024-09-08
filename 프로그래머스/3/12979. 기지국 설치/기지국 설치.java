import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;

        //지기국 전파 범위 배열
        int[][] arr = new int[stations.length+2][2];
        for(int i=1; i<arr.length-1; i++){
            int num = stations[i-1];
            
            arr[i][0]=num-w;
            arr[i][1]=num+w;
        }
        
        //시작점
        arr[0][0] = 0-w;
        arr[0][1] = 0;
        
        //끝점
        arr[arr.length-1][0] = n+1;
        arr[arr.length-1][1] = n+1+w;

        //개수 확인하기
        int spread = (w*2)+1;
        for(int i=arr.length-1; 0<i; i--){
            int start1 = arr[i][0];
            int end1 = arr[i][1];
            
            int start2 = arr[i-1][0];
            int end2 = arr[i-1][1];
            
            if(start1-end2-1<=0) continue;              //지기국 전파 범위가 곂치면
            answer+=Math.ceil((start1-end2-1)/(spread*1.0));  //지기국 전파가 없으면
        }
        
        return answer;
    }
}