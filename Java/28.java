/*
KMP algorithm.
https://www.geeksforgeeks.org/kmp-algorithm-for-pattern-searching/
*/
class Solution {
    public int strStr(String haystack, String needle) {
        if(needle == null || needle.equals("")) return 0;
        int[] lps = preProc(needle);
        
        int hp = 0, np = 0;
        
        while(hp < haystack.length()){
            if(np == needle.length()) return hp - np; // has fully matched, return index of first char
            
            if(haystack.charAt(hp) == needle.charAt(np)){
                hp++;
                np++;
            } else { // found mismatch, determine how many chars in heystack we can skip checking.
                if(np == 0) {
                    hp++;
                } else {
                    np = lps[np-1];
                }
            }
        }
        System.out.println(np);
        return np == needle.length() ? hp - np : -1;
    }
    
    private int[] preProc(String pattern) {
        int[] lps = new int[pattern.length()];
        int len = 0;
        for(int i=1; i<lps.length;){
            if(pattern.charAt(len) == pattern.charAt(i)){
                // matching char, increment len and store it at current index i
                // which means at i the length of matching prefix/suffix is len
                len++;
                lps[i] = len;
                i++;
            } else { 
                if(len > 0) {
                    // prefix/suffix with length = len do not match
                    // BUT shorter ones are still possible to match, for example string AAACAAAA:
                    // AAACAAAA
                    //        | checking index i = 7
                    // AAAC and AAAA (len = 4) do not match, BUT
                    // AAA  AAA still match (len = 3)
                    // 012  567
                    // then we set len to the length at len-1 and check if they match
                    len = lps[len-1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        
        return lps;
    }
}
