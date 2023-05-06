import java.util.*;
class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        HashMap<String, String> parent = new HashMap<>();
        HashMap<String, Integer> profit = new HashMap<>();
        for(int i = 0; i < enroll.length; i++){
            profit.put(enroll[i], 0);
            parent.put(enroll[i], referral[i]);
        }

        for(int i = 0; i < seller.length; i++){
            int origin = amount[i]*100;
            String target = seller[i];
            while(origin > 0){
                int temp = origin/10;
                profit.put(target, profit.get(target)+origin-temp);
                origin = temp;
                
                target = parent.get(target);
                if(target.equals("-")) break;
            }
        }

        int[] answer = new int[enroll.length];
        for(int i = 0 ; i < enroll.length; i++){
            answer[i] = profit.get(enroll[i]);
        }
        return answer;
    }
}