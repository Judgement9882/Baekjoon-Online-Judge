import java.util.*;
class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        
        int cnt = 0;
        for(int n : nums){
            cnt++;
            set.add(n);
        }
        int divide = cnt/2;
        
        int answer = Math.min(divide, set.size());
        return answer;
    }
}


/*
set 처리
3, 1, 2, 3 -> 3가지 -> 이중에서 2개 뽑음 -> 2
3 1 2 3 4 5 -> 5가지 -> 이중에서 3개 뽑음 -> 3
3 3 3 3 3 3 2 2 -> 2가지 -> 이중에서 4개 뽑음 -> 2
Min(종류수, 뽑는 경우)

*
*/