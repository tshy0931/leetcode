/*
For strings to be anagrams, the count of characters in the strings must be exacly the same.
Therefore for each input string, save count of chars in a tree map so we can represent each anagram as a unique string. For example, 
"eat", "ate", "tea" all belong to anagram "a1e1t1"
"book", "koob", "kobo" all belong to anagram "b1k1o2"

Then we put each string into the list for corresponding anagram, and create new list for new anagram we found.
*/
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        if(strs == null || strs.length < 1) return null;
        
        List<List<String>> res = new ArrayList<>();
        Map<String, Integer> anagrams = new HashMap<>();
        int anagramCount = 0;
        
        for(String str : strs) {
            Map<Character, Integer> dict = new TreeMap<>();
            for(char c : str.toCharArray()) {
                dict.put(c, dict.getOrDefault(c, 0) + 1);
            }
            StringBuilder anagramBuilder = new StringBuilder();
            for(Map.Entry<Character, Integer> entry : dict.entrySet()) {
                anagramBuilder.append(entry.getKey());
                anagramBuilder.append(entry.getValue());
            }
            String anagram = anagramBuilder.toString();
            if(anagrams.containsKey(anagram)){
                int index = anagrams.get(anagram);
                res.get(index).add(str);
            }else{
                List<String> newGroup = new ArrayList<>();
                newGroup.add(str);
                res.add(newGroup);
                anagrams.put(anagram, anagramCount++);
            }
        }
        
        return res;
    }
}
