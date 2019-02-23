/**
Use one traversal to count each character,
then traverse again and return the index of first character with count as 1,
return -1 if not found.
*/
class Solution {
    public int firstUniqChar(String s) {
        if (s == null || "".equals(s)) return -1;
        
        int[] counts = new int[26];
        
        for (int i = 0; i < s.length(); ++i) {
            counts[s.charAt(i) - 'a'] += 1;
        }
        
        for (int i = 0; i < s.length(); ++i) {
            if (counts[s.charAt(i) - 'a'] == 1) return i;
        }
        
        return -1;
    }
}
