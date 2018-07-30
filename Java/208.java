/*
a Trie object cotains:
the character stored in the object.
a map of Trie nodes after it.
a boolean flag to tell whether a word ends here.
Root node contains empty character.

Recursive:
starting with the complete input string, check whether first char in the string exists in current Trie node.
If exists check substring(1) in the corresponding Trie node in map. Otherwise create a Trie in map and check substring(1) in the new Trie node, Recursively.
*/
class Trie {

    char letter = '\0';
    Map<Character, Trie> next = null;
    boolean isLast = false;
    
    /** Initialize your data structure here. */
    public Trie() {
        this.next = new HashMap<>();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        if(word.length() == 0) return;
        if(this.next.containsKey(word.charAt(0))){
            if(word.length() == 1){
                this.next.get(word.charAt(0)).isLast = true;
                return;
            }
            else {
                this.next.get(word.charAt(0)).insert(word.substring(1));
            }  
        } else {
            Trie t = new Trie();
            t.letter = word.charAt(0);
            t.isLast = word.length() == 1;
            this.next.put(word.charAt(0), t);
            if(!t.isLast){
                t.insert(word.substring(1));
            }
        }    
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if(word.length() == 0 || !this.next.containsKey(word.charAt(0))) return false;
        if(word.length() == 1) return this.next.get(word.charAt(0)).isLast;
        return this.next.get(word.charAt(0)).search(word.substring(1));
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if(prefix.length() == 0 || !this.next.containsKey(prefix.charAt(0))) return false;
        if(prefix.length() == 1) return true;
        return this.next.get(prefix.charAt(0)).startsWith(prefix.substring(1));
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
