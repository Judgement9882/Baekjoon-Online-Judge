import java.util.*;
class Solution {
    class Process{
        int priority;
        int index;
        Process(int priority, int index){
            this.priority = priority;
            this.index = index;
        }
    }
    
    public int solution(int[] priorities, int location) {
        // 정답을 담는 배열
        int [] answer = new int[priorities.length];
        
        // 실행 대기 큐
        ArrayDeque<Process> q = new ArrayDeque<>();
        for(int i = 0; i < priorities.length; i++){
            q.offer(new Process(priorities[i], i));
        }
        
        // 우선순위 정렬
        Integer [] ordered_priorities = new Integer [priorities.length];
        for(int i = 0; i < priorities.length; i++){
            ordered_priorities[i] = priorities[i];
        }
        Arrays.sort(ordered_priorities, Collections.reverseOrder());
        int index = 0;
        
        while(!q.isEmpty()){
            Process cur = q.poll();
            if(cur.priority == ordered_priorities[index]){
                answer[cur.index] = ++index;
            }
            else q.offer(cur);
        }
        
        
        return answer[location];
    }
}