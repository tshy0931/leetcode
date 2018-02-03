func longestValidParentheses(s string) int {
    
    /**
    Dynamic Programming solution:
    1. create an array, longest[], to store length of longest valid parenteses that ENDS AT i
    2. if s[i] == '(', longest[i] will always be 0 (a valid parentheses MUST ends with ')' ) 
    3. if s[i] == ')', longest[i] depends on what s[i-1] is:
        a. s[i-1] == '(', then we have a "()", valid parens of length 2. 
           Then it can possibly chain up with whatever parens we have at s[i-2] to form a longer one,
           so we store 2 + longest[i-2] at i
        b. s[i-1] == ')', then there could be a corresponding '(' at an earlier index.
           how to find where it is? We need to skip the longest valid parens ending at s[i-1], 
           which is i - 1 - longest[i-1]. But it could be one of below cases:
           - out of bound, like s[-1], then there's no matching '(', the length at i is 0.
           - s[i - 1 - longest[i-1]] == ')', then it's not a valid parens, the length at i is 0.
           - s[i - 1 - longest[i-1]] == '(', then it's a valid parens, the length is 
                2 + longest[i-1] + longest[i - 1 - longest[i-1] - 1] (current parens chained with previous one)
           
           
    Key points when deriving a DP formula:
    a. consider ONLY 1 STEP. How to compute result at i with results we already have from i-1, i-2, ...
       e.g. compute length of longest valid parenteses that ENDS AT i
    b. consider EVERY POSSIBLE CASE at a step.
       e.g. different situations for '(' and ')'
    c. beware of INDEX OUT OF BOUND case
    **/
    if s == "" {
        return 0
    }
    longest, start, max := make([]int, len(s)), 0, 0
    for i, ch := range s {
        switch ch {
        case '(':
            longest[i] = 0
        case ')':
            if i >= 1 {
                if s[i-1] == '(' {
                    longest[i] = 2
                    if i >= 2 {
                        longest[i] += longest[i-2]
                    }
                } else if s[i-1] == ')' {
                    start = i - 1 - longest[i-1]
                    if start >= 0 {
                        if s[start] == '(' {
                            longest[i] = 2 + longest[i-1]
                            if start >= 1 {
                                longest[i] += longest[start-1]
                            }
                        }
                    }else{
                        longest[i] = 0
                    }
                }
            }else{
                longest[i] = 0
            } 
        }
        if longest[i] > max {
            max = longest[i]
        }
    }
    return max
}
