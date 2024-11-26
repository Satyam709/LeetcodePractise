import java.util.*;

public class PuzzleSolverBFS {
    static class LvlBoard{
        Board b;
        int lvl;
        LvlBoard(Board b,int lvl){
            this.b = b;
            this.lvl = lvl;
        }

        @Override
        public String toString() {
            return b+"lvl = "+lvl+"\n";
        }
    }

    public static int slidingPuzzle(int[][] board) {
        Set<Board> visited = new HashSet<>();
        Queue<LvlBoard> q = new LinkedList<>();
        Board root = new Board(board);
        q.add(new LvlBoard(root,0));
        visited.add(root);

        while (!q.isEmpty()){
            LvlBoard polled = q.poll();
            Board top = polled.b;
            if (top.isSolved) {
                return polled.lvl;
            }
            for (Board i :top.neighbors()){
                if (i!=null && !visited.contains(i)){
                    visited.add(i);
                    if (i.isSolved)return polled.lvl+1;
                    q.add(new LvlBoard(i,polled.lvl+1));
                }
            }
//            System.out.println(q);
        }
        return -1;
    }

    static class Board {
        private final int[][] board;
        private final int m, n;
        private int[] crnt;
        private boolean isSolved;

        Board(int[][] board) {
            m = 2;
            n = 3;
            isSolved = true;
            this.board = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    this.board[i][j] = board[i][j];
                    if (board[i][j] == 0)
                        crnt = new int[]{i, j};

                    if (i * n + j + 1 != board[i][j]) {
                        if (i == 1 && j==2);
                        else isSolved =false;
                    }
                }
            }
            if (isSolved) System.out.println(this+"is solved ");
        }
        @Override
        public int hashCode() {
            int result = 1;
            result = 31 * result + m;
            result = 31 * result + n;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    result = 31 * result + board[i][j];
                }
            }
            return result;
        }


        @Override
        public String toString() {
            StringBuilder str = new StringBuilder();
            str.append("\n");
            for (int i = 0; i <m; i++) {
                str.append(Arrays.toString(board[i])).append("\n");
            }
            return str.toString();
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) return false;                     // Null check
            if (this.getClass() != obj.getClass()) return false; // Type check

            Board o = (Board) obj;

            if (this.m != o.m || this.n != o.n) return false;  // Dimension check

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (this.board[i][j] != o.board[i][j]) {   // Element-wise comparison
                        return false;
                    }
                }
            }
            return true;
        }


        public int[] getCrnt() {
            return crnt;
        }

        public boolean isSolved() {
            return isSolved;
        }

        public Board[] neighbors(){
            Board[] adj = new Board[4];
            for (int i = 1; i <= 4 ; i++) {
                adj[i-1] = move(i);
            }
            return adj;
        }

        public Board move(int dir) {
            int row = crnt[0];
            int col = crnt[1];
            return switch (dir) {
                case 1 -> swap(row, col - 1);
                case 2 -> swap(row - 1, col);
                case 3 -> swap(row, col + 1);
                case 4 -> swap(row + 1, col);
                default -> null;
            };
        }

        private Board swap(int row, int col) {
            if (row < 0 || row >= m || col < 0 || col >= n) return null;
            int[][] board = new int[m][n];

//            System.out.println("swapping with " + this.board[row][col]);

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    board[i][j] = this.board[i][j];
                }
            }

            int t = board[row][col];
            board[row][col] = board[crnt[0]][crnt[1]];
            board[crnt[0]][crnt[1]] = t;

            return new Board(board);
        }
    }

    public static void main(String[] args) {
//        int[][] b = {{1,2,3},{4,0,5}};
//        System.out.println(slidingPuzzle(b));

        int[][] b2 = {{1,2,3},{5,4,0}};
        System.out.println(slidingPuzzle(b2));

//        int[][] b3 = {{4,1,2},{5,0,3}};
//        System.out.println(slidingPuzzle(b3));
//        Board b = new Board(new int[][]{{1,2,3},{4,5,0}});
      //  System.out.println(b);
    }
}
