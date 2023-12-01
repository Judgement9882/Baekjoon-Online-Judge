import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        double s1 = Double.parseDouble(st.nextToken());
        double s2 = Double.parseDouble(st.nextToken());
        System.out.println(s1>=(s2/2)?"E":"H");
        br.close();
    }
}