import java.util.*;
public class Solution {
    public long solution(int[][] land, int P, int Q) {
        long answer = 0;
        long left = Integer.MAX_VALUE, right = 0;
        int N = land.length;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                left = Math.min(left, land[i][j]);
                right = Math.max(right, land[i][j]);       
            }
        }
        
        
        while(left <= right){
            
            long mid = (left+right)/2; 
            
            long answer1 = cal(land, P, Q, mid); // 정수
            long answer2 = cal(land, P, Q, mid+1); // 소수점 생각해서 +1
            

            if(answer1 > answer2){ // 
                answer = answer2;
                left = mid+1;
            }
            else{
                answer = answer1;
                right = mid-1;
            }
        }
        return answer;
    }

    long cal(int[][] land, int P, int Q, long height){
        long fee = 0;
        for(int i = 0; i < land.length; i++){
            for(int j = 0; j < land.length; j++){
                if(land[i][j] < height) fee += (height - land[i][j])*P;
                else if(land[i][j] > height) fee += (land[i][j] - height)*Q;
            }
        }
        return fee;
    }
}