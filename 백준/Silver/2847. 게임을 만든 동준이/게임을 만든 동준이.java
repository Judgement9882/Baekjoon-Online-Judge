import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] arr = new int[N];
        for(int i = 0;i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        int prev = arr[0], ans = 0, next = arr[N-1], ans1 = 0;
        for(int i = 1;i < N; i++){
            if(arr[i] > prev) prev = arr[i];
            else{
                prev++;
                ans += prev - arr[i];
            }

            if(arr[N-i-1] < next) next = arr[N-i-1];
            else{
                next--;
                ans1 += arr[N-i-1] - next;
            }
        }
        System.out.println(Math.min(ans, ans1));
        br.close();
    }
}

/*
99
2
3
 */