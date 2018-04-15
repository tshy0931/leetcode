/**
if lengths of t and s are not equal, sure not anagram.
use a map to record number of each char in string s.
loop thru string t and if a char is not found or overused, it's not anagram.
*/
func isAnagram(s string, t string) bool {
    if len(s) != len(t) {
        return false
    }
    dict := make(map[rune]int)
    for _, ch := range s {
        dict[ch] += 1
    }
    for _, ch := range t {
        if dict[ch] < 1 {
            return false
        }
        dict[ch]-=1
    }
    return true
}
