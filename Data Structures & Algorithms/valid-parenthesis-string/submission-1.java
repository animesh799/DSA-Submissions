class Solution {

    public boolean checkValidString(String s) {

        // Minimum and maximum possible number of
        // unmatched '(' at the current position.
        int leftMin = 0;
        int leftMax = 0;


        for (char ch : s.toCharArray()) {

            if (ch == '(') {

                // Must be an opening bracket
                leftMin++;
                leftMax++;

            } 
            else if (ch == ')') {

                // Must close an opening bracket
                leftMin--;
                leftMax--;

            } 
            else {

                // '*' can be:
                //
                // ')'  -> leftMin - 1
                // '('  -> leftMax + 1
                // empty -> no change
                leftMin--;
                leftMax++;
            }


            // Even in the minimum case, we cannot
            // have fewer than 0 unmatched '('.
            leftMin = Math.max(0, leftMin);


            // If even the maximum possible number of
            // '(' becomes negative, the string is impossible.
            if (leftMax < 0) {
                return false;
            }
        }


        // If minimum possible unmatched '(' is 0,
        // there exists some interpretation that is valid.
        return leftMin == 0;
    }
}