import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = 0;
        max += Integer.parseInt(st.nextToken()) * 3;
        max += Integer.parseInt(st.nextToken()) * 20;
        max += Integer.parseInt(st.nextToken()) * 120;

        st = new StringTokenizer(br.readLine());
        int mel = 0;
        mel += Integer.parseInt(st.nextToken()) * 3;
        mel += Integer.parseInt(st.nextToken()) * 20;
        mel += Integer.parseInt(st.nextToken()) * 120;

        if      (max == mel)    System.out.println("Draw");
        else if (max >  mel)    System.out.println("Max");
        else                    System.out.println("Mel");
        br.close();
    }
}