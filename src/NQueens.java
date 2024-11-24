import edu.princeton.cs.algs4.Merge;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<List<String>>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        return res;
    }

    private void solveNQueens(char[][] board, int crntrow, int col,List<List<String>> res) {

        for (int i = 0; i < col; i++) {
            board[crntrow][i] = 'Q';
            if (isValid(board)){
                solveNQueens(board, crntrow, i, res);
            }
        }
    }
    private boolean isValid(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'Q') {
                    return false;
                }
            }
        }
        return true;
    }
}
