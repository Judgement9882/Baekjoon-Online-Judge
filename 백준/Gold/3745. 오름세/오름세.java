import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true){
            String temp = br.readLine();
            if(temp==null) break;
            int N = Integer.parseInt(temp.trim());
            int [] A = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i < N; i++) A[i] = Integer.parseInt(st.nextToken());

            // LIS 배열
            int [] LIS = new int[N];

            // 기억하기 위한 record 배열
            int [] record = new int[N];

            // 초기값은 첫번째 값
            LIS[0] = A[0];
            int len_of_LIS = 1; // LIS 길이
            record[0] = len_of_LIS; // LIS의 인덱스를 저장

            for(int i = 1; i < N; i++){
                // 만약 현재 A[i] 값이 LIS의 마지막 값 보다 크다?
                // => LIS에 원소 추가
                if(A[i] > LIS[len_of_LIS-1]) {
                    LIS[len_of_LIS++] = A[i];
                    record[i] = len_of_LIS;
                }

                // 아닐 경우 대치가 가능한지 확인
                else{
                    int left = 0;
                    int right = len_of_LIS;
                    while(left < right){
                        int mid = (left + right) >> 1;

                        // lower bound
                        // 특정 값의 시작 위치
                        if (LIS[mid] < A[i]) left = mid + 1;
                        else right = mid;
                    }

                    LIS[left] = A[i];
                    record[i] = left+1;
                }
            }

            sb.append(len_of_LIS).append("\n");
        }



//        // LIS 값 찍기
//        int cnt = 0;
//        int result_MAX = len_of_LIS;
//        int result_LIS [] = new int[N];
//
//        for(int i = N-1; i >= 0; i--){
//            if(record[i] == result_MAX){
//                result_LIS[cnt++] = A[i];
//                result_MAX--;
//            }
//        }
//
//        for(int i = cnt-1; i >= 0; i--) sb.append(result_LIS[i]).append(" ");
        System.out.println(sb);
        br.close();
    }
}