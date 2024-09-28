import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        
        //폭격이 끝나는 오름차순으로 정렬
        Arrays.sort(targets, new Comparator<int[]>(){
           public int compare(int[] o1, int[] o2) {
               if(o1[1]==o2[1]) return Integer.compare(o1[0], o2[0]);
               return Integer.compare(o1[1], o2[1]);
           } 
        });
        
        int idx = 0;
        int count = 0;
        
        //그리디
        while(idx<targets.length) {
            
            //미사일 좌표
            int location = targets[idx][1];     
            count++;
            
            //요격하는 미사일 좌표보다 시작위치가 더 앞에 있다면, 
            while(idx<targets.length && targets[idx][0]<location) {
                idx++; 
            }
        }
        
        return count;
    }
}