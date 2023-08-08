import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        boolean [] arr = new boolean[1001];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N; i++){
            arr[Integer.parseInt(st.nextToken())] = true;
        }
        int ans = 0;
        for(int i = 0 ; i <= 1000; i++){
            if(arr[i]){
                ans++;
                for(int j = i; j < i+L; j++){
                    if(j > 1000) break;
                    arr[j] = false;
                }
            }
        }
        System.out.print(ans);
        br.close();
    }
}