import java.io.*;
import java.util.*;
public class Main {
//    static int arr [];
    static long segTree[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
//        arr = new int[N];

        int H = (int)Math.ceil(Math.log(N)/Math.log(2));
        int tree_size = (1<<(H+1));
        segTree = new long[tree_size];
//        init(1, 0, N-1);

        while(Q-->0){
            st = new StringTokenizer(br.readLine());
            int order = Integer.parseInt(st.nextToken());
            if(order==2) {
                int p = Integer.parseInt(st.nextToken());
                int q = Integer.parseInt(st.nextToken());
                sb.append(query(1, 0, N-1, p-1, q-1)).append("\n");
            }
            else{
                int p = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                update(1, 0, N-1, p-1, x);
            }
        }
        System.out.print(sb);
        br.close();
    }

//    static void init(int node, int start, int end){
//        // leaf node
//        if(start==end) {
//            segTree[node] = arr[start];
//            return;
//        }
//
//        init(node*2, start, (start+end)/2);
//        init(node*2+1, (start+end)/2 + 1, end);
//        segTree[node] = segTree[node*2]*segTree[node*2+1];
//    }

    static void update(int node, int start, int end, int index, int val){
        if(index < start || end < index) return;
        // leaf node
        if(start==end){
//            arr[index] += val;
            segTree[node] += val;
            return;
        }

        // find leaf node
        update(node*2, start, (start+end)/2, index, val);
        update(node*2+1, (start+end)/2+1, end, index, val);
        segTree[node] = segTree[node*2]+segTree[node*2+1];
    }

    static long query(int node, int start, int end, int left, int right){
        if(right < start || end < left) return 0;

        if(left <= start && end <= right){
            return segTree[node];
        }

        long lNode = query(node*2, start, (start+end)/2 , left, right);
        long rNode = query(node*2+1, (start+end)/2+1, end, left, right);
        return lNode+rNode;
    }
}