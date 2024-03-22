import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        /*
            1. 100%를 넘는 일수 저장
            2. 앞에서 부터 확인하며, 뒤의 작업이 앞 작업보다 작거나 같을때 +1
            3. 클 때는 이전까지 + 한 작업 수를 ArrayList에 저장
            4. 출력
        */
        int[] complete  = new int[progresses.length]; 
        int[] days      = new int[progresses.length]; 
        for(int i = 0; i < progresses.length; i++){
            int day = 0;
            complete[i] = progresses[i];
            while(complete[i] < 100){
                day++;
                complete[i] += speeds[i];
            }
            days[i] = day;
        }
        
        int num = 1, front = days[0]; 
        ArrayList<Integer> deploy = new ArrayList<>();
        for(int i = 1; i < progresses.length; i++){
            // 2. 앞에서 부터 확인하며, 뒤의 작업이 앞 작업보다 작거나 같을때 +1
            if(front >= days[i]) num++;
            // 3. 클 때는 이전까지 + 한 작업 수를 ArrayList에 저장
            else {
                deploy.add(num);
                // 초기화
                num = 1;
                front = days[i];
            }
            // 마지막의 경우 추가
            if(i==progresses.length-1) deploy.add(num);
        }
        
        int size = deploy.size();
        int [] answer = new int[size];
        for(int i = 0; i < size; i++){
            answer[i] = deploy.get(i);
        }

        return answer;
    }
}