import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int ans = Integer.MAX_VALUE;
        int num = A, temp = B;
        while(num < N){
            num += A;
            temp += B;
        }
        ans = Math.min(ans, temp);

        num = C;
        temp = D;
        while(num < N){
            num += C;
            temp += D;
        }
        ans = Math.min(ans, temp);
        sb.append(ans);
        System.out.print(sb);
        br.close();
    }
}