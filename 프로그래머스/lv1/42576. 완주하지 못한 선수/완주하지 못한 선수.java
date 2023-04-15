import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        for(String s : participant){
            if(map.get(s) == null) map.put(s, 1);
            else map.put(s, map.get(s)+1);
        } 
        for(String s : completion) {
            if(map.get(s)==1) map.remove(s);
            else map.put(s, map.get(s)-1);
        }
        
        String answer = "";
        for(String s : participant){
            if(map.get(s) != null) {
                answer = s;
                break;
            }
        }
        
        
        return answer;
    }
}