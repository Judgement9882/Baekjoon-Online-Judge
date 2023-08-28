import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int arr[] =  new int[N];
        for(int i = 0 ; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        long sung = 0, park = 0;
        for(int i = 0; i < N; i++){
            if(i < N/2) sung+= arr[i];
            else park+= arr[i];
        }
        StringBuilder sb = new StringBuilder();
        sb.append(sung).append(" ").append(park);
        System.out.print(sb);
        br.close();
    }
}