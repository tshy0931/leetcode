/*
Brute Force:
Iterate thru the string and check anagram starting at each byte.
Will get TimeLimitExceeded error on large input.

Sliding Window:
Use a window with size not greater than string p to scan the string s.
Use 2 pointers, start and end, to indicate location of the window.
Start with start = end = 0, increment window size if the character s[end] fulfils the anagram rule:
    a) s[end] exists in string p;
    b) count of s[end] is not greater than its count in p;
increment end if both a) and b) hold, 
otherwise increment start and reset window size to zero by setting end to the same position as start.
Do NOT set start to where end is, because that will cause potential anagrams being skipped.

Once the window size equals length of string p, that means we have found an anagram, store start to result list.
To quickly check overlapping anagrams, check if the first char outside the window equals to the char at start.
If so it's also an anagram when the window slides 1 char, store start+1 to result list.
Otherwise, increment start, and reset window size to 0.
*/
func findAnagrams(s string, p string) []int {
    lenS, lenP := len(s), len(p)
    if lenS == 0 || lenP > lenS {
        return []int{}
    }
    res := make([]int, 0, lenS)
    bag := make(map[byte]int)
    window := make(map[byte]int)
    start, end := 0, 0
    
    for i:=0; i<lenP; i++ {
        bag[p[i]]++
    }
    
    for end < lenS {
        if end - start < lenP {
            c := s[end]
            window[c]++
            end++
            if window[c] > bag[c] {
            // found invalid char, increment start and set end to the same position as start
            // do NOT move to end index, because that can skip potential anagrams
                start++
                end = start
                window = make(map[byte]int)
            }
        } else { // have found an anagram s[start:end]
            res = append(res, start)
            for end < lenS && s[start] == s[end] { 
                // if the first char inside/outside the window are the same, 
                // it's another anagram when the window slides 1 step
                start++
                end++
                res = append(res, start)
            }
            // do NOT move to end index, because that can skip potential anagrams
            start++
            end = start
            window = make(map[byte]int)
        } 
    }
    
    if end - start == lenP {
        res = append(res, start)
    }
    
    return res
}
