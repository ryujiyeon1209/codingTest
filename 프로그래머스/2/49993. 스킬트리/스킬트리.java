import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        String[] charSkill = skill.split("");
        
        for(int i=0; i<skill_trees.length; i++){
            String[] str = skill_trees[i].split("");
            List<String> treeList = new ArrayList(Arrays.asList(str));
            
            int[] seq = new int[charSkill.length];
            for(int j=0; j<seq.length; j++){
                seq[j] = treeList.indexOf(charSkill[j]);
            }
            
            for(int j=0; j<seq.length; j++){
                seq[j] = treeList.indexOf(charSkill[j]);
            }
            
            boolean flag = false;
            boolean isCorrect = true;
            for(int j=seq.length-1; j>=0; j--){
                if(seq[j]!=-1) flag=true;        
                if(flag && seq[j]==-1) isCorrect = false;    
                if(j!=0 && flag && seq[j]<seq[j-1]) isCorrect = false;
            }
            
            if(isCorrect) answer++;
            
        }
        
        return answer;
    }
}