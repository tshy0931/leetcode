class MyCircularQueue {

    private int[] queue;
    private int head;
    private int tail;
    private int size;
    private int cap;
    
    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        this.queue = new int[k+1];
        this.cap = k;
    }
    
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(this.size == this.cap) return false;
        
        this.queue[tail] = value;
        this.tail = (this.tail+1) % queue.length;
        this.size++;
        return true;
    }
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(this.size == 0) return false;
        
        this.head = (this.head+1) % queue.length;
        this.size--;
        return true;
    }
    
    /** Get the front item from the queue. */
    public int Front() {
        return this.isEmpty() ? -1 : this.queue[this.head];
    }
    
    /** Get the last item from the queue. */
    public int Rear() {
        int idx = (this.tail - 1 + this.queue.length) % this.queue.length;
        return this.isEmpty() ? -1 : this.queue[idx];
    }
    
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return this.size == 0;
    }
    
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return this.size == this.cap;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
