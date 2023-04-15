import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        HashMap<String, Integer> map = new HashMap<>();
        for(String s : phone_book){
            String temp = "";
            for(int i = 0; i < s.length(); i++){
                temp += s.charAt(i);
                map.put(temp, map.getOrDefault(temp, 0)+1);
            }
        }
        
        for(String s : phone_book){
            if(map.get(s) >= 2){
                answer = false; break;
            }
        }
        return answer;
    }
}

/*
정렬 -> O(NlogN) -> 13,000,000
20자리 -> long으로
-> 결국 모두 탐색 -> 실패

글자 최대 20자리 -> 한글자씩 탐색?
20 * 백만 = 2천만 ok
set에 넣고 한글자씩 비교하고 없으면 set에 넣음

1, 11, 119, 9, 97, 976, ..., 1 -> 개수로 기억 -> map
2개 이상 있다? -> 자기자신 포함해서 하나 더 있다는 거니 false

*/