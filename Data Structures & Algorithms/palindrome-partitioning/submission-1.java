class Solution {

    // Stores all valid palindrome partitions.
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {

        // Start from index 0 with:
        // 1. Empty current substring (sb)
        // 2. Empty partition (set)
        generate(0, new StringBuilder(), new ArrayList<>(), s);

        return res;
    }

    private void generate(int idx, StringBuilder sb,
                          List<String> set, String s) {

        // ---------------- Base Case ----------------

        // Entire string has been processed.
        if (idx == s.length()) {

            // The remaining substring must also be a palindrome.
            // Ignore empty StringBuilder because it means
            // the last substring was already split.
            if (sb.length() != 0 && isPalindrome(sb.toString())) {

                // Add the final substring.
                set.add(sb.toString());

                // Store one complete partition.
                res.add(new ArrayList<>(set));

                // Backtrack.
                set.remove(set.size() - 1);
            }

            return;
        }

        // Add current character to the substring
        // that we're currently building.
        char ch = s.charAt(idx);
        sb.append(ch);

        // ------------------------------------------------
        // Decision 1 : Split here
        // ------------------------------------------------
        //
        // If the current substring is a palindrome,
        // we can end this partition here.
        //
        // Example:
        // s = "aab"
        //
        // Current substring = "aa"
        //
        // Partition becomes:
        // ["aa"]
        //
        // Start building the next substring
        // using a fresh StringBuilder.
        //
        if (isPalindrome(sb.toString())) {

            set.add(sb.toString());

            generate(idx + 1,
                     new StringBuilder(),
                     set,
                     s);

            // Backtrack
            set.remove(set.size() - 1);
        }

        // ------------------------------------------------
        // Decision 2 : Don't split
        // ------------------------------------------------
        //
        // Continue extending the current substring.
        //
        // Example:
        //
        // "a"
        //
        // becomes
        //
        // "aa"
        //
        // instead of splitting after the first 'a'.
        //
        generate(idx + 1, sb, set, s);

        // Remove the last character before returning
        // so that the caller gets the original StringBuilder.
        sb.deleteCharAt(sb.length() - 1);
    }

    // Standard palindrome check.
    private boolean isPalindrome(String s) {

        int i = 0;
        int j = s.length() - 1;

        while (i < j) {

            if (s.charAt(i) != s.charAt(j))
                return false;

            i++;
            j--;
        }

        return true;
    }
}