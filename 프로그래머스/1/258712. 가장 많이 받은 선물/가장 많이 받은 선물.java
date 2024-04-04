import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int[] answer = new int[friends.length];
        
        //인덱스 저장
        Map<String, Integer> map = new HashMap();
        for(int i=0; i<friends.length; i++){
            map.put(friends[i], i);
        }
        
        int[][] giftCount = new int[friends.length][friends.length];
        for(int i=0; i<gifts.length; i++){
            String[] gift = gifts[i].split(" ");
            
            int give = map.get(gift[0]);        //선물을 준 사람
            int take = map.get(gift[1]);        //선물을 받은 사람
            
            giftCount[give][take]++;
        }
        
        //선물 지수 계산하기
        int[] count = new int[friends.length];
        for(int i=0; i<giftCount.length; i++){
            
            int gift = 0;
            for(int j=0; j<giftCount.length; j++){
                gift+=giftCount[i][j];
                gift-=giftCount[j][i];
            }
            
            count[i] = gift;
        }
        
        //주고 받을 선물 구하기
        for(int i=0; i<giftCount.length; i++){
            for(int j=i+1; j<giftCount.length; j++){
                //만약 j가 i한테 선물을 준 개수보다 i가 더 많이 주었다면,
                if(giftCount[i][j]>giftCount[j][i]){
                    answer[i]++;
                }
                
                //만약 i가 j한테 선물을 준 개수보다 j가 더 많이 주었다면,
                else if(giftCount[i][j]<giftCount[j][i]){
                    answer[j]++;
                }
                
                //둘이 준 선물의 개수가 같다면,
                else if(giftCount[i][j]==giftCount[j][i]){
                    if(count[i]>count[j]) answer[i]++;
                    else if(count[i]<count[j]) answer[j]++;
                }
                
            }
        }
        
        //가장 큰 값 찾기
        int max = 0;
        for(int i=0; i<answer.length; i++){
            if(max<answer[i]) max = answer[i];
        }
        
        return max;
    }
}