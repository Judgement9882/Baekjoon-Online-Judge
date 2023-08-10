import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int arr[] = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        // 시작과끝에서 찾아감
        int start = 0;
        int end = N-1;
        int ans = 0;
        while(start < end){
            int weight = arr[start]+arr[end];
            if(weight <= K){ // 가능한 조합
                start++;
                end--;
                ans++;
            }
            else end--;
        }
        System.out.print(ans);
        br.close();
    }
}