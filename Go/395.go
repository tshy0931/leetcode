/*
Recursive:

for input string s, count each byte in the string. The bytes that do not fulfill the least k will split s into substrings s1, s2, etc.
For each substring, recursively call longestSubstring and return value if
a) input string is empty string, return 0
b) all bytes in input string fulfills the least k, return length of input string
*/
func longestSubstring(s string, k int) int {
    counts, leng := make(map[byte]int), len(s)
    if leng == 0 {
        return 0
    }
    
    for i:=0; i<leng; i++ {
        counts[s[i]] += 1
    }
    max := 0
        
    for i:=0; i<leng; {
        for i < leng && counts[s[i]] < k {
            i++
        }
        start := i
        for i < leng && counts[s[i]] >= k {
            i++
        }
        end := i
        if start==0 && end == leng {
            return leng
        }
        res := longestSubstring(s[start:end], k)
        if max < res {
            max = res
        }
    }
    
    return max
}
