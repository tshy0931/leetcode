/*
Use an arraylist to store values to get random value by index with even distribution.
Use a hashmap to store values for constant time insert/remove.
When deleting value in list, need to swap it to last position because ArrayList.remove() is O(1) on last element.
Don't forget to update index of value in the hashmap after swap!
*/
class RandomizedSet {

    private List<Integer> list = null;
    private Map<Integer, Integer> map = null;
    
    /** Initialize your data structure here. */
    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)) return false;
        map.put(val, list.size());
        list.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        int index = map.get(val);
        int size = list.size();
        int tmp = list.get(size-1);
        list.set(size-1, list.get(index));
        list.set(index, tmp);
        list.remove(size-1);
        map.put(tmp, index);
        map.remove(val);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        if(list.size() <= 0) return -1;
        return list.get(new Random().nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
