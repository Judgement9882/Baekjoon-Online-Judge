class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        boolean number[] = new boolean[46];
        for(int i : win_nums) number[i] = true;
        int num_of_zero = 0;
        int ans = 0;
        for(int i : lottos){
            if(i==0) num_of_zero++;
            else{
                if(number[i]) ans++;
            }
        }
        
        int[] answer = {ans+num_of_zero <= 1 ? 6 : 7-(ans+num_of_zero), ans <= 1?6:7-ans};
        return answer;
    }
}