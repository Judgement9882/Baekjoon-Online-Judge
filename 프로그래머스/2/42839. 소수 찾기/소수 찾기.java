import java.util.*;
class Solution {
    
    int MAX = 1_000_000, N;
    int[] eratos = new int [1000001];
    boolean[] vis;
    HashSet<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        N = numbers.length();
        vis = new boolean[N];
        // 0. 에라토스테네스의 체
        eratostenes();
        
        // // 1. numbers를 정수 형태의 배열로 바꾸기
        // for(int i = 0; i < N; i++){
        //     arr[i] = numbers.charAt(i) - '0';
        // }
        
        dfs(numbers, "", 0);
        
        int answer = 0;
        for(int temp : set){
            // if(eratos[temp] != 0) answer++;
            if(temp == 0 || temp == 1) continue;
            if(check(temp)) answer++;
        }
        return answer;
    }
    
    void dfs(String numbers, String num, int cnt){
        if(cnt == N) return;
        
        for(int i = 0; i < N; i++){
            if(vis[i]) continue;
            vis[i] = true;
            set.add(Integer.parseInt(num + numbers.charAt(i)));
            dfs(numbers, num + numbers.charAt(i), cnt+1);
            vis[i] = false;
        }
    }
    
    
    public void eratostenes(){
        for(int i = 2; i <= MAX; i++) eratos[i] = i;
        
        for(int i = 2; i <= MAX; i++){
            if(eratos[i] == 0) continue;
            
            for(int j = 2*i; j <= MAX; j+=i){
                eratos[j] = 0;
            }
        }
    }
    
    public boolean check(int num){
        for(int i = 2; i <= Math.sqrt(num); i++){
            if(num % i == 0) return false;
        }
        return true;
    }
    
}

/*
    부분집합으로 풀기
    
    1. numbers를 정수 형태의 배열로 바꾸기
    2. 부분 집합으로 사용하는 수 저장하기
    3. 순열로 수의 조합을 만들기.
    4. 해당 수가 소수인지 판별하기
*/

