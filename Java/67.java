/*consider carry*/
class Solution {
    public String addBinary(String a, String b) {
        if(a == null || a.equals("")) return b;
        if(b == null || b.equals("")) return a;
        StringBuilder builder = new StringBuilder();
        boolean carry = false;
        
        for(int i=0; i<a.length() && i<b.length(); i++){
            char ca = a.charAt(a.length()-1-i);
            char cb = b.charAt(b.length()-1-i);
            if(ca == '1' && cb == '1'){
                builder.append(carry ? "1" : "0");
                carry = true;
            } else if(ca == '1' || cb == '1'){
                builder.append(carry ? "0" : "1");
            } else {
                builder.append(carry ? "1" : "0");
                carry = false;
            }
        }
        if(a.length() == b.length()){
            if(carry) builder.append("1");
            return builder.reverse().toString();
        }
        String remainder = a.length() > b.length() ? a.substring(0, a.length() - b.length()) : b.substring(0, b.length() - a.length());
        
        for(int i=0; i<remainder.length(); i++) {
            char c = remainder.charAt(remainder.length() - 1 - i);
            if(c == '0'){
                builder.append(carry ? "1" : "0");
                carry = false;
            }else{
                builder.append(carry ? "0" : "1");
            }
        }
        if(carry) builder.append("1");
        return builder.reverse().toString();
    }
}
