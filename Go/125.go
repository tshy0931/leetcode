/**
Starting from both end, skip special chars, check alphanumeric chars are equal (ignoring case)
*/
func isPalindrome(s string) bool {
    sl := strings.ToLower(s)
    leng := len(sl)
    if(leng < 2) {
        return true
    }
    l,r := 0, leng-1
    for l < r {
        if !isAlphaNumeric(sl[l]) {
            l++
            continue
        }
        if !isAlphaNumeric(sl[r]) {
            r--
            continue
        }
        if sl[l] != sl[r] {
            return false
        }
        l++
        r--
    }
    return true
}

func isAlphaNumeric(ch byte) bool {
    return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9')
}
