import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken()) * 3600;
        st.nextToken();
        A += Integer.parseInt(st.nextToken()) * 60;
        st.nextToken();
        A += Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int B = Integer.parseInt(st.nextToken()) * 3600;
        st.nextToken();
        B += Integer.parseInt(st.nextToken()) * 60;
        st.nextToken();
        B += Integer.parseInt(st.nextToken());

        sb.append(B>A?B-A:B-A+3600*24);

        System.out.print(sb);
        br.close();
    }
}