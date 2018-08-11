/*
For each char in the string, count even and odd length palindromes centered at the char.
return total count after traversal.
*/
func countSubstrings(s string) int {
    count := 0
    leng := len(s)
    
    for i:=0; i < leng; i++ {
        count += countPalindromes(s, i, i, leng)
        count += countPalindromes(s, i, i+1, leng)
    }
    
    return count
}

func countPalindromes(str string, l int, r int, leng int) int {
    count := 0
    for l>=0 && r<leng {
        if str[l] != str[r] {
            return count
        }
        count++
        l--
        r++
    }
    return count
}
