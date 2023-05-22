class Solution {
    public List<List<String>> solveNQueens(int n) {  
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j] = '.';
            } }
        Queens(0, res, board);
        return res;
    }

    static void Queens(int col, List<List<String>> res, char[][] board){
        if(col == board.length){
            res.add(construct(board));
            return;
        }
        for(int row=0; row<board.length; row++){
            if(validate(row, col, board)){
                board[row][col] = 'Q';
                Queens(col+1, res, board);
                board[row][col] = '.';
            } }
    }

    static boolean validate(int row, int col, char[][] board){
        int j = col, i = row;
        while(j >= 0)
        {
            if(board[i][j] == 'Q') return false;
            j--;
        }
        j = col;
        while(i >= 0 && j >= 0)
        {
            if(board[i][j] == 'Q') return false;
            i--;
            j--;
        } 
        i = row; j = col;
        while(i < board.length && j >= 0)
        {
            if(board[i][j] == 'Q') return false;
            i++;
            j--;
        }
        return true;
    }

    static List<String> construct(char[][] board){
       List<String> ans = new ArrayList<>();
       for(int i=0; i<board.length; i++){
           String s = new String(board[i]);
           ans.add(s);
       } 
       return ans;
    }

}