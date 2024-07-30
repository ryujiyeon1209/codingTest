import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = Integer.MAX_VALUE;
        
        //중복제거
        Set<Integer> setr = new HashSet();
        Set<Integer> setc = new HashSet();
        
        for(int i=0; i<sizes.length; i++){
            setr.add(sizes[i][0]);
            setc.add(sizes[i][1]); 
        }
        
        int[] r = new int[setr.size()+setc.size()];
        int[] c = new int[setc.size()+setr.size()];
        
        int idx = 0 ;
        for(int n : setr){
            r[idx] = n;
            c[idx] = n;
            idx++;
        }
        
        for(int n : setc){
            r[idx] = n;
            c[idx] = n;
            idx++;
        }

        //명함 만들기
        for(int i=0; i<r.length; i++){
            for(int j=0; j<c.length; j++){
                int ci = r[i];
                int cj = c[j];
                
                if(answer<(ci*cj)) continue;
                
                boolean flag = true;
                for(int t=0; t<sizes.length; t++){
                    int cr = sizes[t][0];
                    int cc = sizes[t][1];

                    if(!((cr<=ci && cc<=cj) || (cc<=ci && cr<=cj))) {
                        flag = false;
                        break;
                    }        
                }
                
                if(flag)  answer = Math.min(answer, ci*cj);   
            }
        }
        
        return answer;
    }
}