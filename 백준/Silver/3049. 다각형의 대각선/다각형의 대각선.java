import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        // nC4
        int ans = N * (N-1) * (N-2) * (N-3) / (4*3*2);
        System.out.println(ans);
        br.close();
    }
}