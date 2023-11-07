import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            long a = Integer.parseInt(st.nextToken());
            long b = Integer.parseInt(st.nextToken());
            long c = Integer.parseInt(st.nextToken());

            long[] arr = new long[3];
            arr[0] = a*a;
            arr[1] = b*b;
            arr[2] = c*c;
            Arrays.sort(arr);
            sb.append("Scenario #").append(i).append(":\n");
            if(arr[2] == arr[1] + arr[0]) sb.append("yes\n\n");
            else sb.append("no\n\n");
        }
        System.out.println(sb);
        br.close();
    }
}