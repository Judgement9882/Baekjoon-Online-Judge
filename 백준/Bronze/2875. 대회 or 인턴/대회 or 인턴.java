import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 만들 수 있는 최대 팀의 수
        int team = Math.min(N/2, M);
        // 팀에 못드는 학생 수
        int not_team = N + M - team*3;
        // 못 드는 학생 수가 인턴십 학생보다 많으면 상관없음
        // 적을 경우
        if(not_team < K){
            int minus = K-not_team;
            // 1, 2, 3 -> -1
            // 4, 5, 6 -> -2
            if(minus % 3 == 0) team -= minus/3;
            else team -= (minus/3 + 1);
        }
        System.out.println(team);
        br.close();
    }
}