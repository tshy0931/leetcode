/*
Brute Force

iterate thru haystack and compare each byte to first byte of needle, 
continue comparing next byte if they match, 
otherwise update potential starting index of needle to next byte in haystack to iterate.

Can be optimized with KMP.
*/
func strStr(haystack string, needle string) int {
    
    if needle == "" {
        return 0
    }
    if haystack == "" {
        return -1
    }
    
    lenh, lenn, pos := len(haystack), len(needle), 0
    
    for i:=0; i<lenh; i++ {
        for j:=0; j<lenn; j++ {
            if i+j >= lenh {
                return -1
            }
            if j == lenn-1 && haystack[i+j] == needle[j] {
                return pos
            }
            if haystack[i+j] != needle[j] {
                pos = i+1
                break
            }
        }
    }
    return -1
}
