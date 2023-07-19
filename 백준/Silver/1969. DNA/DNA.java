import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String [] DNA = new String[N];
        for(int i = 0 ; i < N; i++){
            DNA[i] = br.readLine();
        }
        StringBuilder sb = new StringBuilder();
        int ans = 0;
        // 1. 선택 (가장 많은 숫자)
        for(int i = 0; i < M; i++){
            int DNAs [] = new int[4];
            for(int j = 0 ; j < N; j++){
                char check = DNA[j].charAt(i);
                if(check == 'A') DNAs[0]++;
                else if(check == 'C') DNAs[1]++;
                else if(check == 'G') DNAs[2]++;
                else if(check == 'T') DNAs[3]++;
            }

            // 2. 스트링 추가
            int index = 0; int temp = DNAs[0]; int sum = DNAs[0];
            for(int j = 1 ; j < 4; j++){
                sum += DNAs[j];
                if(temp < DNAs[j]){
                    index = j;
                    temp = DNAs[j];
                }
            }

            // 3. 비교하고 ans에 더하기
            if(index == 0) sb.append("A");
            else if(index == 1) sb.append("C");
            else if(index == 2) sb.append("G");
            else if(index == 3) sb.append("T");
            ans += sum - temp;
        }

        System.out.println(sb);
        System.out.println(ans);
        br.close();
    }
}