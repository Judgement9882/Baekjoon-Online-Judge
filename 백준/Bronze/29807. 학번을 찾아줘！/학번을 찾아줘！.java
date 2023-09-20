import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int score[] = new int[5];
        for(int i = 0; i < T; i++){
            score[i] = Integer.parseInt(st.nextToken());
        }
        long std_id = 0;

        // 국어 점수가 영어 점수보다 높다면, 두 점수의 차에 인문관의 건물 번호
        //$508$을 곱해준다. 아니라면, 두 점수의 차에 국제관의 건물 번호
        //$108$을 곱해준다.
        int diff = Math.abs(score[0] - score[2]);
        if(score[0] > score[2]) std_id += diff*508;
        else                    std_id += diff*108;

        // 수학 점수가 탐구 점수보다 높다면, 두 점수의 차에 제1공학관의 건물 번호
        //$212$를 곱해준다. 아니라면, 두 점수의 차에 ITBT관의 건물 번호
        //$305$을 곱해준다.
        diff = Math.abs(score[1] - score[3]);
        if(score[1] > score[3]) std_id += diff*212;
        else                    std_id += diff*305;

        // 제2외국어를 응시했다면 제2외국어 점수에 행원파크 건물 번호인
        //$707$을 곱해준다.
        std_id += score[4]*707;

        // 위에서 계산한 세 값을 더한 뒤, 한양대학교의 우편번호
        //$04763 (= 4763)$을 곱하면 학번이 나온다.
        System.out.print(std_id*4763);
        br.close();
    }
}