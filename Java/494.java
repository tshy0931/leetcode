/*
Inspired by quality discussions at 
https://leetcode.com/problems/target-sum/discuss/97335/Short-Java-DP-Solution-with-Explanation
https://leetcode.com/problems/target-sum/discuss/97369/Evolve-from-brute-force-to-dp

Recursive:
starting at index 0 with current sum as 0, possible sums are 0 + nums[0] and 0 - nums[0],
so we recusively process index 1 with the possible sums individually, and the count is the sum of both cases.
When we hit index == nums.length in resursive call, that means we've done summing and should compare the sum with target S,
return count as 1 if they equal, otherwise return 0.

Memoization:
With naive resursion solution, the same sum at a specific index can be processed multiple times.
We can memoize the counts of currSums we have processed, and just return the value the next time we hit the same currSum.

Dynamic Programming:
Possible currSums at index i depends on those at index i-1. A given currSum s at index i can only come from (s - nums[i]) or (s + nums[i]) at index i-1.
Therefore, the count of a given currSum s at index i is the sum of counts from both cases.
    
    sum[i][currSum] = sum[i-1][currSum - nums[i]] + sum[i-1][currSum + nums[i]]

The initial state is sum[0][nums[0]] = 1 and sum[0][-nums[0]] = 1.
Then result is sum[nums.length-1][S], the count of target sum S at last index of nums (where we sum all numbers).

Some Note:
to make sure negative currSum works, implementations based on arrays will need to shift the indices by total sum, to make all possible sums non-negative.
However the size of array depends on the largest possible sum, which is guaranteed within 1000, but may not be general situation.
Using map instead of array can save spaces for impossible currSums, but incurs costs of auto-boxing between int and Integer, and the map data structures.
*/
class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        if(nums == null || nums.length == 0) return 0;
        int sum = 0;
        for(int n : nums) sum += n; // the sum is largest possible sum we can achieve, so can be used to infer size of memo
        if(sum < S) return 0;
        
        Map<Integer, Integer>[] memo = new Map[nums.length]; // each map in the array stores possible sums at the specific index
        for(int i=0; i<nums.length; ++i){
            memo[i] = new HashMap<>();
        }
        
        // return memoization(nums, 0, 0, S, memo);
        return dp(nums, S);
    }
    
    private int memoization(int[] nums, int index, int currSum, int target, Map<Integer, Integer>[] memo) {
        if(index == nums.length) {
            // have finished adding sum, check whether it equals to target S
            return currSum == target ? 1 : 0;
        }
        if(memo[index].containsKey(currSum)) {
            // at this index, the same currSum has been processed before, so just returned the memoized value
            return memo[index].get(currSum);
        }
        // first time processing the currSum at index
        int nextPositive = memoization(nums, index+1, currSum + nums[index], target, memo); // recursively process next index as positive number
        int nextNegative = memoization(nums, index+1, currSum - nums[index], target, memo); // recursively process next index as negative number
        int count = nextPositive + nextNegative; // the count of target number is sum of both cases
        memo[index].put(currSum, count); // memoize the result
        
        return count;
    }
    
    private int dp(int[] nums, int target) {
        Map<Integer, Integer>[] dp = new Map[nums.length];
        
        dp[0] = new HashMap<>();
        if(nums[0] == 0){
            dp[0].put(0, 2); // edge case when nums[0] == 0, correct initial count should be 2 in this case
        } else {
            dp[0].put(nums[0], 1);  // initially, currSum of nums[0] has count 1 at index 0
            dp[0].put(-nums[0], 1); // initially, currSum of -nums[0] has count 1 at index 0
        }
        
        for(int i=1; i<nums.length; ++i){
            Map<Integer, Integer> currSums = new HashMap<>();
            dp[i] = currSums;
            Map<Integer, Integer> prevSums = dp[i-1];
            for(Map.Entry<Integer, Integer> entry : prevSums.entrySet()) {
                int sum = entry.getKey();
                int cnt = entry.getValue();
                int currSum1 = sum - nums[i];
                int currSum2 = sum + nums[i];
                                
                currSums.put(currSum1, currSums.getOrDefault(currSum1, 0) + cnt); // add 1 count to sum minus nums[i]
                currSums.put(currSum2, currSums.getOrDefault(currSum2, 0) + cnt); // add 1 count to sum plus nums[i]
            }
        }
        
        return dp[nums.length-1].getOrDefault(target, 0);
    }
}
