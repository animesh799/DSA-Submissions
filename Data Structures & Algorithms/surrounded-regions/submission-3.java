class Solution {

    public void solve(char[][] board) {

        int n = board.length;
        int m = board[0].length;

        // 1. Start DFS from boundary O's
        for (int i = 0; i < n; i++) {

            if (board[i][0] == 'O') {
                dfs(i, 0, board, n, m);
            }

            if (board[i][m - 1] == 'O') {
                dfs(i, m - 1, board, n, m);
            }
        }

        for (int j = 0; j < m; j++) {

            if (board[0][j] == 'O') {
                dfs(0, j, board, n, m);
            }

            if (board[n - 1][j] == 'O') {
                dfs(n - 1, j, board, n, m);
            }
        }

        // 2. Convert surrounded O -> X
        //    Restore safe # -> O
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                else if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }


    private void dfs(int r, int c, char[][] board, int n, int m) {

        if (r < 0 || r >= n ||
            c < 0 || c >= m ||
            board[r][c] != 'O') {
            return;
        }

        // Mark as safe
        board[r][c] = '#';

        dfs(r + 1, c, board, n, m);
        dfs(r - 1, c, board, n, m);
        dfs(r, c + 1, board, n, m);
        dfs(r, c - 1, board, n, m);
    }
}