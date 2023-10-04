import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int A[] = new int[N];
        int B[] = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N; i++){
            B[i] = Integer.parseInt(st.nextToken());
        }
        int ans = 0;
        for(int i = 0 ; i < N; i++){
            if(B[i] > A[i]) ans += B[i] - A[i];
        }
        System.out.print(ans);
        br.close();
    }
}