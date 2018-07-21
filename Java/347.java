/*
Traverse the array to collect frequency or numbers. time complexity is O(n).
Put the entries into an array by putting each number into the index that has the same value as its frequency.
Then traverse starting from the end of the array to return first k non-null numbers in the array.
*/
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        
        Map<Integer, Integer> freqs = new HashMap<>();
        List<Integer>[] buckets = new List[nums.length + 1];
        List<Integer> res = new ArrayList<>(k);

        for(int n : nums) {
            freqs.put(n, freqs.getOrDefault(n, 0) + 1);
        }
        
        for(Map.Entry<Integer, Integer> kv : freqs.entrySet()) {
            List<Integer> bucket = buckets[kv.getValue()];
            if(bucket == null){
                buckets[kv.getValue()] = new ArrayList<>();
            }
            buckets[kv.getValue()].add(kv.getKey());
        }
        
        for (int i=buckets.length-1, n=k; i>=0 && n>0; --i) {
            if(buckets[i] != null) {
                res.addAll(buckets[i]);
                n -= buckets[i].size();
            }
        }
        return res;
    }
}
