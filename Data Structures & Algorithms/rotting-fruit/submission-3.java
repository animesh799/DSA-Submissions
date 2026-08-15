class Solution {

    public int orangesRotting(int[][] grid) {

        int row = grid.length;
        int col = grid[0].length;

        // No need for a separate visited array.
        // Once a fresh orange becomes rotten (1 -> 2),
        // it cannot be processed again.
        Queue<Pair> queue = new LinkedList<>();


        /*
         * Multi-Source BFS:
         *
         * Put ALL initially rotten oranges into the queue.
         *
         * They all start rotting simultaneously at time = 0.
         */
        for (int i = 0; i < row; i++) {

            for (int j = 0; j < col; j++) {

                if (grid[i][j] == 2) {
                    queue.offer(new Pair(i, j));
                }
            }
        }


        // Four possible directions:
        // DOWN, UP, RIGHT, LEFT
        int[] x = {1, -1, 0, 0};
        int[] y = {0, 0, 1, -1};


        // Represents the number of BFS levels processed.
        int time = 0;


        /*
         * Each BFS level represents ONE MINUTE.
         */
        while (!queue.isEmpty()) {

            /*
             * Number of rotten oranges at the CURRENT minute.
             *
             * We process exactly these oranges.
             */
            int size = queue.size();

            // Moving to the next minute.
            time++;


            /*
             * Process all oranges that were rotten
             * at the beginning of this minute.
             */
            for (int i = 1; i <= size; i++) {

                Pair poll = queue.poll();


                // Check all four neighbours.
                for (int k = 0; k < 4; k++) {

                    int newRow = poll.x + x[k];
                    int newCol = poll.y + y[k];


                    // Check boundaries.
                    if (newRow >= 0 &&
                        newRow < row &&
                        newCol >= 0 &&
                        newCol < col) {


                        /*
                         * If neighbour is a fresh orange,
                         * it becomes rotten.
                         */
                        if (grid[newRow][newCol] == 1) {

                            // Mark it rotten immediately.
                            //
                            // This also acts as "visited".
                            grid[newRow][newCol] = 2;

                            // It will start spreading during
                            // the next BFS level/minute.
                            queue.offer(new Pair(newRow, newCol));
                        }
                    }
                }
            }
        }


        /*
         * After BFS, check whether any fresh orange remains.
         *
         * If yes, it was unreachable because of walls.
         */
        for (int i = 0; i < row; i++) {

            for (int j = 0; j < col; j++) {

                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }


        /*
         * If there were no rotten oranges initially,
         * time remains 0.
         *
         * Therefore:
         * no fresh oranges → 0
         *
         * Otherwise, BFS takes time-1 minutes because
         * the first increment represents the initial level.
         */
        return time == 0 ? 0 : time - 1;
    }


    // Stores row and column of an orange.
    class Pair {

        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}