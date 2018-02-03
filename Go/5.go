/**
Longest Palindromic Substring

Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

----------------

Brute Force :(
For each char in the string, check both situation:
1. odd length palindrome
    centered at current char and expand to both left and right, until they are different
2. even length palindrome
    use s[i] and s[i+1] as center and expand to both left and right, until they are different
Keep record of the starting and ending indices of longest palindrome found and return the substring at the end.
**/
func longestPalindrome(s string) string {
    
    start, end, max, od, ev := 0, 0, 0, 0, 0
    
    for i, _ := range s {
        od = odd(s, i)
        ev = even(s, i)
        if odL := od*2 + 1; odL > max {
            max = odL
            start = i - od
            end = i + od
        }
        if evL:=(ev+1)*2; evL > max {
            max = evL
            start = i - ev
            end = i + 1 + ev
        }
    }
    
    return s[start:end+1]
}

func odd(s string, at int) int {
    var i int
    for i = 0; at-i>=0 && at+i<len(s) && s[at-i] == s[at+i]; i++ {
        
    }
    return i-1;
}

func even(s string, at int) int {
    var i int
    for i = 0; at-i>=0 && at+1+i<len(s) && s[at-i] == s[at+1+i]; i++ {
        
    }
    return i-1;
}
