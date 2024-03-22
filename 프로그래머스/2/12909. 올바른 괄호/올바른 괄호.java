import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        ArrayDeque<Character> stack = new ArrayDeque<>();
        end : for(int i = 0; i < s.length(); i++){
            char cur = s.charAt(i);
            if(cur == '(') stack.push(cur);
            else{
                if(stack.isEmpty() || stack.peek() == ')'){
                    answer = false;
                    break end;
                }
                else stack.pop();
            }
        }
        if(!stack.isEmpty()) answer = false;
        return answer;
    }
}