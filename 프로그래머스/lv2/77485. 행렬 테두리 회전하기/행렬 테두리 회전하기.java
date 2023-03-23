class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int [][] board = new int[rows+1][columns+1];
        for(int i = 1; i <= rows; i++){
            for(int j = 1; j <= columns; j++){
                board[i][j] = (i-1)*columns+j;
            }
        }
        int[] answer = new int[queries.length];
        for(int T = 0; T < queries.length; T++){
            int x1= queries[T][0];
            int y1= queries[T][1];
            int x2= queries[T][2];
            int y2= queries[T][3];
            
            int temp = board[x1][y1];
            int min_num = temp;
            for(int i = x1; i < x2; i++) {
                board[i][y1] = board[i+1][y1];
                min_num = Math.min(min_num, board[i][y1]);
            }
            
            for(int j = y1; j < y2; j++) {
                board[x2][j] = board[x2][j+1];
                min_num = Math.min(min_num, board[x2][j]);
            }
            for(int i = x2; i > x1; i--) {
                board[i][y2] = board[i-1][y2];
                min_num = Math.min(min_num, board[i][y2]);
            }
            
            for(int j = y2; j > y1; j--) {
                board[x1][j] = board[x1][j-1];
                min_num = Math.min(min_num, board[x1][j]);
            }
            board[x1][y1+1] = temp;
            
            // for(int i =1; i <= rows; i++){
            //     for(int j =1; j <= columns; j++){
            //         System.out.print(board[i][j] + " ");
            //     }
            //     System.out.println();
            // }
            
            answer[T] = min_num;
        }
        
        
        
        
        return answer;
    }
}