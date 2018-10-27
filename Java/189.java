/**
1) reverse the whole array
1,2,3,4,5,6,7 -> 7,6,5,4,3,2,1
2) to rotate k=3 steps, reverse first k=3 numbers
7,6,5,4,3,2,1 -> 5,6,7,4,3,2,1
3) then reverse the rest numbers
5,6,7,4,3,2,1 -> 5,6,7,1,2,3,4
*/
class Solution {
    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length < 2) return;
        k %= nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }
    
    private void reverse(int[] arr, int from, int to) {
        while(from < to){
            int tmp = arr[from];
            arr[from] = arr[to];
            arr[to] = tmp;
            ++from;
            --to;
        }
    }
}
