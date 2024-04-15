import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int p = 0, s = 0;
        int p1 = Integer.parseInt(st.nextToken());
        int s1 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int s2 = Integer.parseInt(st.nextToken());
        int p2 = Integer.parseInt(st.nextToken());
        p = p1+p2;
        s = s1+s2;
        if (p < s)  sb.append("Esteghlal");
        else if(p > s)        sb.append("Persepolis");
        else{
            if(s1 > p2) sb.append("Esteghlal");
            else if (s1 < p2) sb.append("Persepolis");
            else sb.append("Penalty");
        }
        System.out.print(sb);
        br.close();
    }
}