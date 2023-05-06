class Solution {

    int answer = 0;

    public int solution(int[] nums) {
        func(0, 0, 0, nums);
       
        return answer;
    }

    void func(int cnt, int start, int sum, int[] nums){
        if(cnt == 3){
            if(isPrime(sum)) answer++;
            return;
        }

        for(int i = start; i < nums.length; i++){
            sum += nums[i];
            func(cnt+1, i+1, sum, nums);
            sum -= nums[i];
        }
    }

    boolean isPrime(int num){
        for(int i = 2; i * i <= num; i++){
            if(num % i == 0) return false;
        }
        return true;
    }
}