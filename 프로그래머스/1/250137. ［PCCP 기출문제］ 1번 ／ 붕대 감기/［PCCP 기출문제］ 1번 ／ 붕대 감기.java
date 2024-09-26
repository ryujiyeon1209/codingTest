import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        
        //마지막 공격 일시
        int lastattack = attacks[attacks.length-1][0];
        
        //붕대감기 기술 공격 횟수
        int count = 0;
        
        //현재 시간
        int time = 1;
        
        //공격 시간 인덱스
        int idx = 0;
        
        //최대 체력
        int maxhealth = health;
        
        //반복문
        while(time<=lastattack) {
            
            int attacktime = attacks[idx][0];
            
             //몬스터가 공격하기 전, 체력이 최대일 때
            if(time<attacktime && health==maxhealth){
                count++;
            }
            
            //몬스터가 공격하기 전, 붕대 감기 시전할 때
            else if(time<attacktime && health<maxhealth){
                if(count+1==bandage[0]) {
                    count=0;
                    health = Math.min(maxhealth, health+bandage[1]+bandage[2]);
                }
                
                else {
                    count++;
                    health=Math.min(maxhealth, health+bandage[1]);
                }
            }
            
            //몬스터가 공격할 때
            else if(time==attacktime) {
                count=0;
                health-=attacks[idx++][1];
                
                if(health<=0) break;
            }

            time++;
        }
        
        //남은 체력 확인
        if(health<=0) answer=-1;
        else answer = health;
        
        
        return answer;
    }
}