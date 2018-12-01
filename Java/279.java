/*
1. Dynamic Programming
for any given integer n, the least number can only come from some number plus a perfect square number.
e.g. n = 13, candidates are 13 - 1, 13 - 4, 13 - 9, 
then we choose the minimum number from them, which are already computed in earlier iteration.

2. BFS
starting from target number n=13, enqueue all numbers that are 'n minus a perfect square number', 13-1, 13-4, 13-9, and increment count.
dequeue numbers and do the same, until we found 0 then return the count.
*BUT this approach involves auto-boxing, which may impact performance.
*/
class Solution {
    public int numSquares(int n) {
        return dp(n);
        // return bfs(n);
    }
    
    private int bfs(int n) {
        if(n <=0) return 0;
        int count = 0;
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(n);
        while(!q.isEmpty()){
            for(int size = q.size(); size > 0; --size){
                int num = q.poll();
                for(int i=1; i*i<=num; ++i){
                    if(num == i*i) return ++count;
                    q.offer(num - i*i);
                }
            }
            ++count;
        }
        return -1;
    }
    
    private int dp(int n) {
        if(n <=0) return 0;
        
        int[] dp = new int[n+1];
        for(int i=1; i<=n; ++i){
            int min = Integer.MAX_VALUE;
            for(int k = 1; k*k <= i; ++k){
                min = Math.min(min, dp[i - k*k] + 1);
            }
            dp[i] = min;
        }
        return dp[n];
    }
}
