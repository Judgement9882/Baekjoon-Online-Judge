import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st= new StringTokenizer(br.readLine());
        HashSet<Integer> num = new HashSet<>();
        HashSet<Integer> isUsed = new HashSet<>();
        int []arr = new int[N];
        for(int i = 0 ; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            num.add(arr[i]);
        }
        int ans = 0;
        for(int i = 0 ; i < N; i++){
            if((arr[i] != M-arr[i]) && num.contains(M - arr[i]) && !isUsed.contains(M - arr[i])){
                // num에 그 수가 있고 아직 사용하지 않았다면
                ans++;
                isUsed.add(arr[i]);
                isUsed.add(M - arr[i]);
            }
        }
        System.out.println(ans);

        br.close();
    }
}