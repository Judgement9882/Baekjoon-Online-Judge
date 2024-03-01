import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb.append(Integer.parseInt(st.nextToken()) % Integer.parseInt(st.nextToken()) == 0 ? "Yes" : "No");
        System.out.print(sb);
        br.close();
    }
}