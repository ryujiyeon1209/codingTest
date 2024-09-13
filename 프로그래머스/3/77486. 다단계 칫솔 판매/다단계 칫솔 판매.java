import java.util.*;

class Solution {
    
    static int[] sum;
    static List<Integer>[] list;
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        
        //idx저장
        Map<String, Integer> map = new HashMap();
        map.put("-", 0);
        for(int i=0; i<enroll.length; i++){
            map.put(enroll[i], i+1);
        }
        
        //인접리스트 생성
        list = new List[enroll.length+1];
        for(int i=0; i<list.length; i++){
            list[i] = new ArrayList();
        }
        
        for(int i=0; i<enroll.length; i++){
            int idx = map.get(enroll[i]);
            int parent = map.get(referral[i]);
            
            list[idx].add(parent);
        }
        
        //판매 금액 저장 배열
        sum = new int[enroll.length+1];
        for(int i=0; i<seller.length; i++){
            int idx = map.get(seller[i]);   //판매원
            int money = amount[i]*100;      //판매 금액
            
            DFS(idx, money);
        }
        
        //출력
        int[] answer = new int[enroll.length];
        for(int i=0; i<answer.length; i++){
            answer[i] = sum[i+1];
        }
        
        return answer;
    }
    
    //DFS
    public static void DFS(int idx, int money) {
        
        if(idx==0) return;
        
        //현재 내가 챙기는 금액
        int save = (int) Math.ceil(money*0.9);
        
        //부모한테 주는 금액
        int parent = money-save;
        
        if(parent<1) {
            sum[idx] += money;
            return;
        }
        
        else {
            sum[idx] += save;
            
            int pidx = list[idx].get(0);
            DFS(pidx, parent);
        }

    }  
}