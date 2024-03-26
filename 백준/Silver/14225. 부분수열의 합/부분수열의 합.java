import java.io.*;
import java.util.*;
public class Main {
    static int N;

    static int[] arr;
    static boolean[] vis;
    static HashSet<Integer> set = new HashSet<>();
    static void func(int cnt, int sum){
        if(cnt == N){
            set.add(sum);
            return;
        }
        func(cnt+1, sum + arr[cnt]);
        func(cnt+1, sum);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        vis = new boolean[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        func(0, 0);
        int num = 1;
        while(true){
            if(!set.contains(num)){
                sb.append(num);
                break;
            }
            num++;
        }
        System.out.println(sb);
        br.close();
    }
}