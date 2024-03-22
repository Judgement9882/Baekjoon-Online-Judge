import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int one = one_solve(answers);
        int two = two_solve(answers);
        int three = three_solve(answers);
        int max = Math.max(one, Math.max(two, three));
        int num = 0;
        ArrayList<Integer> list = new ArrayList<>();
        if(max==one) list.add(1);
        if(max==two) list.add(2);
        if(max==three) list.add(3);
        int []answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
    
    int one_solve(int[] answers){
        int ans = 0;
        for(int i = 0; i < answers.length; i++){
            // 1, 2, 3, 4, 5, 1...
            if(answers[i] == (i%5)+1 ) ans++;
        }
        return ans;
    }
    
    int two_solve(int[] answers){
        int ans = 0;
        
        int [] temp = {1, 3, 4, 5};
        int index = 0;
        for(int i = 0; i < answers.length; i++){
            if(i%2==0){
                if(answers[i] == 2) ans++;
            }else{
                if(answers[i] == temp[index]) ans++;
                index = (index+1)%4;
            }
        }
        
        return ans;
    }
    
    int three_solve(int[] answers){
        int ans = 0;
        int [] temp = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int index = 0;
        for(int i = 0; i < answers.length; i++){
            if(answers[i] == temp[index]) ans++;
            index = (index+1)%10;
        }
        return ans;
    }
}