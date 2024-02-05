import java.io.*;
import java.util.*;
public class Main {
    static int arr [];
    static int segTree[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            String temp = br.readLine();
            if(temp==null) break;
            StringTokenizer st = new StringTokenizer(temp);

            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            arr = new int[N];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i] = changeVal(num);
            }

            int H = (int)Math.ceil(Math.log(N)/Math.log(2));
            int tree_size = (1<<(H+1));
            segTree = new int[tree_size];
            init(1, 0, N-1);

            while(K-->0){
                st = new StringTokenizer(br.readLine());
                char order = st.nextToken().charAt(0);
                if(order=='P') {
                    int i = Integer.parseInt(st.nextToken());
                    int j = Integer.parseInt(st.nextToken());
                    int ret = query(1, 0, N-1, i-1, j-1);
                    if(ret == 0)        sb.append(0);
                    else if (ret==1)    sb.append("+");
                    else                sb.append("-");
                }
                else{
                    int i = Integer.parseInt(st.nextToken());
                    int V = Integer.parseInt(st.nextToken());
                    update(1, 0, N-1, i-1, changeVal(V));
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
        br.close();
    }

    static void init(int node, int start, int end){
        // leaf node
        if(start==end) {
            segTree[node] = arr[start];
            return;
        }

        init(node*2, start, (start+end)/2);
        init(node*2+1, (start+end)/2 + 1, end);
        segTree[node] = segTree[node*2]*segTree[node*2+1];
    }

    static void update(int node, int start, int end, int index, int val){
        if(index < start || end < index) return;
        // leaf node
        if(start==end){
            arr[index] = val;
            segTree[node] = val;
            return;
        }

        // find leaf node
        update(node*2, start, (start+end)/2, index, val);
        update(node*2+1, (start+end)/2+1, end, index, val);
        segTree[node] = segTree[node*2]*segTree[node*2+1];
    }

    static int query(int node, int start, int end, int left, int right){
        if(right < start || end < left) return 1;

        if(left <= start && end <= right){
            return segTree[node];
        }

        int lNode = query(node*2, start, (start+end)/2 , left, right);
        int rNode = query(node*2+1, (start+end)/2+1, end, left, right);
        return lNode*rNode;
    }

    static int changeVal(int num){
        int ret = 0;
        if(num < 0) ret = -1;
        else if(num > 0) ret = 1;
        return ret;
    }
}