import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        
        //단계별 실패 유저 세기
        int count[] = new int[N+1];
        for(int i=0; i<stages.length; i++){
            if(stages[i]<=N) count[stages[i]]++;
        }
        
        //단계별 실패율 계산하기
        int total = stages.length;
        Map<Integer, Double> map = new HashMap();
        for(int i=1; i<count.length; i++){
            if(total<=0) map.put(i, 0.0);
            else map.put(i, count[i]/(total*1.0));
            
            total-=count[i];
        }
        
        //실패율 내림차순으로 정렬
        List<Integer> list = new ArrayList(map.keySet());
        Collections.sort(list, new Comparator<Integer>(){
           public int compare(Integer o1, Integer o2){
               return map.get(o2).compareTo(map.get(o1));
           } 
        });
        
        //배열에 저장
        int idx = 0;
        for(int key : list){
            answer[idx++] = key;
        }
        
        return answer;
    }
}