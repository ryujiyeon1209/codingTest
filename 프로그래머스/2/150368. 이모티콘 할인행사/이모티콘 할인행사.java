import java.util.*;

class Solution {
    
    static int count, total;
    static int[] arr;
    
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = {};
        
        //이모티콘 할인율 플러스, 총 매출액
        count = 0;
        total = 0;
        
        arr = new int[emoticons.length];

        permutation(0, users, emoticons);
        
        answer = new int[] {count, total};
        return answer;
    }
    
    //중복 순열
    public static void permutation(int idx, int[][] users, int[] emoticons) {
        
        if(arr.length<=idx) {

            //이모티콘 할인된 값
            int[] sale = new int[emoticons.length];
            for(int i=0; i<sale.length; i++){
                sale[i] += (emoticons[i]*(100.0-arr[i]))/100;
            }
            
            //사용자마다 매출액 구하기
            int cur = 0;
            int[] sum = new int[users.length];
            
            
            for(int i=0; i<users.length; i++){
                int want = users[i][0];
                int price = users[i][1];
                
                
                for(int j=0; j<emoticons.length; j++){
                    if(want<=arr[j]) sum[i]+=sale[j];
                }

                if(price<=sum[i]) {
                    cur++;
                    sum[i]=0;
                }
            }
            
            //총 매출액 계산
            int tsum = 0;
            for(int i=0; i<sum.length; i++){
                tsum+=sum[i];
            }
            
            //이모티콘 플러스 갱신 확인
            if(count<cur) {
                count=cur;
                total = tsum;
            }
            else if(count==cur && total<tsum) {
                total = tsum;
            }
            
            return;
        }
        
        for(int i=10; i<=40; i+=10){
            arr[idx]=i;
            permutation(idx+1, users, emoticons);
        }
    }
}