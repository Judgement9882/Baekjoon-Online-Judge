import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for(int t = 1; ;t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            if(n==0) break;
            ArrayList<Double> arr = new ArrayList<>();
            for(int i = 0 ; i < n; i++) arr.add(Double.parseDouble(st.nextToken()));
//            Collections.sort(arr);
            sb.append("Case ").append(t).append(": ");
            if(n%2==1) sb.append(arr.get(n/2));
            else sb.append((arr.get(n/2) + arr.get((n-1)/2))/2);
            sb.append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}