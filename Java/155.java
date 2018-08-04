/*
Pushing a value greater than current min value actually doesn't affect the min stack. Therefore only need to consider when min value is pushed/popped.

Use another stack to track minimum value have been pushed into the stack. The same min value need to be stored multiple times.
When popping a value, compare value with the min stack, if it's the same value then pop the value from min stack.
*/
class MinStack {

    private Deque<Integer> minStack = null;
    private Deque<Integer> stack = null;
    
    /** initialize your data structure here. */
    public MinStack() {
        this.minStack = new ArrayDeque<>();
        this.stack = new ArrayDeque<>();
    }
    
    public void push(int x) {
        this.stack.addFirst(x);
        if(this.minStack.isEmpty() || x <= this.minStack.peekFirst()) this.minStack.addFirst(x);
    }
    
    public void pop() {
        int val = this.stack.removeFirst();
        if(val == this.minStack.peekFirst()) this.minStack.removeFirst();
    }
    
    public int top() {
        return this.stack.peekFirst();
    }
    
    public int getMin() {
        return this.minStack.peekFirst();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
