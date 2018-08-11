/*
iterate thru the array, push to stack if the string is number.
If the string is operator, pop top 2 numbers from the stack and push the computed result to stack.
return top element on the stack.
*/
func evalRPN(tokens []string) int {
    leng, top := len(tokens), -1
    if leng == 0 {
        return 0
    }
    stack := make([]int, leng, leng)
    for _, s := range tokens {
        switch(s){
        case "+":
            n1, n2 := stack[top-1], stack[top]
            top--
            stack[top] = n1 + n2
        case "-":
            n1, n2 := stack[top-1], stack[top]
            top--
            stack[top] = n1 - n2
        case "*":
            n1, n2 := stack[top-1], stack[top]
            top--
            stack[top] = n1 * n2
        case "/":
            n1, n2 := stack[top-1], stack[top]
            top--
            stack[top] = n1 / n2
        default:
            if num, err := strconv.Atoi(s); err == nil {
                top++
                stack[top] = num
            }
        }
    }
    return stack[top]
}
