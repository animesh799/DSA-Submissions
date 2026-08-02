class Solution {

    // Stores all valid board configurations.
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {

        // Tracks occupied '\' diagonals.
        // Formula: row - col + (n - 1)
        boolean[] visitedRightDiagonal = new boolean[2 * n - 1];

        // Tracks occupied '/' diagonals.
        // Formula: row + col
        boolean[] visitedLeftDiagonal = new boolean[2 * n - 1];

        // Tracks occupied columns.
        boolean[] visitedColumn = new boolean[n];

        // Initialize the board with empty cells.
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        // Start placing queens from row 0.
        queens(0,
               visitedRightDiagonal,
               visitedLeftDiagonal,
               visitedColumn,
               board,
               n);

        return res;
    }

    private void queens(int row,
                        boolean[] visitedRightDiagonal,
                        boolean[] visitedLeftDiagonal,
                        boolean[] visitedColumn,
                        char[][] board,
                        int n) {

        // ---------------- Base Case ----------------

        // Successfully placed queens in every row.
        if (row == n) {

            List<String> list = new ArrayList<>();

            // Convert each row of the board into a String.
            for (int i = 0; i < n; i++) {
                list.add(new String(board[i]));
            }

            res.add(list);
            return;
        }

        // -------------------------------------------------
        // Try placing a queen in every column of this row.
        // -------------------------------------------------

        for (int col = 0; col < n; col++) {

            // '\' diagonal
            //
            // Example:
            // (0,0), (1,1), (2,2)
            // row-col = 0
            //
            // Shift by (n-1) to avoid negative indices.
            int rightDiagonal = row - col + (n - 1);

            // '/' diagonal
            //
            // Example:
            // (0,3), (1,2), (2,1)
            // row+col = constant
            int leftDiagonal = row + col;

            // Can we place the queen here?
            if (!visitedColumn[col]
                    && !visitedRightDiagonal[rightDiagonal]
                    && !visitedLeftDiagonal[leftDiagonal]) {

                // ---------------- Choose ----------------

                visitedColumn[col] = true;
                visitedRightDiagonal[rightDiagonal] = true;
                visitedLeftDiagonal[leftDiagonal] = true;

                board[row][col] = 'Q';

                // ---------------- Explore ----------------

                // Place queen in the next row.
                queens(row + 1,
                       visitedRightDiagonal,
                       visitedLeftDiagonal,
                       visitedColumn,
                       board,
                       n);

                // ---------------- Backtrack ----------------

                // Remove the queen so that
                // the next column can be tried.
                board[row][col] = '.';

                visitedColumn[col] = false;
                visitedRightDiagonal[rightDiagonal] = false;
                visitedLeftDiagonal[leftDiagonal] = false;
            }
        }
    }
}