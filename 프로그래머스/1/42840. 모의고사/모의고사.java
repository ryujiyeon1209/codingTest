class Solution {
    public int[] solution(int[] answers) {
        
        int[] an1 = {1, 2, 3, 4, 5};
        int[] an2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] an3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int[] score = new int[3];
        for(int i=0; i<answers.length; i++){
            if(answers[i]==an1[i%5]) score[0]++;
            if(answers[i]==an2[i%8]) score[1]++;
            if(answers[i]==an3[i%10]) score[2]++;
        }
        
        int max = 0;
        for(int i=0; i<score.length; i++){
            if(max<score[i]) max=score[i];
        }
        
        int count = 0;
        for(int i=0; i<score.length; i++){
            if(max==score[i]) count++;
        }
        
        int idx=0;
        int[] answer = new int[count];
        for(int i=0; i<score.length; i++){
            if(max==score[i]) answer[idx++]=i+1;
        }
        
        return answer;
    }
}