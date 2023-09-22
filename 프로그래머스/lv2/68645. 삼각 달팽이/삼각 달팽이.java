import java.util.*;

class Solution {
    public int[] solution(int n) {
        int[][] arr = new int[n][n];
        
        int count=1;
        
        int downIdx=0;  
        int rightIdx=n-1;  
        int upIdx=0;
        
        while(downIdx<n){
            
            //아래로 이동
            for(int i=downIdx; i<n; i++){
                if(arr[i][downIdx]==0) arr[i][downIdx]=count++;
                else continue;
            }
            downIdx++;

            //오른쪽으로 이동
            for(int i=0; i<=rightIdx; i++){
                if(arr[rightIdx][i]==0) arr[rightIdx][i]=count++;
                else continue;
            }
            rightIdx--;

            //대각선 위로 이동
             for(int i=n-1; i>=upIdx; i--){
                if(arr[i][i-upIdx]==0) arr[i][i-upIdx]=count++;
                else continue;
            }
            upIdx++;

        }
        
        //정답 배열
        int[] answer = new int[count-1];
        
        int idx=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(arr[i][j]!=0) answer[idx++]=arr[i][j];
            }
        }
        

        
        return answer;
    }
}