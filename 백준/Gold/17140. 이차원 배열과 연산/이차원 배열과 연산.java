import java.util.*;
import java.util.Map.Entry;
import java.io.*;

public class Main{

    static int r, c, k, ans, x_len, y_len;
    static int A[][];
    static PriorityQueue<int[]> pq = new PriorityQueue<>( (o1, o2) ->{
    	int r = Integer.compare(o1[1], o2[1]);
    	if(r==0) r = Integer.compare(o1[0], o2[0]);
    	return r;
    });

    // 원소의 개수만큼 pq에 pair로 만들어서 넣는 함수
    
    static void updateArray(int i, boolean row) {
    	int index = 1; // 이번에 넣어야할 인덱스
    	
    	if(row) {
    		while(!pq.isEmpty()) {
        		int cur[] = pq.poll();
        		
        		// 99, 100 까지 넣으면 끝
        		if(index <= 99) {
        			A[i][index++] = cur[0];
        			y_len = Math.max(y_len, index); // 현재 위치의 최댓값
        			A[i][index++] = cur[1];
        		}
        		
        		
        		if(index >= 100) {
        			pq.clear();
        			break;
        		}
    		}
    		
    	}
    	else {
    		while(!pq.isEmpty()) {
        		int cur[] = pq.poll();
        		
        		// 99, 100 까지 넣으면 끝
        		if(index <= 99) {
        			A[index++][i] = cur[0];
        			x_len = Math.max(x_len, index); // 현재 위치의 최댓값
        			A[index++][i] = cur[1];
        		}
        		
        		if(index >= 100) {
        			pq.clear();
        			break;
        		}
    		}
    	}
    }
    
    // pq에 있는 원소를 꺼내서 A 배열에 적용하는 함수
//    static void insertIntoPQ(int[] num) {
//	}
    
    private static void insertIntoPQ(HashMap<Integer, Integer> num) {
    	num.forEach((key, value)->{
    		pq.offer(new int[] {key, value});
    	});
	}
    
    // 1차원 배열을 순회하면서 원소의 개수를 세는 함수
    static void countNumber(int i, int range, boolean row) {
    	HashMap<Integer, Integer> num = new HashMap<>();
    	
    	// 행 처리
    	if(row) {
			for(int j = 1 ; j <= range; j++) {
				if(A[i][j] == 0) continue;
				if(num.get(A[i][j]) == null) num.put(A[i][j], 1);
				else num.put(A[i][j], num.get(A[i][j])+1);
				A[i][j] = 0;
			}
    	}
    	// 열 처리
    	else {
    		for(int j = 1 ; j <= range; j++) {
    			if(A[j][i] == 0) continue;
				if(num.get(A[j][i]) == null) num.put(A[j][i], 1);
				else num.put(A[j][i], num.get(A[j][i])+1);
				A[j][i] = 0;
			}
    	}
    	
		insertIntoPQ(num);
	}
    
	

	static void solve() {
        // 될때까지 반복
        int hundred = 100;
        for(int N = 0 ; N <= hundred; N++) {
            if(A[r][c] == k) {
            	ans = N;
            	break;
            }
            
            // 함수를 실행하면서 x_len, y_len 이 바뀌므로 지역변수로 설정
            int i_len = x_len;
            int j_len = y_len;
            
            // R연산
            if(i_len >= j_len) {
            	y_len = 0; // 매 연산마다 값이 달라지므로 0으로 초기화
            	for(int i = 1 ; i <= i_len; i++) {
            		countNumber(i, j_len, true);
            		updateArray(i, true);
            	}
            }
            // C연산
            else {
            	x_len = 0; // 매 연산마다 값이 달라지므로 0으로 초기화
            	for(int j = 1 ; j <= j_len; j++) {
            		countNumber(j, i_len, false);
            		updateArray(j, false);
            	}
            }
            
        }
    }
    
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        A = new int[101][101]; // 100까지 저장
        
        // 첫째 줄
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        // 둘째 줄 3*3 A배열 들어갈 수 입력
        x_len = 3; y_len = 3;
        for(int i = 1 ; i <= x_len; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1 ; j <= y_len; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // A[r][c]에 들어있는 값이 k가 되기위한 연산의 최소 시간 출력.
        // 100초가 지나도 안되면 -1 출력 => ans=-1 초기화
        ans = -1;
        solve();
        System.out.println(ans);
        br.close();
    }
}