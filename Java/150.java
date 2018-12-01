/*
put numbers into the stack, and once we encounter an operator, 
pop 2 numbers and calculate, push the result back to stack.
*/
class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0) return 0;
        
        int[] stack = new int[tokens.length];
        int top = 0;
        
        for(String token : tokens){
            switch(token){
                case "+":
                    int sum = stack[top-1] + stack[top-2];
                    top -= 2;
                    stack[top++] = sum;
                    break;
                case "-":
                    int sub = stack[top-2] - stack[top-1];
                    top -= 2;
                    stack[top++] = sub;
                    break;
                case "*":
                    int mul = stack[top-1] * stack[top-2];
                    top -= 2;
                    stack[top++] = mul;
                    break;
                case "/":
                    int div = stack[top-2] / stack[top-1];
                    top -= 2;
                    stack[top++] = div;
                    break;
                default:
                    stack[top++] = Integer.valueOf(token);
            }
        }
        return stack[0];
    }
}
