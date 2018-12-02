/*
use one stack to en queue elements as LIFO order,
to get FIFO order, we need to pop/push each element into another stack.
So enqueue elements into one stack, and dequeue from the other.
*/
class MyQueue {

    private int capacityIn = 8;
    private int capacityOut = 8;
    private int inTop = 0;
    private int outTop = 0;
    private int[] inStack;
    private int[] outStack;
    
    /** Initialize your data structure here. */
    public MyQueue() {
        this.inStack = new int[capacityIn];
        this.outStack = new int[capacityOut];
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        if(inTop == capacityIn){
            //resize
            this.capacityIn <<= 1;
            this.capacityOut <<= 1;
            int[] newInStack = new int[this.capacityIn];
            int[] newOutStack = new int[this.capacityOut];
            System.arraycopy(inStack, 0, newInStack, 0, inTop);
            System.arraycopy(outStack, 0, newOutStack, 0, outTop);
            this.inStack = newInStack;
            this.outStack = newOutStack;
        }
        this.inStack[inTop++] = x;
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(outTop == 0){
            // out stack is empty, pop each element in in stack and push into out stack
            while(inTop > 0){
                outStack[outTop++] = inStack[--inTop];
            }
        }
        
        return outStack[--outTop];
    }
    
    /** Get the front element. */
    public int peek() {
        if(outTop == 0){
            // out stack is empty, pop each element in in stack and push into out stack
            while(inTop > 0){
                outStack[outTop++] = inStack[--inTop];
            }
        }
        
        return outStack[outTop - 1];
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return inTop == 0 && outTop == 0;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
