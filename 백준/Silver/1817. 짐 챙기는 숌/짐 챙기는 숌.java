import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        if(N==0){
            System.out.print(0);
            System.exit(0);
        }
        int ans = 1;
        int space = M;
        st = new StringTokenizer(br.readLine());
        while(N-->0){
            int weight = Integer.parseInt(st.nextToken());
            if(space >= weight) {
                space -= weight;
            }else{
                space = M-weight;
                ans++;
            }
        }
        System.out.println(ans);
        br.close();
    }
}