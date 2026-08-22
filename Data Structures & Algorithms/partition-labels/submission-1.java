class Solution {

    public List<Integer> partitionLabels(String s) {

        // Store the last occurrence of every character
        Map<Character, Integer> last = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            last.put(s.charAt(i), i);
        }


        List<Integer> result = new ArrayList<>();

        int start = 0;
        int end = 0;


        while (start < s.length()) {

            // Current partition must include the last
            // occurrence of its first character.
            end = last.get(s.charAt(start));


            // Expand partition if any character inside it
            // occurs later.
            for (int i = start; i <= end; i++) {

                end = Math.max(
                    end,
                    last.get(s.charAt(i))
                );
            }


            // Store partition length
            result.add(end - start + 1);

            // Start next partition
            start = end + 1;
        }

        return result;
    }
}