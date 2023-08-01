import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(T-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());

            ArrayList<Integer> arr = new ArrayList<>();
            while(st.hasMoreTokens()){
                arr.add(Integer.parseInt(st.nextToken()));
            }
            int N = arr.size();
            long ans = 0;
            for (int i = 0; i < N - 1; i++) {
                for (int j = i + 1; j < N; j++) {
                    ans = Math.max(ans, cal_gcd(arr.get(i), arr.get(j)));
                }
            }
            sb.append(ans).append("\n");

        }
        System.out.println(sb);
        br.close();
    }

    static long cal_gcd(long a, long b) {
        long c;
        while(b!=0) {
            c = a%b;
            a = b;
            b = c;
        }
        return a;
    }
}