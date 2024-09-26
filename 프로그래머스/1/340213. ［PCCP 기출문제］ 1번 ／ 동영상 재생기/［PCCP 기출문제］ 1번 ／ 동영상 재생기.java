class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        
        //오프닝 시작과 끝 분단위로 변경
        int sopening = mtime(op_start);
        int eopening = mtime(op_end);
        
        //시작과 끝 분단위로 변경
        int video = mtime(video_len);
        
        String cur = pos;
        for(int i=0; i<commands.length; i++){
            
            //현재 시간 분단위
            int curtime = mtime(cur);
            
            //만약 오프닝 구간이라면,
            if(sopening<=curtime && curtime<eopening) {
                cur=op_end;
                curtime = eopening;
            }
            
            //next
            if(commands[i].equals("next")) {

                if(video<=curtime+10) {
                    cur = video_len;
                    curtime = eopening;
                } 
                
                else {
                    cur = stime(curtime+10);
                    curtime+=10;
                }
            }
            
            //prev
            else if(commands[i].equals("prev")) {
                
                if(curtime-10<=0) { //10초 전이 비디오 시작보다 전이라면
                    cur = "00:00";
                    curtime = 0;
                }
                else {
                    cur = stime(curtime-10);
                    curtime-=10;
                }
            }
            
            //만약 오프닝 구간이라면,
            if(sopening<=curtime && curtime<eopening) {
                cur=op_end;
                curtime = eopening;
            }
            
        }
        
        return cur;
    }
    
    //분 단위 시간을 String형식의 시간으로 변경
    public static String stime(int mtime) {
        int hour = mtime/60;
        int minute = mtime%60;
        
        return String.format("%02d:%02d", hour, minute);
    }
    
    //String형식의 시간을 분 단위로 변경
    public static int mtime(String time) {
        String[] times = time.split(":");
        
        int hour = Integer.parseInt(times[0]);
        int minute = Integer.parseInt(times[1]);
        
        return (hour*60)+minute;
    }
}