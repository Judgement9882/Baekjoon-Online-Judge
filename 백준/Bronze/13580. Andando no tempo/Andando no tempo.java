import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        boolean ans = false;
        if(A==B || B==C || C==A) ans = true;
        if(A == B+C || B == A+C || C == A+B) ans = true;
        sb.append(ans?"S":"N");
        System.out.print(sb);
        br.close();
    }
}