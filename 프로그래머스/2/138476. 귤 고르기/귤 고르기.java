import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        //크기마다 개수 세기
        Map<Integer, Integer> map = new HashMap();
        for(int i=0; i<tangerine.length; i++){
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0)+1);
        }
        
        //2차원 배열에 저장 및 정렬
        int[][] arr = new int[map.size()][2];
        int idx = 0;
        for(int key : map.keySet()){
            arr[idx][0] = key;
            arr[idx][1] = map.get(key);
            
            idx++;
        }
        
        Arrays.sort(arr, new Comparator<int[]>(){
           public int compare(int[] o1, int[] o2) {
               return o2[1]-o1[1];
           } 
        });

        //최소 개수 세기
        int sum = 0;
        for(int i=0; i<arr.length; i++){
            sum+=arr[i][1];
            answer++;
            
            if(k<=sum) break;
        }
        
        return answer;
    }
}