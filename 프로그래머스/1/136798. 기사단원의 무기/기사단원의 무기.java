class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        //1부터 number까지 반복
        for(int t=1; t<=number; t++){
            
            //약수의 개수 구하기
            int count = 0;
            for(int i=1; i*i<=t; i++){
                if(i*i==t) count++;
                else if(t%i==0) count+=2;
                
                //제한에 걸린다면
                if(limit<count) {
                    count=power; 
                    break;
                }
            }
            
            answer+=count;
        }
 
            
        return answer;
    }
}