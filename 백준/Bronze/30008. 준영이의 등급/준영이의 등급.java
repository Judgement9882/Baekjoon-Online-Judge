import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        while(K-->0){
            int G = Integer.parseInt(st.nextToken());
            int P = G * 100 / N;
            if(P <= 4) sb.append("1 ");
            else if(P <= 11) sb.append("2 ");
            else if(P <= 23) sb.append("3 ");
            else if(P <= 40) sb.append("4 ");
            else if(P <= 60) sb.append("5 ");
            else if(P <= 77) sb.append("6 ");
            else if(P <= 89) sb.append("7 ");
            else if(P <= 96) sb.append("8 ");
            else if(P <= 100) sb.append("9 ");
        }
        System.out.print(sb);
        br.close();
    }
}