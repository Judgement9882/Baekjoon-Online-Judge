import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st= new StringTokenizer(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0 ; i < N; i++){
            arr.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(arr, Collections.reverseOrder());
        int ans = 0;
        for(int i = 0 ; i < N; i++){
            ans = Math.max(ans, arr.get(i)+i+1);
        }
        System.out.println(ans+1);
        br.close();
    }
}

/*
2 3 4 3

4 3 3 2
1 2 3 4


39 39 38 35 20 9
1  2  3  4  5  6

 */