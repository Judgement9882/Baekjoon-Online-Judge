import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int arr[] = new int[N];
        int total = 0;
        for(int i = 0; i < N; i++){
            int temp = Integer.parseInt(br.readLine());
            total += temp;
            arr[i] = temp;
        }
        int money = D/total;
        for(int i = 0; i < N; i++){
            sb.append(arr[i]*money).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}