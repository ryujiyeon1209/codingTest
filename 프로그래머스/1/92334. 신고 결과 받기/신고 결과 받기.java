import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        //이용자 정리
        Map<String, Integer> map = new HashMap();
        for(int i=0; i<id_list.length; i++){
            map.put(id_list[i], i);
        }
        
        //신고한 사람과 신고당한 사람을 담을 list
        List<String>[] list = new ArrayList[id_list.length];
        for(int i=0; i<list.length; i++){
            list[i] = new ArrayList();
        }
        
        //신고 정리하기 : 누구한테 신고당했는지 list에 담기
        for(int i=0; i<report.length; i++){
            String[] cur = report[i].split(" ");

            if(!list[map.get(cur[1])].contains(cur[0]))
                list[map.get(cur[1])].add(cur[0]);
        }
        
        //신고한 사람의 answer +1하기
        for(int i=0; i<list.length; i++){
            if(list[i].size()<k) continue;
            
            for(int j=0; j<list[i].size(); j++){
                String name = list[i].get(j);
                answer[map.get(name)]++;
            }
        }
        
        
        return answer;
    }
}