class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;

        int start = 1;
        int end = n;
        
        //기지국 설치 확인
        for(int i=0; i<stations.length; i++){

            int node = stations[i];
            int s = Math.max(1, node-w);
            int e = Math.min(n, node+w);

            //현재 좌표에 기지국 설치를 해야한다면
            if(start<s) {        
                answer+=(int)Math.ceil((s-start)*1.0/((2*w)+1));
                start=e+1;
            }
            
            //현재 좌표에 기지국 설치가 되어있다면
            else if(s<=start){
                start=e+1;
            }
            
            //마지막까지 설치가 되어있다면
            if(end<start) break;
        }
        
        //마지막 설치
        if(start<=end) {
            answer+=(int)Math.ceil((end-start+1)*1.0/((2*w)+1));
        }

        return answer;
    }
}

// System.out.println("start : " +start+ ", s : " +s+ ", e : " +e+ " > answer : " +answer);