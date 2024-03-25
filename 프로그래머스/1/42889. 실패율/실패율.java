import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        
        Map<Integer, Integer> map = new HashMap();
        for(int i=0; i<stages.length; i++){
            map.put(stages[i], map.getOrDefault(stages[i], 0)+1);
        }
        
        //실패율 계산
        List<Double> list = new ArrayList();       
        double[] result = new double[N+1];
        
        double num = stages.length*1.0;
        for(int i=1; i<=N; i++){
            int fail = map.getOrDefault(i, 0);
            
            if(fail!=0) {   //클리어를 하지 못한 사람이 있을 때,
                result[i] = fail/num;
                list.add(fail/num);
            } else {        //스테이지에 도달한 사람이 모두 클리어했을 때,
                result[i] = 0.0;
                list.add(0.0);
            }
            
            num-=fail;
        }
        
        //내림차순 정렬
        Collections.sort(list, Collections.reverseOrder());
        
        //스테이지 찾기
        for(int i=0; i<list.size(); i++){
            for(int j=1; j<result.length; j++){
                 if(result[j]==list.get(i)) {
                     answer[i] = j;
                     result[j] = -1;
                     break;
                 }
            }
        }
        
        return answer;
    }
}