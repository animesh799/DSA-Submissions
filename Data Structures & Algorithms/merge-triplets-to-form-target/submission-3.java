class Solution {

    public boolean mergeTriplets(int[][] triplets, int[] target) {

        int[] curr = new int[3];

        for (int[] triplet : triplets) {

            // --------------------------------------------------
            // If ANY value is greater than target,
            // this triplet can never be part of the answer.
            //
            // Because merge operation uses MAX.
            //
            // Once a value exceeds target, we can never
            // bring it back down.
            // --------------------------------------------------
            if (triplet[0] > target[0] ||
                triplet[1] > target[1] ||
                triplet[2] > target[2]) {

                continue;
            }


            // --------------------------------------------------
            // This triplet is safe to use.
            //
            // Merge using coordinate-wise maximum.
            // --------------------------------------------------
            curr[0] = Math.max(curr[0], triplet[0]);
            curr[1] = Math.max(curr[1], triplet[1]);
            curr[2] = Math.max(curr[2], triplet[2]);
        }


        // --------------------------------------------------
        // If we reached target in all three coordinates,
        // then the target can be formed.
        // --------------------------------------------------
        return curr[0] == target[0] &&
               curr[1] == target[1] &&
               curr[2] == target[2];
    }
}