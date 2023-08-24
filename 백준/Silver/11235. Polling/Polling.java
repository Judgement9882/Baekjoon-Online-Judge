import java.io.*;
import java.util.*;
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();
        int max_num = 0;
        for(int i = 0; i < N; i++){
            String temp = br.readLine();
            int num = map.getOrDefault(temp, 0)+1;
            map.put(temp, num);
            max_num = Math.max(max_num, num); // 최댓값 저장
        }
        Object [] mapObj = map.entrySet().toArray();
        // 정렬을 위한 리스트
        ArrayList<String> arr = new ArrayList<>();
        for(Object key : mapObj){
            Object[] temp = key.toString().split("=");
            if(Integer.parseInt(temp[1].toString()) == max_num) arr.add(temp[0].toString());
        }
        if(arr.size()==1) System.out.print(arr.get(0));
        else{
            StringBuilder sb = new StringBuilder();
            Collections.sort(arr);
            for(String temp: arr){
                sb.append(temp).append("\n");
            }
            System.out.print(sb);
        }
        br.close();
    }
}