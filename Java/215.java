/*
Traverse the array and store elems to a min heap of size k. Only add to heap if the elem is larger than the elem at heap top.
Return the heap top after traversal.
*/
class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || k < 1) return 0;
        if(nums.length == 1) return nums[0];
        
        Queue<Integer> heap = new PriorityQueue<>((a, b) -> a - b);
        
        for (int n : nums) {
            if(heap.size() < k) {
                heap.offer(n);
            } else {
                if(n > heap.peek()){
                    heap.poll();
                    heap.offer(n);
                }
            }
        }
        
        return heap.peek();
    }
}
