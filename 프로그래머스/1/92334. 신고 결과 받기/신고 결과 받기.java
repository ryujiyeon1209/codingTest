import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        
        //인덱스 찾기
        Map<String,Integer> find = new HashMap();
        for(int i=0; i<id_list.length; i++){
            find.put(id_list[i], i);
        }
        
        //신고 현황 중복 제거
        Set<String> set = new HashSet();
        for(int i=0; i<report.length; i++){
            set.add(report[i]);
        }
        
        //신고 당한 사람, 신고한 사람 인접리스트
        List<Integer>[] list = new List[id_list.length];
        for(int i=0; i<list.length; i++){
            list[i] = new ArrayList();
        }
        
        //신고 당한 횟수 저장
        Map<String,Integer> map = new HashMap();
        for(String info : set) {
            String[] strarr = info.split(" ");
            map.put(strarr[1], map.getOrDefault(strarr[1], 0)+1);
            
            int idx = find.get(strarr[1]);
            list[idx].add(find.get(strarr[0]));
        }
        
        
        int[] answer = new int[id_list.length];
        
        //k번 이상 신고 당한 사람 찾기
        for(String name : map.keySet()){
            if(k<=map.get(name)) {
                
                int idx = find.get(name);
                for(int i=0; i<list[idx].size(); i++){
                    answer[list[idx].get(i)]++;
                }
                
            }
        }
        
        return answer;
    }
}