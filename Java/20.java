/*
Use a stack to push every opening parenthese.
When encoutered a closing parenthese, the top character on the stack must exist and be the correct type of parenthese.
*/
class Solution {
    public boolean isValid(String s) {
        if(s == null || s.equals("")) return true;
        
        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()){
            switch(c) {
                case '{':
                    stack.push(c);
                    break;
                case '}':
                    if(stack.isEmpty() || stack.peek() != '{') return false;
                    stack.pop();
                    break;
                case '[':
                    stack.push(c);
                    break;
                case ']':
                    if(stack.isEmpty() || stack.peek() != '[') return false;
                    stack.pop();
                    break;
                case '(':
                    stack.push(c);
                    break;
                case ')':
                    if(stack.isEmpty() || stack.peek() != '(') return false;
                    stack.pop();
                    break;
                default:
                    return false;
            }
        }
        return stack.isEmpty();
    }
}
