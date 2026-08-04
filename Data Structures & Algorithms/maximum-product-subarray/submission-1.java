class Solution {
    public int maxProduct(int[] nums) {
        int n=nums.length;


        int prefix=1,postfix=1;
        int max=Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            if(prefix==0) prefix=1;
            if(postfix==0) postfix=1;

            prefix=prefix*nums[i];
            postfix=postfix*nums[n-i-1];
            max=Math.max(prefix,max);
            max=Math.max(postfix,max);

        }

        return max;
    }
}




// class Solution {
//     public int maxProduct(int[] nums) {

//         // Maximum product subarray ending at current index
//         int maxEndingHere = nums[0];

//         // Minimum product subarray ending at current index
//         // Needed because a negative * negative can become the new maximum
//         int minEndingHere = nums[0];

//         // Stores the overall maximum product found so far
//         int ans = nums[0];

//         // Start from the second element
//         for (int i = 1; i < nums.length; i++) {

//             int curr = nums[i];

//             // Save previous values because we'll update them
//             // and both calculations depend on the old values.
//             int prevMax = maxEndingHere;
//             int prevMin = minEndingHere;

//             /*
//              * Three choices for the maximum product ending here:
//              *
//              * 1. Start a new subarray from current element.
//              * 2. Extend the previous maximum product.
//              * 3. Extend the previous minimum product
//              *    (because negative × negative = positive).
//              */
//             maxEndingHere = Math.max(
//                     curr,
//                     Math.max(prevMax * curr, prevMin * curr)
//             );

//             /*
//              * Similarly, compute the minimum product ending here.
//              * Keeping track of the minimum is important because it
//              * may become the maximum after multiplying by a negative.
//              */
//             minEndingHere = Math.min(
//                     curr,
//                     Math.min(prevMax * curr, prevMin * curr)
//             );

//             // Update the overall answer.
//             ans = Math.max(ans, maxEndingHere);
//         }

//         return ans;
//     }
// }