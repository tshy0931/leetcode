/**
Compare char of each string in the array at each valid index.
If all the strings have the same char at a given index, append it to the result,
otherwise return current result if a) index is out of bound for any string, b) mismatching char is found.
*/
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        StringBuilder sb = new StringBuilder();
        
        for(int i=0;;++i){
            char curr = '\0';
            for(String str : strs) {
                if(i >= str.length()) return sb.toString();
                char ch = str.charAt(i);
                if(curr == '\0') {
                    curr = ch;
                } else {
                    if(curr != ch) return sb.toString();
                }
            }
            sb.append(curr);
        }
    }
}
