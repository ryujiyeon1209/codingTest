import java.util.*;

class Solution {
    
    static char[] choose;
    
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        
        //곡괭이 종류별 개수만큼 queue에 저장
        Queue<Integer> queue = new LinkedList();
        for(int i=0; i<picks.length; i++){
            for(int j=0; j<picks[i]; j++){
                queue.add(i);
            }
        }
        
        //곡괭이의 개수가 부족했을 때의 방지
        int cr = (int) Math.ceil(minerals.length/5.0);
        int r = Math.min(queue.size(), cr);
        
        //광물들의 종류 개수 세기
        int[][] count = new int[r][3];
        
        for(int i=0; i<count.length; i++){
            for(int j=i*5; j<(i*5)+5; j++){
                if(minerals.length<=j) break;
                
                if(minerals[j].equals("diamond")) count[i][0]++;
                else if(minerals[j].equals("iron")) count[i][1]++;
                else count[i][2]++;
            }
        }

        //다이아 > 철 > 돌 많은 순서대로 정렬
        Arrays.sort(count, new Comparator<int[]>(){
           public int compare(int[] o1, int[] o2){
               if(o1[0]==o2[0] && o1[1]==o2[1]) return o2[2]-o1[2];
               if(o1[0]==o2[0]) return o2[1]-o1[1];
               return o2[0]-o1[0];
           } 
        });
        
        //피로도 계산
        for(int i=0; i<count.length; i++){
            if(queue.isEmpty()) break;
            
            int diamond = count[i][0];
            int iron = count[i][1];
            int stone = count[i][2];
            
            int tool = queue.poll();    //곡괭이 종류
            
            if(tool==0) {   //다이아 곡괭이
                answer=answer+diamond+iron+stone;
            }
            else if(tool==1) {  //철 곡괭이
                answer=answer+(diamond*5)+iron+stone;
            }
            else if(tool==2) {  //돌 곡괭이
                answer=answer+(diamond*25)+(iron*5)+stone;
            }

        }
        
        return answer;
    }
}

        
// for(int i=0; i<count.length; i++){
//     System.out.println(Arrays.toString(count[i]));
// }
            
// System.out.println("tool : " +tool+ " > answer : " +answer);