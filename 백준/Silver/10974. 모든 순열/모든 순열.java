import java.io.*;
import java.util.*;
public class Main {
    static StringBuilder sb = new StringBuilder();
    static int [] a, b;
    static boolean[] v;
    static int N;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        a = new int[N]; b = new int[N]; v = new boolean[N];
        for(int i = 0 ; i < N; i++) a[i] = i+1; // 원본 배열
        func(0);
        System.out.println(sb);
        br.close();
    }

    static void func(int k){
        if(N==k) { // 전부 선택 완료
            for(int i = 0 ; i < N; i++){
                sb.append(b[i]).append(" ");
            }
            sb.append("\n");

            return;
        }

        for(int i = 0; i < N; i++){
            if(!v[i]){
                b[k] = a[i];
                v[i] = true;
                func(k+1);
                v[i] = false;
            }
        }
    }
}