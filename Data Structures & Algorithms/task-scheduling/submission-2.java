class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();

        int len = tasks.length;

        for (int i = 0; i < len; i++) {
            char ch = tasks[i];
            if (map.get(ch) == null) {
                map.put(ch, 0);
            }
            int freq = map.get(ch);
            freq = freq + 1;
            map.put(ch, freq);
        }

        System.out.println(map);

        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a, b) -> map.get(b.ch) - map.get(a.ch));

        for (char ch : map.keySet()) {
            maxHeap.offer(new Pair(ch, 0));
        }

        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a, b) -> a.coolTime - b.coolTime);

        int cycles = 0;
        while (!maxHeap.isEmpty() || !minHeap.isEmpty()) {
     //       System.out.println("maxHeap:" + maxHeap + " minHeap:" + minHeap);
            cycles++;

                        Pair peek = minHeap.peek();
            while (!minHeap.isEmpty() && cycles >= peek.coolTime) {
                Pair poll = minHeap.poll();
                if (map.get(poll.ch) > 0) {
                    maxHeap.offer(poll);
                }
                peek = minHeap.peek();
            }


            
            if (!maxHeap.isEmpty()) {
                Pair task = maxHeap.poll();
                int freq = map.get(task.ch);
                map.put(task.ch, freq - 1);

                task.coolTime = cycles + n + 1;
                if (freq - 1 > 0)
                    minHeap.offer(task);
            }


        }

        return cycles;
    }

    class Pair {
        char ch;
        int coolTime;
        public Pair(char ch, int coolTime) {
            this.ch = ch;
            this.coolTime = coolTime;
        }
    }
}
