class Solution {
    
    static boolean check;
    static int min, answer;
    static boolean[] isvisited;
    
    public int solution(String begin, String target, String[] words) {
        
        isvisited = new boolean[words.length];
        
        check = false;
        answer = Integer.MAX_VALUE;
        DFS(words, begin, target);
        
        if(!check) return 0;
        else return answer;
    }
    
    //DFS
    public static void DFS(String[] words, String str, String target) {
        
        //다 사용했다면 return
        boolean flag = true;
        for(int i=0; i<isvisited.length; i++){
            if(!isvisited[i]) flag = false;
        }
        
        if(flag) return;
        
        
        //target 확인
        if(str.equals(target)) {
            check=true;
            answer=Math.min(answer, min);
        }
        
        for(int i=0; i<words.length; i++){
            if(isvisited[i]) continue;
            
             //한글자만 다른 글자 찾기
            char[] charr1 = str.toCharArray();
            char[] charr2 = words[i].toCharArray();
            
            int count = 0;
            for(int j=0; j<charr1.length; j++){
                if(charr1[j]!=charr2[j]) count++;
            }
            
            //다음 글자 DFS
            if(count==1) {
                min++;
                isvisited[i]=true;
                DFS(words, words[i], target);
                
                min--;
                isvisited[i]=false;
            }
        }
        
    }
}