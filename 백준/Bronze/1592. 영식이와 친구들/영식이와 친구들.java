import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken()) % N;

        int arr[] = new int[N];
        int index = 0;
        int ans = 0;
        while(true){
            arr[index]++;
            if(arr[index] == M) break;
            ans++;
            if(arr[index] % 2 == 1) index = (index + L) % N;
            else                    index = (index + N - L) % N;
        }
        sb.append(ans);
        System.out.println(sb);
        br.close();
    }
}