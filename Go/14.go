/**
Let i = 0, check if the byte at index i is the same across all the strings, 
put it into the result slice, increment i and repeat until
a) i is equal or greater than length of any string
b) return "" if any string is ""

Pay attention to edge cases like empty array input, length of each string etc.
**/
func longestCommonPrefix(strs []string) string {
    
    leng := len(strs)
    
    switch(leng) {
    case 0:
        return ""
    case 1:
        return strs[0]
    default:
        res, p := make([]byte, len(strs[0])), 0
        for i:=0; ; i++ {
            if strs[0] == "" {
                return ""
            }
            if i >= len(strs[0]) {
                return string(res[:p])
            }
            ch := strs[0][i]
            for _, str := range strs {
                if i >= len(str) || str[i] != ch {
                    return string(res[:p])
                }
            }
            res[p] = ch
            p += 1
        }
    }
}
