import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        int ans = 0;

        // 소인수 분해
        for(int i = 1; i <= N; i++){
            int cur = i; // 현재 수
            int max = 0; // 최대 소인수
            int index = 2; // 2부터 나누기 시작
            while(index <= Math.sqrt(i)){ // sqrt(i) 까지만 확인하면됨
                if(cur % index == 0){ // 나누어진다면
                    cur /= index; // 현재 수 갱신
                    max = index; // max에 소인수 갱신
                }else index++; // 나누어 지지 않으면 index 증가
            }

            if(cur != 1) max = cur; // 1이 아니라면 cur이 가장 큰 소인수
            if(max <= K) ans++;
        }

        System.out.println(ans);
        br.close();
    }
}