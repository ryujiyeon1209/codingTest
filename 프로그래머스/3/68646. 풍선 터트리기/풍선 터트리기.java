import java.util.*;

class Solution {
    public int solution(int[] a) {
        int answer = 0;

        int left = a[0];            //왼쪽에서 제일 작은 수
        int right = min(a, 0);      //오른쪽에서 제일 작은 수

        int count = 0;

        //왼쪽에서 오른쪽으로 이동
        int idx = -1;
        for(int i=1; i<a.length-1; i++){
            
            if(left<a[i] && right<a[i]) count++;
            
            if(a[i]<=left) left=a[i];
            if(a[i]==right) {
                idx = i;
                break;
            }
        }
        
        if(idx==-1) return a.length-count;
        
        //오른쪽에서 왼쪽으로 이동
        left = min(a, idx);
        right = a[a.length-1];
        for(int i=a.length-1; idx<i; i--){
            if(a[i]<=right) right=a[i];
            if(left<a[i] && right<a[i]) count++;
        }

        answer = a.length-count;
        return answer;
    }
    
    //현재 기준 오른쪽에서 제일 작은 수 찾기
    public static int min(int[]a, int idx){
        
        int right = Integer.MAX_VALUE;
        for(int i=idx+1; i<a.length; i++){
            if(a[i]<right) right = a[i];
        }
        
        return right;
    }
}


// System.out.println("i : " +i+ ", pre : " +a[list.get(i-1)]+ 
//                    ", idx : " +a[list.get(i)]+ ", next : " +a[list.get(i+1)]);
//             
// System.out.println("left : " +left+ ", idx : " +a[i]+ ", next : " +right + " > count : " +count);