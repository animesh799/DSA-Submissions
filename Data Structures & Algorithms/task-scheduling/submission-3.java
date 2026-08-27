class Solution {

    public int leastInterval(char[] tasks, int n) {

        // Stores frequency of every task.
        // Example: A A A B B C
        // map = {A=3, B=2, C=1}
        Map<Character, Integer> map = new HashMap<>();

        for (char ch : tasks) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        /*
         * maxHeap contains tasks which are currently AVAILABLE to execute.
         *
         * We always want to execute the task having the highest remaining
         * frequency because it is the most difficult task to schedule.
         *
         * Example:
         * A = 3
         * B = 2
         * C = 1
         *
         * maxHeap -> A, B, C
         */
        PriorityQueue<Pair> maxHeap =
            new PriorityQueue<>(
                (a, b) -> map.get(b.ch) - map.get(a.ch)
            );

        // Initially, every task is available.
        for (char ch : map.keySet()) {
            maxHeap.offer(new Pair(ch, 0));
        }

        /*
         * minHeap contains tasks which are currently in COOLDOWN.
         *
         * coolTime tells us the first cycle at which the task
         * becomes available again.
         *
         * We want the task with the smallest coolTime first.
         */
        PriorityQueue<Pair> minHeap =
            new PriorityQueue<>(
                (a, b) -> a.coolTime - b.coolTime
            );

        // Represents the current time/cycle.
        int cycles = 0;

        /*
         * Continue until:
         *
         * 1. No available task exists
         * AND
         * 2. No task is waiting in cooldown.
         */
        while (!maxHeap.isEmpty() || !minHeap.isEmpty()) {

            // Move to the next time slot.
            cycles++;

            /*
             * STEP 1:
             * Check whether any task has finished its cooldown.
             *
             * Example:
             * A was executed at cycle 1
             * n = 2
             *
             * A can execute again at cycle 4.
             *
             * coolTime = 1 + 2 + 1 = 4
             */
            while (!minHeap.isEmpty()
                    && cycles >= minHeap.peek().coolTime) {

                // Remove the task whose cooldown has expired.
                Pair task = minHeap.poll();

                /*
                 * The task may have no occurrences left.
                 *
                 * Only put it back into maxHeap if there are
                 * still copies of this task remaining.
                 */
                if (map.get(task.ch) > 0) {
                    maxHeap.offer(task);
                }
            }

            /*
             * STEP 2:
             * Execute one available task.
             *
             * If maxHeap is empty, we cannot execute anything,
             * so this cycle becomes an IDLE cycle.
             */
            if (!maxHeap.isEmpty()) {

                // Pick the task with highest remaining frequency.
                Pair task = maxHeap.poll();

                // One occurrence of this task is consumed.
                int freq = map.get(task.ch);
                freq--;

                map.put(task.ch, freq);

                /*
                 * If more occurrences of this task remain,
                 * it must go into cooldown.
                 *
                 * IMPORTANT:
                 * We do NOT put it into cooldown if freq == 0,
                 * because there is nothing left to execute.
                 */
                if (freq > 0) {

                    /*
                     * Current task was executed at 'cycles'.
                     *
                     * We need n IDLE slots between two executions.
                     *
                     * Example:
                     *
                     * n = 2
                     *
                     * cycle 1 -> A
                     * cycle 2 -> idle
                     * cycle 3 -> idle
                     * cycle 4 -> A
                     *
                     * Therefore:
                     *
                     * next available cycle
                     * = cycles + n + 1
                     */
                    task.coolTime = cycles + n + 1;

                    // Put the task into cooldown.
                    minHeap.offer(task);
                }
            }
        }

        // Total time required to execute all tasks.
        return cycles;
    }


    /*
     * Represents a task.
     *
     * ch        -> task character (A, B, C...)
     * coolTime  -> cycle at which this task becomes available again
     */
    class Pair {

        char ch;
        int coolTime;

        public Pair(char ch, int coolTime) {
            this.ch = ch;
            this.coolTime = coolTime;
        }
    }
}