import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        
//         //사과의 점수마다 개수 세기
//         Map<Integer, Integer> map = new HashMap();
//         for(int i=0; i<score.length; i++){
//             map.put(score[i], map.getOrDefault(score[i], 0)+1);
//         }
        
//         //2차원 배열에 사과 개수 저장 및 정렬
//         int[][] arr = new int[map.size()][2];
//         int idx = 0;
//         for(int key : map.keySet()){
//             arr[idx][0] = key;
//             arr[idx][1] = map.get(key);
            
//             idx++;
//         }
        
//         Arrays.sort(arr, new Comparator<int[]>(){
//            public int compare(int[] o1, int[] o2) {
//                return o2[0]-o1[0];
//            } 
//         });
        
//         for(int i=0; i<arr.length; i++){
//             System.out.println(Arrays.toString(arr[i]));
//         }
        
        
//         //1상자에 들어가는 사과의 개수에 맞춰서 큰 사과부터 담기
//         int sum = 0;
//         int size = 0;
//         for(int i=0; i<arr.length; i++){
//             sum+=arr[i][1];
            
//             if(m<=sum) {
//                 size = arr[i][0];
//                 break;
//             }
//         }
        
        Arrays.sort(score);
        
        int size = 0;
        int count = 0;
        for(int i=score.length-1; i>=0; i--){
            count++;
            size = score[i];
            
            if(m<=count) {
                answer+=(count*size);
                count = 0;
            }
        }
        
        return answer;
    }
}