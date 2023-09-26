import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int arr[] = new int[M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < M; j++){
                arr[j] += Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        // 슬라이딩 윈도우

        int cur = 0;
        for(int j = 0; j < A; j++){
            cur += arr[j];
        }
        int ans = cur;
        for(int j = A; j < M; j++){
            cur += arr[j] - arr[j-A];
            ans = Math.max(ans, cur);
        }

        System.out.print(ans);
        br.close();
    }
}