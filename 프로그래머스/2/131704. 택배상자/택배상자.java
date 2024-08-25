import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        
        int n = order.length;
        int seq = 1;
        int idx = 0;
        
        Stack<Integer> stack = new Stack();
        
        while(idx<n){
            
            //기사님이 원하는 택배와 컨테이너 택배가 일치할 때
            if(order[idx]==seq) {
                answer++;
                idx++;
                seq++;
            }
            
            //기사님이 원하는 택배와 보조 컨테이너와 일치할때
            else if(!stack.isEmpty() && order[idx]==stack.peek()) {
                answer++;
                idx++;
                stack.pop();
            }
            //기사님이 원하는 택배가 아닐 때 > 보조 컨테이너에 넣기
            else if(seq<order[idx]) {
                stack.push(seq);
                seq++;
            }
            
            //기사님이 원하는 택배가 아닐 때 > 보조 컨테이너에 이미 있을 때
            else if(order[idx]<seq) {
                break;
            }
        }
        
        return answer;
    }
}