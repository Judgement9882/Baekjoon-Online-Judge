import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean [] arr = new boolean[10];
        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(st.nextToken());
            arr[num] = true;
        }

        for(int i = 0; i < 10; i++){
            if(arr[i]) sb.append(i).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}