import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long [] end = new long[N];
        for(int i = 0 ; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            while(num-->0){
                end[i] += Integer.parseInt(st.nextToken());
            }
        }

        // 정렬
        Arrays.sort(end);

        // 누적합 배열 만들기
        for(int i = 1 ; i < N; i++){
            end[i] += end[i-1];
        }

        // 정답 출력
        long ans = 0;
        for(int i = 0 ; i < N; i++) ans += end[i];
        System.out.print(ans);
        br.close();
    }
}