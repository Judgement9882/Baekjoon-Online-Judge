import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        // 큐로 저장
        ArrayDeque<Integer> q = new ArrayDeque();
        int last_num = -1;
        for(int temp : arr){
            if(last_num == -1) {
                last_num = temp;
                q.offer(temp);
            }
            else{
                // 다르면 갱신
                if(last_num != temp){
                    last_num = temp;
                    q.offer(temp);
                }
            }
        }
        int size = q.size();
        int[] answer = new int[size];
        for(int i = 0; i < size; i++){
            answer[i] = q.poll();
        }
        return answer;
    }
}