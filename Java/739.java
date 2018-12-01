/*
Iterate from the end of the array backwards, and use a stack to store the index of the high temperatures in a monotonic way:
e.g. when a higher temperature 75 is found at index 2, the lower ones 71, 69, 72 at indices 3, 4, 5 will never be used.
so we'll have a stack looking like below:
top -> [ <73 at 0>, <74 at 1>, <75 at 2>, <76 at 6> ]
*/
class Solution {
    public int[] dailyTemperatures(int[] T) {
        if(T == null) return null;
        int leng = T.length;
        int[] tempStack = new int[leng]; // stack to store temperature
        int[] idxStack = new int[leng]; // stack to store index of corresponding temperature
        int[] res = new int[leng];
        tempStack[0] = T[leng-1];
        idxStack[0] = leng-1;
        int top = 1;
        res[leng-1] = 0; // the last element is always 0
        
        for(int i=leng-2; i>=0; --i){
            while(top > 0 && tempStack[top-1] <= T[i]){ // pop temperatures/indices that are smaller than current one
                --top;
            }
            if(top == 0){
                res[i] = 0; // no higher temperature found
            }else{
                res[i] = idxStack[top-1] - i; // calculate days until the higher temperature
            }
            tempStack[top] = T[i]; // push current temperature to stack
            idxStack[top] = i; // push index of current temperature to stack
            ++top;
        }
        return res;
    }
}
