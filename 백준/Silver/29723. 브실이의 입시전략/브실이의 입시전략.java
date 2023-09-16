import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int check = M-K;
        HashMap<String, Integer> score = new HashMap<>();
        // 입력
        while(N-->0){
            st = new StringTokenizer(br.readLine());
            score.put(st.nextToken(), Integer.parseInt(st.nextToken()));
        }

        // 과목 선택 후 제거
        int ans = 0;
        while(K-->0){
            String temp = br.readLine();
            ans += score.get(temp);
            score.remove(temp);
        }

        Integer[] values = score.values().toArray(new Integer[0]);
        Arrays.sort(values);
        // 오름차순 정렬
        int size = score.size();
        int min = 0;
        int max = 0;
        for(int i = 0 ; i < check; i++){
            min += values[i];
            max += values[size-1-i];
        }
        System.out.print((min+ans) + " " + (max+ans));

        br.close();
    }
}