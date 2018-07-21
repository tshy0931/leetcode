/**
iterate the list, append to result if the element is integer, otherwise recursively handle the nested list. return the flattened list to caller.

 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    
    private int cursor = -1;
    private int length = -1;
    private List<Integer> flatten = null;
    
    public NestedIterator(List<NestedInteger> nestedList) {
        flatten = flatten(nestedList);
        length = flatten.size();
    }

    @Override
    public Integer next() {
        return flatten.get(++cursor);
    }

    @Override
    public boolean hasNext() {
        return cursor < length-1;
    }
    
    private List<Integer> flatten(List<NestedInteger> nested) {
        List<Integer> flatList = new ArrayList<>();
        if(nested == null) return flatList;
        
        for(int i=0; i<nested.size(); i++){
            NestedInteger n = nested.get(i);
            if(n.isInteger()){
                flatList.add(n.getInteger());
            }else{
                flatList.addAll(flatten(n.getList()));
            }
        }
        return flatList;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
