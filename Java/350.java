class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) return new int[]{};
        Map<Integer, Integer> counts = new HashMap<>();
        List<Integer> resList = new ArrayList<>();
        
        for(int n : nums1) {
            counts.put(n, counts.getOrDefault(n, 0) + 1);
        }
        
        for(int n : nums2) {
            int count = counts.getOrDefault(n, 0);
            if(count > 0) {
                resList.add(n);
                counts.put(n, count-1);
            }
        }
        
        int[] res = new int[resList.size()];
        int i=0;
        for(int n : resList) {
            res[i++] = n;
        }
        return res;
    }
}
