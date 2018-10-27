/*
Use two pointers to indicate start and end of a word, which we can tell from when we hit whitespace.
Staring from end of the input string, when we've found a word, put it into StringBuilder in correct order.
skip leading/trailing spaces, and only put one whitespace for multiple ones in a row.
If there's no leading space, the begining word need to be handled after the loop.
*/
public class Solution {
    public String reverseWords(String s) {
        if(s == null || s.length() == 0) return s;
        
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        int start = len-1, end = len-1, tmp = 0;
        while(start >=0 && s.charAt(start) == ' '){
            --end;
            --start;
        }
        if(start < 0) return "";
        
        while(start>=0){
            char ch = s.charAt(start);
            if(ch == ' '){
                if(start != end) { // we've found a word
                    tmp = start;
                    while(++start <= end){
                        sb.append(s.charAt(start));
                    }
                    sb.append(' ');
                    start = tmp;
                    end = tmp;
                } else { // skipping whitespaces
                    --start;
                    --end;
                    continue;
                }
            } else { // scanning a word
                --start;
            }
        }
        // still need to process the word at beginning of input string
        while(++start <= end){
            sb.append(s.charAt(start));
        }
        if(sb.charAt(sb.length()-1) == ' ') sb.setLength(sb.length()-1);
            
        return sb.toString();
    }
}
