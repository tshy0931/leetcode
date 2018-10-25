class Solution {
    public String reverseString(String s) {
        if(s == null) return null;
        StringBuilder sb = new StringBuilder();
        for(int j=s.length()-1; j>=0; --j) {
            sb.append(s.charAt(j));
        }
        return sb.toString();
    }
}
