import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int place = 1;
        for(int i = 0; i < N; i++){
            if(str.charAt(i) == 'L') i++;
            place++;
        }
        sb.append(Math.min(place, N));
        System.out.println(sb);
        br.close();
    }
}