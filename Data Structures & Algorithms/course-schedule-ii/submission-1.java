class Solution {

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        // ---------------------------------------------------------
        // STEP 1: Build the adjacency list
        //
        // prerequisites[i] = [course, prerequisite]
        //
        // Example:
        // [1, 0] means:
        //
        //      0 ---> 1
        //
        // We must complete course 0 before course 1.
        //
        // Therefore:
        // adjList[0] = [1]
        // ---------------------------------------------------------
        Map<Integer, List<Integer>> adjList = new HashMap<>();

        for (int[] edge : prerequisites) {

            int course = edge[0];
            int prerequisite = edge[1];

            // Create list for prerequisite if it doesn't exist
            if (!adjList.containsKey(prerequisite)) {
                adjList.put(prerequisite, new ArrayList<>());
            }

            // prerequisite -> course
            adjList.get(prerequisite).add(course);
        }


        // ---------------------------------------------------------
        // STEP 2: Calculate indegree of every course
        //
        // indegree[i] = number of prerequisites that course i has
        //
        // Example:
        //
        // 0 ---> 1 ---> 2
        //
        // indegree[0] = 0
        // indegree[1] = 1
        // indegree[2] = 1
        // ---------------------------------------------------------
        int[] indegree = new int[numCourses];

        for (int[] edge : prerequisites) {

            int course = edge[0];

            // One more prerequisite for this course
            indegree[course]++;
        }


        // ---------------------------------------------------------
        // STEP 3: Put all courses having indegree = 0 into queue
        //
        // These courses have no prerequisites, so we can take
        // them immediately.
        // ---------------------------------------------------------
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {

            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }


        // This will store our valid course ordering.
        List<Integer> result = new ArrayList<>();


        // ---------------------------------------------------------
        // STEP 4: Kahn's Algorithm / Topological Sort
        // ---------------------------------------------------------
        while (!queue.isEmpty()) {

            // Take a course whose prerequisites are completed
            int current = queue.poll();

            // Add it to our answer
            result.add(current);


            // Find all courses that depend on current course
            List<Integer> neighbors = adjList.get(current);

            // No courses depend on current
            if (neighbors == null) {
                continue;
            }


            // -----------------------------------------------------
            // We have completed 'current'.
            //
            // Therefore, current is no longer a prerequisite
            // for its neighboring courses.
            // -----------------------------------------------------
            for (int neighbor : neighbors) {

                // Remove current course as a prerequisite
                indegree[neighbor]--;


                // All prerequisites of neighbor are now completed.
                //
                // Therefore, neighbor can now be taken.
                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }


        // ---------------------------------------------------------
        // STEP 5: Detect cycle
        //
        // If we were able to process all courses:
        //
        // result.size() == numCourses
        //
        // Otherwise, some courses were stuck with indegree > 0.
        // That means there is a cycle.
        //
        // Example:
        //
        // 0 ---> 1
        // ^      |
        // |______|
        //
        // Both 0 and 1 always have indegree 1.
        // Neither can enter the queue.
        // ---------------------------------------------------------
        if (result.size() != numCourses) {
            return new int[]{};
        }


        // ---------------------------------------------------------
        // STEP 6: Convert List<Integer> to int[]
        // ---------------------------------------------------------
        int[] answer = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}