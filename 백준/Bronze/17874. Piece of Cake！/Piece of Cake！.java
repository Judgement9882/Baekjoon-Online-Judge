import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        int ans = 0;
        ans = Math.max(ans, H*V);
        ans = Math.max(ans, (N-H)*V);
        ans = Math.max(ans, H*(N-V));
        ans = Math.max(ans, (N-H)*(N-V));
        sb.append(ans*4);
        System.out.print(sb);
        br.close();
    }
}