/*
Recursive:
Whenever we hit a number, it must be followed by a nested segment in quotes.
So we recursively process the nested segment into string, and repeatedly append to result string the given number of times.
Need to find out the range of the nested segment by counting '[ ]' pairs.

If we hit a letter, just append it to the result string.
*/
class Solution {
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<s.length(); ++i){
            char c = s.charAt(i);
            if(Character.isDigit(c)) { // found number, following is nested segment
                int count = c - '0';
                while(Character.isDigit(s.charAt(++i))){ // compute multi-digit count
                    count *= 10;
                    count += s.charAt(i) - '0';
                }
                int times = count;
                int start = i+1;
                // i is now at '[' of the nested segment, need to locate the closing ']'
                int quoteCount = 0;
                while(++i < s.length()){
                    if(s.charAt(i) == '['){
                        quoteCount++;
                    } else if(s.charAt(i) == ']') {
                        if(quoteCount == 0) {
                            String nestedStr = decodeString(s.substring(start, i)); // recursively process the nested segment
                            while(times-- > 0){
                                sb.append(nestedStr); // append to result string the given times
                            }
                            break;
                        } else {
                            quoteCount--;
                        }
                    }
                }
            } else if(Character.isLetter(c)) {
                sb.append(c);
            }
        }
        
        return sb.toString();
    }
}
