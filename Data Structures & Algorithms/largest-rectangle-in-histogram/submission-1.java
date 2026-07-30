class Solution {

    public int largestRectangleArea(int[] heights) {

        int n = heights.length;

        // Stack stores (startIndex, height)
        // It is maintained in increasing order of heights.
        //
        // Why startIndex?
        // Suppose a taller bar is popped because a smaller bar arrives.
        // The current smaller bar can extend backwards till the popped bar's start.
        //
        // Example:
        // Heights = [2,5,6,3]
        //
        // When 3 comes, both 6 and 5 are popped.
        // 3 can now start from index of 5.
        Deque<Pair> stack = new ArrayDeque<>();

        int maxArea = 0;

        for (int i = 0; i < n; i++) {

            // Assume current bar starts from its own position.
            int start = i;

            // Current height is smaller.
            // Every taller bar in stack ends here.
            while (!stack.isEmpty() && stack.peek().height > heights[i]) {

                Pair pair = stack.pop();

                /*
                 * Rectangle:
                 *
                 * pair.index .......... i-1
                 *
                 * i is the first smaller element,
                 * so rectangle cannot include i.
                 *
                 * width = i - pair.index
                 */
                int area = pair.height * (i - pair.index);

                maxArea = Math.max(maxArea, area);

                // Current smaller height can extend left
                // till where popped bar had started.
                start = pair.index;
            }

            // Push current height with the leftmost
            // index where it can start.
            stack.push(new Pair(start, heights[i]));
        }

        /*
         * Stack still contains increasing heights.
         *
         * No smaller element exists on the right,
         * therefore every remaining bar extends
         * till the last index.
         *
         * width = n - startIndex
         */
        while (!stack.isEmpty()) {

            Pair pair = stack.pop();

            int area = pair.height * (n - pair.index);

            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    class Pair {

        int index;
        int height;

        Pair(int index, int height) {
            this.index = index;
            this.height = height;
        }
    }
}