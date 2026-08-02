class Solution {

    public boolean exist(char[][] board, String word) {

        int rows = board.length;
        int cols = board[0].length;

        // Try starting the search from every cell.
        // If any starting point finds the word, return true.
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                if (dfs(board, word, row, col, 0)) {
                    return true;
                }
            }
        }

        // Word not found anywhere.
        return false;
    }

    private boolean dfs(char[][] board, String word,
                        int row, int col, int index) {

        // ---------------- Base Cases ----------------

        // If all characters have been matched,
        // we successfully found the word.
        if (index == word.length()) {
            return true;
        }

        // Current position is outside the board.
        if (row < 0 || col < 0 ||
            row >= board.length || col >= board[0].length) {
            return false;
        }

        // Character mismatch OR
        // cell already visited ('#' means visited).
        if (board[row][col] != word.charAt(index)) {
            return false;
        }

        // ---------------- Choose ----------------

        // Save the original character so that
        // we can restore it during backtracking.
        char temp = board[row][col];

        // Mark current cell as visited.
        board[row][col] = '#';

        // ---------------- Explore ----------------

        // Search in all four directions.
        boolean found =
                dfs(board, word, row - 1, col, index + 1) ||
                dfs(board, word, row + 1, col, index + 1) ||
                dfs(board, word, row, col - 1, index + 1) ||
                dfs(board, word, row, col + 1, index + 1);

        // ---------------- Backtrack ----------------

        // Restore the original character so that
        // other DFS paths can reuse this cell.
        board[row][col] = temp;

        return found;
    }
}