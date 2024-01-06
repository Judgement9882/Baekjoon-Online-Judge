import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        Double piR2 = Double.parseDouble(st.nextToken());
        Double R2 = piR2 / Math.PI;
        sb.append(2*Math.PI*Math.sqrt(R2));
        System.out.println(sb);
        br.close();
    }
}