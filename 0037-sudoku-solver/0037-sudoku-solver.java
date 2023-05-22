class Solution {
    public void solveSudoku(char[][] board) {
        
        solve(board);
    }
    
    static boolean solve(char[][] board){
        
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(board[i][j] == '.')
                {
                    for(char ch='1'; ch<='9'; ch++)
                    {  
                        if(validate(board, i, j, ch))
                        {
                            board[i][j] = ch;
                            if(solve(board))  
                                return true;
                            else  
                                board[i][j] = '.';
                        }
                    }
                    return false;
                } } }
        return true;
    }
    
    static boolean validate(char[][] board, int i, int j, char ch){
        
        for(int k=0; k<9; k++)
        {
            if(board[i][k] == ch) 
                return false;
            if(board[k][j] == ch) 
                return false;
            if (board[3 * (i / 3) + k / 3][3 * (j / 3) + k % 3] == ch)
                return false;
        }
        return true;
    }
}