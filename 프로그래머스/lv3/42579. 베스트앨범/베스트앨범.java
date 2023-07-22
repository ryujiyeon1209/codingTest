import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
       
        //장르마다 몇 번 재생했는지 확인하기
    	Map<String, Integer> map = new HashMap();
    	for(int i=0; i<genres.length; i++) {
    		if(map.containsKey(genres[i])) map.put(genres[i], map.get(genres[i])+plays[i]);
    		else map.put(genres[i], plays[i]);
    	}
        

        int[][] list = new int[genres.length][3];
        for(int i=0; i<genres.length; i++) {
        	list[i][0]=i;					//고유번호
        	list[i][1]=plays[i];			//노래 재생횟수
        	list[i][2]=map.get(genres[i]);	//장르 재생횟수
        }
        
        //정렬
        Arrays.sort(list, new Comparator<int[]>(){
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[2]!=o2[2]) return o2[2]-o1[2];
				else if(o1[1]!=o2[1]) return o2[1]-o1[1];
				return o1[0]-o2[0];
			}
        });

        //result에 노래 수록하기
        List<Integer> result = new ArrayList<Integer>();
        
        int count=0; int time=list[0][2];
        for(int i=0; i<list.length; i++) {
        	if(count>=2 && time==list[i][2]) continue;
        	else if(time!=list[i][2]) { count=0; time=list[i][2];}
        	count++;
        	result.add(list[i][0]);
        }
        
        //리스트 배열로 바꾸기
        int[] answer = new int[result.size()];
        for(int i=0; i<result.size(); i++) {
        	answer[i]=result.get(i);
        }
        
        return answer;
    }
}
