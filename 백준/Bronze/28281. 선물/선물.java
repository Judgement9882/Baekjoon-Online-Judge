import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int A[] = new int[N];
        for(int i= 0 ; i  < N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        int temp = A[0]+A[1];
        int ans = temp;
        for(int i = 2; i < N; i++){
            temp = temp + A[i] - A[i-2];
            ans = Math.min(ans, temp);
        }
        System.out.print(ans*X);
        br.close();
    }
}